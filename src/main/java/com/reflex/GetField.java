package com.reflex;

import java.lang.reflect.Field;

/**
 * 反射获取类的所有的字段信息
 **/
public class GetField {
    public static void main(String[] args) {
        try {
            Class<?> aClass = Class.forName("com.reflex.Person");
            System.out.println("+============");
            //获取全部字段
            Field[] declaredFields = aClass.getDeclaredFields();
            for (Field declaredField : declaredFields) {
                int modifiers = declaredField.getModifiers();
                System.out.println("字段的修饰符：" + modifiers);
                Class<?> type = declaredField.getType();
                System.out.println("字段的类型：" + type);
                String name = declaredField.getName();
                System.out.println("字段的名字：" + name);
                System.out.println("================");
            }
            System.out.println("--------------------");
            Field[] fields = aClass.getFields();
            if (fields.length > 0) {
                for (Field field : fields) {
                    System.out.println("字段的所有属性：" + field);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}