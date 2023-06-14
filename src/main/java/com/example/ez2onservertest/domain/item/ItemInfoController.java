package com.example.ez2onservertest.domain.item;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ItemInfoController {

    @GetMapping("/music/{musicNumber}")
    public String itemInfo(@PathVariable("musicNumber")int musicNumber) {

        System.out.println("true = " + musicNumber);


        return "item-info";
    }
}
