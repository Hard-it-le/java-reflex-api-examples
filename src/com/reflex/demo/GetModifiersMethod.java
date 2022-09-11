package com.reflex.demo;

import java.lang.reflect.Modifier;

/**
 * @author 余嘉乐
 * @date 2022/09/11
 * 反射获取类的修饰符方法，比如 public、private、protected
 **/
public class GetModifiersMethod {
    public static void main(String[] args) {
        try {
            Class<?> aClass = Class.forName("com.reflex.demo.Person");
            //获得修饰符
            int modifiers = aClass.getModifiers();
            //使用Modifier转换为相应的字符串
            System.out.println("通过反射获取类的修饰符："+ Modifier.toString(modifiers));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}