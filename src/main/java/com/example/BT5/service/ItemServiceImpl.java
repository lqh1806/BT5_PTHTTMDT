package com.example.BT5.service;

import com.example.BT5.model.Item;
import com.example.BT5.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private ItemRepository itemRepository;


    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    @Override
    public Item getItemById(int id) {
        Optional<Item> itemOptional = itemRepository.findById(id);
        if(itemOptional.isPresent()){
            return itemRepository.getById(id);
        }
        else{
            throw new RuntimeException("Can not find item");
        }
    }

    @Override
    public void deleteItemById(int id) {
        Optional<Item> itemOptional = itemRepository.findById(id);
        if(itemOptional.isPresent()){
            itemRepository.deleteById(id);
        }
        else{
            throw new RuntimeException("Can not find item");
        }
    }
}
