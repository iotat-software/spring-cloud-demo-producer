package cn.iotat.producer.dao;

import cn.iotat.producer.model.Item;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class ItemDAOTest {
    @Autowired
    private ItemDAO itemDAO;


    private Item item = new Item();

    @Before
    public void init() {
        item.setItemId(1);
        item.setItemName("hello");
    }

    @Test
    @Rollback
    public void addNewItem() {
        int i = itemDAO.addNewItem(item);
        Assert.assertEquals(i, 1);
    }

    @Test
    @Rollback
    public void updateItem(){
        Item itemTemp = itemDAO.getItemById(item.getItemId());
        item.setItemName("world");
        Assert.assertNotEquals(itemTemp,item);
        int i = itemDAO.updateItem(item);
        Assert.assertEquals(i,1);
        itemTemp = itemDAO.getItemById(item.getItemId());
        Assert.assertEquals(item,itemTemp);
    }

    @Test
    @Rollback
    public void deleteItem(){
        Item item1 = itemDAO.getItemById(item.getItemId());
        Assert.assertNotNull(item1);
        int i = itemDAO.deleteItem(item1.getItemId());
        Assert.assertEquals(i,1);
        Item item2 = itemDAO.getItemById(item.getItemId());
        Assert.assertNull(item2);

    }
}