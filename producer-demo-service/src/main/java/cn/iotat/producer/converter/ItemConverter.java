package cn.iotat.producer.converter;

import cn.iotat.producer.faced.request.model.ItemForm;
import cn.iotat.producer.faced.response.model.ItemInfo;
import cn.iotat.producer.model.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemConverter {
    public static Item itemForm2Item(ItemForm itemForm) {
        Item item = new Item();
        item.setItemName(itemForm.getName());
        item.setItemId(itemForm.getId());
        return item;
    }

    public static ItemInfo item2ItemInfo(Item item) {
        ItemInfo itemInfo = new ItemInfo();
        itemInfo.setId(item.getItemId());
        itemInfo.setName(item.getItemName());
        return itemInfo;
    }

    public static List<ItemInfo> batchItem2ItemInfo(List<Item> itemList) {
        List<ItemInfo> itemInfoList = new ArrayList<>(itemList.size());
        itemList.forEach(item -> {
            ItemInfo itemInfo = item2ItemInfo(item);
            itemInfoList.add(itemInfo);
        });
        return itemInfoList;
    }
}
