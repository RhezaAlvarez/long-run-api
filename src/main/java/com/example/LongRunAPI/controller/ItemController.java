package com.example.LongRunAPI.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.LongRunAPI.service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
public class ItemController {
    @Autowired
    ItemService itemService;

    @GetMapping("/startTask1")
    public String startTask1() {
        System.out.println(1);
        itemService.startTask1();
        System.out.println(2);
        return "Task 1 started!";
    }

    @GetMapping("/stopTask1")
    public String stopTask1() {
        itemService.stopTask1();
        return "Task 1 stopped!";
    }

    @GetMapping("/startTask2")
    public String startTask2() {
        itemService.startTask2();
        return "Task 2 started!";
    }

    @GetMapping("/stopTask2")
    public String stopTask2() {
        itemService.stopTask2();
        return "Task 2 stopped!";
    }
}
