package cn.iotat.producer.faced.api;

import cn.iotat.producer.faced.request.model.ItemForm;
import cn.iotat.producer.faced.response.BaseResponse;
import cn.iotat.producer.faced.response.model.ItemInfo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RequestMapping("/api/v1/item")
public interface ItemService {

    /**
     * 添加新的item
     *
     * @param itemForm item表单
     * @return 是否添加成功
     */
    @RequestMapping(method = RequestMethod.POST)
    BaseResponse<Boolean> addNewItem(@RequestBody ItemForm itemForm);

    /**
     * 获取全部的item
     *
     * @return 包含全部item的列表
     */
    @RequestMapping(method = RequestMethod.GET)
    BaseResponse<List<ItemInfo>> getAllItem();

    /**
     * 根据id获取item
     *
     * @param id item 的 id
     * @return item信息
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    BaseResponse<ItemInfo> getItemById(@PathVariable long id);

    /**
     * 更新item
     *
     * @param itemForm item表单
     * @return 是否更新成功
     */
    @RequestMapping(method = RequestMethod.PUT)
    BaseResponse<Boolean> updateItem(@RequestBody ItemForm itemForm);

    /**
     * 删除item
     *
     * @param id item的id
     * @return 是否删除成功
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    BaseResponse<Boolean> deleteItem(long id);
}
