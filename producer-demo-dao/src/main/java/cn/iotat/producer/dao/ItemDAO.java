package cn.iotat.producer.dao;

import cn.iotat.producer.model.Item;

import java.util.List;

public interface ItemDAO {
    int addNewItem(Item item);

    List<Item> getAllItem();

    Item getItemById(long itemId);

    int updateItem(Item item);

    int deleteItem(long itemId);
}
