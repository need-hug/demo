package com.soft.demo.validation;

import com.soft.demo.validation.entity.User;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.Validator;
import java.util.Iterator;
import java.util.Set;

/** java bean实体参数验证
 * @Auther: lps
 * DateTime: 2019/2/27 17:35
 * @Version: 1.0
 */
public class BeanValidationDemo<T> {

    public static Validator validator = null;

    /**
     * 使用单例模式创建构造器
     * @return javax.validation.Validator
     */
    public synchronized static Validator getValidator() {
        if (validator == null) {
          BeanValidationDemo.validator = Validation.buildDefaultValidatorFactory().getValidator();
        }
        return BeanValidationDemo.validator;
    }

    public static void main(String[] args) throws ValidationException {
        // 获得验证器
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

        User user = new User("ssf","sdf");

        // 执行验证
        Set<ConstraintViolation<User>> validators = validator.validate(user);
        // 打印验证信息
        for (ConstraintViolation<User> constraintViolations: validators) {
            System.out.println(constraintViolations.getMessage());
        }
        // 如果验证不成功，则将第一个取出来包装成异常返回
        ConstraintViolation constraintViolation = getFirst(validators);
        if (null == validators) {
            throw new ValidationException(constraintViolation.getMessage(), null);
        }
    }

    private static ConstraintViolation getFirst(Set<ConstraintViolation<User>> validators) {
        Iterator<ConstraintViolation<User>> iterable = validators.iterator();
        return iterable.next();
    }

    public void beanValidation(T t) {

    }


}
