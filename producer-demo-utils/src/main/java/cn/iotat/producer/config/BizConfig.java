package cn.iotat.producer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * nacos配置中心展示类
 * 一定要加上@RefreshScope注解，不然无法实时更新配置
 *
 * @author pang
 */
@Component
@RefreshScope
public class BizConfig {

    /**
     * 注意@Value的参数必须要为 配置名:默认值 的形式
     * 不然会报错
     */
    @Value("${availableGetAll:false}")
    private boolean canGetAllItem;

    public boolean isCanGetAllItem() {
        return canGetAllItem;
    }

    public void setCanGetAllItem(boolean canGetAllItem) {
        this.canGetAllItem = canGetAllItem;
    }
}
