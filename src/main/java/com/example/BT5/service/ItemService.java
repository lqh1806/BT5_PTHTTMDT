package com.example.BT5.service;

import com.example.BT5.model.Item;

import java.util.List;

public interface ItemService {

    List<Item> getAllItems();

    void saveItem(Item item);

    Item getItemById(int id);

    void deleteItemById(int id);

}
