package cn.iotat.producer.service.impl;

import cn.iotat.producer.config.BizConfig;
import cn.iotat.producer.converter.ItemConverter;
import cn.iotat.producer.dao.ItemDAO;
import cn.iotat.producer.faced.api.ItemService;
import cn.iotat.producer.faced.common.ErrorCodeEnum;
import cn.iotat.producer.faced.request.model.ItemAddRequest;
import cn.iotat.producer.faced.request.model.ItemUpdateRequest;
import cn.iotat.producer.faced.response.BaseResponse;
import cn.iotat.producer.faced.response.PageData;
import cn.iotat.producer.faced.response.model.ItemInfo;
import cn.iotat.producer.model.Item;
import cn.iotat.producer.util.log.LoggerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 对外接口的实现类
 */
@RestController
public class ItemServiceImpl implements ItemService {
    /**
     * 自定义日志（由于日志配置文件限制，只能使用这种方式进行自定义日志输出）
     * 其余日志请参考{@link cn.iotat.producer.aop.AbstractAspectConfig}及其实现类
     */
    static final LoggerUtil LOG = new LoggerUtil(ItemServiceImpl.class);
    @Autowired
    private ItemDAO itemDAO;
    /**
     * nacos配置注入
     */
    @Autowired
    private BizConfig config;

    @Override
    public BaseResponse<Boolean> addNewItem(ItemAddRequest itemAddRequest) {
        Item item = ItemConverter.itemRequest2Item(itemAddRequest);
        boolean result = itemDAO.addNewItem(item) > 0;
        return BaseResponse.success(result);
    }

    /**
     * 获取全部的item
     *
     * @param pageNum  页码
     * @param pageSize 页长
     * @return 包含全部item的列表
     */
    @Override
    public BaseResponse<PageData<ItemInfo>> getAllItem(int pageNum, int pageSize) {
        if (!config.isCanGetAllItem()) {
            LOG.error("isCanGetAllItem is false");
            return BaseResponse.error(ErrorCodeEnum.SWITCH_OFF);
        }
        List<Item> itemList = itemDAO.getAllItem(pageNum, pageSize);
        int totalCount = itemDAO.getAllItemCount();
        List<ItemInfo> itemInfoList = ItemConverter.batchItem2ItemInfo(itemList);
        return BaseResponse.pageResponse(itemInfoList, pageNum, pageSize, totalCount);
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
     * @param itemUpdateRequest item更新请求
     * @return 是否更新成功
     */
    @Override
    public BaseResponse<Boolean> updateItem(ItemUpdateRequest itemUpdateRequest) {
        long id = itemUpdateRequest.getId();
        if (id <= 0) {
            // id没有传则会抛出异常
            return BaseResponse.error(ErrorCodeEnum.HAVE_NO_ID);
        }
        Item item = ItemConverter.itemRequest2Item(itemUpdateRequest);
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
