package cn.iotat.producer.faced.api;

import cn.iotat.producer.faced.request.model.ItemAddRequest;
import cn.iotat.producer.faced.request.model.ItemUpdateRequest;
import cn.iotat.producer.faced.response.BaseResponse;
import cn.iotat.producer.faced.response.PageData;
import cn.iotat.producer.faced.response.model.ItemInfo;
import org.springframework.web.bind.annotation.*;

/**
 * 该类是系统向外提供的接口，类似SpringBoot中的Controller
 * 与Controller不同的是，此处使用接口而不是实现类，
 * 这样当其他系统引入我们系统的faced模块来进行远程调用的时候，
 * 外部系统不需要知道我们的实现细节，这也印证了面向对象编程的封装特性
 * 另外，此处同样使用了@RequestMapping这个注解，该注解具有继承性，
 * 实现了该接口的类会自动添加该注解
 *
 * @author pang
 */
@RequestMapping("/api/v1/item")
public interface ItemService {

    /**
     * 添加新的item
     *
     * @param itemAddRequest item新增请求
     * @return 是否添加成功
     */
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    BaseResponse<Boolean> addNewItem(@RequestBody ItemAddRequest itemAddRequest);

    /**
     * 获取全部的item
     *
     * @param pageNum  页码
     * @param pageSize 页长
     * @return 包含全部item的列表
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    BaseResponse<PageData<ItemInfo>> getAllItem(@RequestParam int pageNum, @RequestParam int pageSize);

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
     * @param itemFormRequest item更新请求
     * @return 是否更新成功
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    BaseResponse<Boolean> updateItem(@RequestBody ItemUpdateRequest itemFormRequest);

    /**
     * 删除item
     *
     * @param id item的id
     * @return 是否删除成功
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    BaseResponse<Boolean> deleteItem(@PathVariable long id);
}
