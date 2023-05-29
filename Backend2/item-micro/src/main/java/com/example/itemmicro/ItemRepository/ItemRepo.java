package com.example.itemmicro.ItemRepository;


import com.example.itemmicro.Item.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepo extends JpaRepository<Item,Long> {
}
