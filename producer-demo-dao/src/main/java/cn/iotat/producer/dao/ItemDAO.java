package cn.iotat.producer.dao;

import cn.iotat.producer.model.Item;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 项目DAO层，负责数据库操作，最好一个表一个接口
 *
 * @author pang
 */
public interface ItemDAO {
    /**
     * 添加新的item
     *
     * @param item item
     * @return 影响行数
     */
    int addNewItem(Item item);

    /**
     * 获取全部的item
     *
     * @return 包含全部item的列表
     */
    List<Item> getAllItem(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);

    /**
     * 获取item总数
     *
     * @return item总数
     */
    int getAllItemCount();

    /**
     * 根据id获取item
     *
     * @param itemId itemId
     * @return item
     */
    Item getItemById(long itemId);

    /**
     * 更新item
     *
     * @param item item
     * @return 影响行数
     */
    int updateItem(Item item);

    /**
     * 删除item
     *
     * @param itemId itemId
     * @return 影响行数
     */
    int deleteItem(long itemId);
}
