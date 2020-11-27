package cn.iotat.producer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
public class BizConfig {

    @Value("${availableGetAll:false}")
    private boolean canGetAllItem;

    public boolean isCanGetAllItem() {
        return canGetAllItem;
    }

    public void setCanGetAllItem(boolean canGetAllItem) {
        this.canGetAllItem = canGetAllItem;
    }
}
