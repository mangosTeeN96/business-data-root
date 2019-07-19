package com.uestc.common;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by fucheng on 2018/4/29.
 * 对象复制
 */
public class FillUtil {

    private static ConcurrentHashMap<Class, Field[]> cache = new ConcurrentHashMap<>();

    public static Field[] getPropertiesWithCache(Class type) {
        if (!cache.containsKey(type)) {
            if (!cache.containsKey(type)) {
                cache.put(type, type.getDeclaredFields());
            }
        }
        return cache.get(type);
    }

    public static <T> T fill(Object source, Class<T> targetClass) throws Exception {
        //获取源的所以属性
        T t = null;
        try {
            t = targetClass.newInstance();
           /* Field[]  sourceField = source.getClass().getDeclaredFields();//source.getClass().getDeclaredFields();获取源的全部属性
            Field[]  targetField = t.getClass().getDeclaredFields();//获取目标的全部属性*/
            Field[] sourceField = getPropertiesWithCache(source.getClass());//source.getClass().getDeclaredFields();获取源的全部属性
            Field[] targetField = getPropertiesWithCache(t.getClass());//获取目标的全部属性*/
            int times = 0;//填充次数，用于优化for执行次数
            for (int x = 0; x < targetField.length; x++) {
                String targetName = targetField[x].getName().toString();
                for (int y = 0; y < sourceField.length; y++) {
                    String sourceName = sourceField[y].getName().toString();
                    if (targetName.equals(sourceName)) {
                        fillMark(source, t, sourceName, targetField[x].getType());
                        times++;
                    }
                }
                //System.out.println("执行了"+times+"次");
                if (times == sourceField.length) {//如果执行次数等于view传入的参数属性个数标识填充完成 将跳出循环
                    break;
                }
            }
        } catch (Exception ex) {

            throw new Exception();
        }
        return t;
    }

    public static HashMap<String, Object> ToMap(Object source) {
        HashMap<String, Object> map = new HashMap<>();
        for (Field prop : getPropertiesWithCache(source.getClass())) {
            if (prop != null) {
                try {
                    String methodName = prop.getName().substring(0, 1).toUpperCase() + prop.getName().substring(1);
                    Method m = source.getClass().getMethod("get" + methodName);
                    map.put(prop.getName(), m.invoke(source));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return map;
    }

    //执行填充
    public static void fillMark(Object source, Object target, String fieldName, Class fieldClass) throws Exception {
        Class<? extends Object> sourceClass = source.getClass();
        Class<? extends Object> targetClass = target.getClass();

        //fieldName -> FieldName
        String methodName = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
        Method methodGet = null;
        Method methodSet = null;
        try {
            methodGet = sourceClass.getMethod("get" + methodName);
            Object value = methodGet.invoke(source);//执行方法获取Obect对象

            methodSet = targetClass.getMethod("set" + methodName, fieldClass);
            methodSet.invoke(target, value);
        } catch (Exception e) {

            throw e;
        }
    }
}
