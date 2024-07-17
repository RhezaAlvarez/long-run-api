package com.example.LongRunAPI.service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    private ScheduledExecutorService scheduler1;
    private ScheduledExecutorService scheduler2;

    @Async("asyncExecutor")
    public void startTask1() {
        scheduler1 = Executors.newScheduledThreadPool(1);
        scheduler1.scheduleAtFixedRate(this::logTask1, 0, 5, TimeUnit.SECONDS);
    }

    @Async("asyncExecutor")
    public void startTask2() {
        scheduler2 = Executors.newScheduledThreadPool(1);
        scheduler2.scheduleAtFixedRate(this::logTask2, 0, 5, TimeUnit.SECONDS);
    }

    public void stopTask1() {
        if (scheduler1 != null && !scheduler1.isShutdown()) {
            scheduler1.shutdown();
        }
    }

    public void stopTask2() {
        if (scheduler2 != null && !scheduler2.isShutdown()) {
            scheduler2.shutdown();
        }
    }

    private void logTask1() {
        System.out.println("Task 1 - Log message at: " + System.currentTimeMillis());
    }

    private void logTask2() {
        System.out.println("Task 2 - Log message at: " + System.currentTimeMillis());
    }
}
