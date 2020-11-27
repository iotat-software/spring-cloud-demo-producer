package cn.iotat.producer.service.impl;

import cn.iotat.producer.converter.ItemConverter;
import cn.iotat.producer.dao.ItemDAO;
import cn.iotat.producer.faced.api.ItemService;
import cn.iotat.producer.faced.request.model.ItemForm;
import cn.iotat.producer.faced.response.BaseResponse;
import cn.iotat.producer.faced.response.ErrorCodeEnum;
import cn.iotat.producer.faced.response.model.ItemInfo;
import cn.iotat.producer.model.Item;
import cn.iotat.producer.config.BizConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemDAO itemDAO;
    @Autowired
    private BizConfig config;

    /**
     * 添加新的item
     *
     * @param itemForm item表单
     * @return 是否添加成功
     */
    @Override
    public BaseResponse<Boolean> addNewItem(ItemForm itemForm) {
        Item item = ItemConverter.itemForm2Item(itemForm);
        boolean result = itemDAO.addNewItem(item) > 0;
        return BaseResponse.success(result);
    }

    /**
     * 获取全部的item
     *
     * @return 包含全部item的列表
     */
    @Override
    public BaseResponse<List<ItemInfo>> getAllItem() {
        if (!config.isCanGetAllItem()){
            return BaseResponse.error(ErrorCodeEnum.SWITCH_OFF);
        }
        List<Item> itemList = itemDAO.getAllItem();
        List<ItemInfo> itemInfoList = ItemConverter.batchItem2ItemInfo(itemList);
        return BaseResponse.success(itemInfoList);
    }

    /**
     * 根据id获取item
     *
     * @param id item 的 id
     * @return item信息
     */
    @Override
    public BaseResponse<ItemInfo> getItemById(long id) {
        Item item = itemDAO.getItemById(id);
        ItemInfo itemInfo = ItemConverter.item2ItemInfo(item);
        return BaseResponse.success(itemInfo);
    }

    /**
     * 更新item
     *
     * @param itemForm item表单
     * @return 是否更新成功
     */
    @Override
    public BaseResponse<Boolean> updateItem(ItemForm itemForm) {
        long id = itemForm.getId();
        if (id <= 0) {
            // id没有传则会抛出异常
            return BaseResponse.error(ErrorCodeEnum.HAVE_NO_ID);
        }
        Item item = ItemConverter.itemForm2Item(itemForm);
        boolean result = itemDAO.updateItem(item) > 0;
        return BaseResponse.success(result);
    }

    /**
     * 删除item
     *
     * @param id item的id
     * @return 是否删除成功
     */
    @Override
    public BaseResponse<Boolean> deleteItem(long id) {
        boolean result = itemDAO.deleteItem(id) > 0;
        return BaseResponse.success(result);
    }
}
