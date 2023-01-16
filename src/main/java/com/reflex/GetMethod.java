package com.reflex;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 反射获取类的方法的方法
 **/
public class GetMethod {
    public static void main(String[] args) {
        try {
            Class<?> aClass = Class.forName("com.reflex.Person");
            //获取 Person 类的全部方法
            Method[] methods = aClass.getMethods();
            for (Method method : methods) {
                //方法的修饰符
                int modifiers = method.getModifiers();
                //方法的返回值类型
                Class<?> returnType = method.getReturnType();
                //方法的方法名
                String name = method.getName();
                //方法参数
                System.out.println("修饰符：" + modifiers + ";" + "返回值类型：" + returnType + ";" + "方法名：" + name + ";");
                System.out.println("==================");
                Class<?>[] parameterTypes = method.getParameterTypes();
                System.out.println( "方法参数" + Arrays.toString(parameterTypes));
            }

            System.out.println("================================================");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}