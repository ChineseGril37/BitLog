package org.lengs.bitlogserver.common;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
/**
 * @Author: lengs
 * @Date: 2024/6/1 13:51
 * @Description: ResponseAdvice实现ResponseBodyAdvice。拦截Controller方法默认返回参数，统一处理响应体
 * @Version: 1.0
 */
@Slf4j
@RestControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice<Object> {
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    @SneakyThrows
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if(body instanceof String){
            try {
                return objectMapper.writeValueAsString(Result.success(body));
            } catch (JsonProcessingException json) {
                log.trace(String.valueOf(json));
            }
            return objectMapper.writeValueAsString(Result.success(body));
        }
        if(body instanceof Result){
            return body;
        }
        return Result.success(body);
    }
}

