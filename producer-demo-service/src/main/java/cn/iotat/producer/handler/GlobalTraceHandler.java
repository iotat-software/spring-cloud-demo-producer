package cn.iotat.producer.handler;

import brave.Tracer;
import cn.iotat.producer.constant.Constant;
import cn.iotat.producer.util.log.LoggerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 全局traceId处理
 * 主要是需要traceId传给C端系统
 * 方便进行日志查询等操作
 * <p>
 * ResponseBodyAdvice指对响应体进行更改，此处是新增一个响应头Trace
 *
 * @author pang
 */
@ControllerAdvice
@ResponseBody
public class GlobalTraceHandler implements ResponseBodyAdvice<Object> {
    static final LoggerUtil LOG = new LoggerUtil(GlobalTraceHandler.class);
    /**
     * tracer是zipkin的注入对象，可以通过该对象获取当前的traceId
     */
    @Autowired
    private Tracer tracer;

    /**
     * 写入结果之前的操作
     *
     * @param o responseBody
     * @return responseBody
     */
    @Override
    public Object beforeBodyWrite(Object o,
                                  MethodParameter methodParameter,
                                  MediaType mediaType,
                                  Class<? extends HttpMessageConverter<?>> aClass,
                                  ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse) {
        HttpHeaders headers = serverHttpResponse.getHeaders();
        headers.add(Constant.TRACE, tracer.currentSpan().context().traceIdString());
        return o;
    }

    /**
     * 相应提是否执行该类的拦截操作
     *
     * @param methodParameter 方法参数
     * @param aClass          默认转换器
     * @return 返回true为执行，返回false为不执行
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

}
