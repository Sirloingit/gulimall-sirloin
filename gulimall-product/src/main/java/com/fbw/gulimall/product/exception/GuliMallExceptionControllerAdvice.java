package com.fbw.gulimall.product.exception;

import com.fbw.common.exception.BizCodeExceptionEnum;
import com.fbw.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sirloin
 * @Date 2021-02-2021/2/18-22:45
 */
@Slf4j
//@ControllerAdvice(basePackages = "com.fbw.gulimall.product.controller")
//@ResponseBody
@RestControllerAdvice(basePackages = "com.fbw.gulimall.product.controller")
public class GuliMallExceptionControllerAdvice {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handleValidException(MethodArgumentNotValidException e){
        log.error("数据校验出错", e.getMessage(), e.getClass());

        BindingResult bindingResult = e.getBindingResult();
        Map<String, String> map = new HashMap<>();

        bindingResult.getFieldErrors().forEach((item) -> {
            map.put(item.getField(), item.getDefaultMessage());
        });

        return R.error(BizCodeExceptionEnum.VALID_EXCEPTION.getCode(),BizCodeExceptionEnum.VALID_EXCEPTION.getMsg()).put("data",map);
    }

    @ExceptionHandler(value = Throwable.class)
    public R handleException(Throwable throwable){
        System.out.println(throwable.getClass() + throwable.getMessage());
        return R.error(BizCodeExceptionEnum.UNKNOWN_EXCEPTION.getCode(), BizCodeExceptionEnum.UNKNOWN_EXCEPTION.getMsg());
    }
}
