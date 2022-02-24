package com.example.BT5.controller;

import com.example.BT5.model.Item;
import com.example.BT5.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;


    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listItems", itemService.getAllItems());
        return "index";
    }

    @GetMapping("/addItem")
    public String addItem(Model model){
        Item item = new Item();
        model.addAttribute("item", item);
        return "new_item";
    }

    @PostMapping("/saveItem")
    public String saveItem(@ModelAttribute("item") Item item){
        itemService.saveItem(item);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormUpdate(@PathVariable("id") int id, Model model){
        Item item = itemService.getItemById(id);
        model.addAttribute("item", item);
        return "update_item";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteItem(@PathVariable("id") int id){
        itemService.deleteItemById(id);
        return "redirect:/";
    }
}
