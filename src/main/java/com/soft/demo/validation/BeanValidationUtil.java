package com.soft.demo.validation;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.Validator;
import java.util.Iterator;
import java.util.Set;

/** java bean验证工具类
 * @Auther: lps
 * DateTime: 2019/4/2 16:32
 * @Version: 1.0
 */
public class BeanValidationUtil {

    public static Validator validator = null;

    public synchronized static Validator getValidator() {
        if (validator == null) {
            BeanValidationUtil.validator = Validation.buildDefaultValidatorFactory().getValidator();
        }
        return BeanValidationUtil.validator;
    }

    public static <T extends Object> void beanValidation(T t) {
        // 执行验证
        Set<ConstraintViolation<T>> validators = BeanValidationUtil.getValidator().validate(t);
        // 验证不成功 取出第一个返回
        Iterator<ConstraintViolation<T>> iterator = validators.iterator();
        if (iterator.hasNext()) {
            ConstraintViolation<T> constraintViolation = iterator.next();
            throw new ValidationException(constraintViolation.getMessage(), null);
        }
    }

}
