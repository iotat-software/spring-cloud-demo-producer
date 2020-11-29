package cn.iotat.producer.converter;

import cn.iotat.producer.faced.request.model.ItemAddRequest;
import cn.iotat.producer.faced.request.model.ItemUpdateRequest;
import cn.iotat.producer.faced.response.model.ItemInfo;
import cn.iotat.producer.model.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据转换工具类，该包下的类均为用于数据模型相互转换
 *
 * @author pang
 */
public class ItemConverter {

    public static Item itemRequest2Item(ItemAddRequest itemAddRequest) {
        Item item = new Item();
        item.setItemName(itemAddRequest.getName());
        item.setItemId(itemAddRequest.getId());
        return item;
    }

    public static Item itemRequest2Item(ItemUpdateRequest itemUpdateRequest) {
        Item item = new Item();
        item.setItemName(itemUpdateRequest.getName());
        item.setItemId(itemUpdateRequest.getId());
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
        // 这里使用了lambda表达式，也可替换为普通的for循环
        itemList.forEach(item -> {
            ItemInfo itemInfo = item2ItemInfo(item);
            itemInfoList.add(itemInfo);
        });
        return itemInfoList;
    }
}
