package cn.iotat.producer.util.log;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class LoggerUtil {
    private Logger LOG = null;

    public static final LoggerUtil getLogger(Class c) {
        LoggerUtil loggerUtil = new LoggerUtil();
        loggerUtil.LOG = LoggerFactory.getLogger(c);
        return loggerUtil;
    }

    private LoggerUtil() {
    }

    public void debug(String s, Object... o) {
        LOG.debug(s, o);
    }

    public void info(String s, Object... o) {
        LOG.info(s, o);
    }

    public void warn(String s, Object... o) {
        LOG.warn(s, o);
    }

    public void error(String s, Object... o) {
        LOG.error(s, o);
    }

}
