package com.soft.demo.util;

/** 实体类操作
 * @Auther: lps
 * DateTime: 2019/4/18 11:42
 * @Version: 1.0
 */
public class BeanUtils {

    /**
     * 获取对象中属性为null的属性名
     * @param source 要拷贝的对象
     */
    public static String[] getNullPropertyNames(Object source) {
        final org.springframework.beans.BeanWrapper beanWrapper = new org.springframework.beans.BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = beanWrapper.getPropertyDescriptors();

        java.util.Set<String> emptyNames = new java.util.HashSet<>();

        for (java.beans.PropertyDescriptor pd : pds) {

            Object beanWrapperValue = beanWrapper.getPropertyValue(pd.getName());

            if (beanWrapperValue == null) {
                emptyNames.add(pd.getName());
            }
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

    /**
     * 拷贝非空对象的属性值
     * @param source 源对象
     * @param target 目标对象
     */
    public static void copyPropertiesIgnoreNull(Object source, Object target) {
        org.springframework.beans.BeanUtils.copyProperties(source, target, getNullPropertyNames(source));
    }

}
