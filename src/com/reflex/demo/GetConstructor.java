package com.reflex.demo;

import java.lang.reflect.Constructor;

/**
 * @author 余嘉乐
 * @date 2022/09/11
 * 反射获取类的构造函数
 **/
public class GetConstructor {
    public static void main(String[] args) {
        try {
            Class<?> aClass = Class.forName("com.reflex.demo.Person");

            //1、获取所有的public权限的构造器(getConstructors)
            Constructor<?>[] constructors = aClass.getConstructors();

            //注意查看构造器的顺序
            for (Constructor<?> constructor : constructors) {
                System.out.println("获取所有的public权限的构造器getConstructors:" + constructor);
            }
            System.out.println("-===============================");

            //2、获取所有的构造器(getDeclaredConstructors)
            Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
            for (Constructor<?> declaredConstructor : declaredConstructors) {
                System.out.println("获取所有的构造器getDeclaredConstructors:" + declaredConstructor);
            }
            System.out.println("-===============================");


            //3、获取指定的构造器(放入具体的类型)
            Constructor<?> constructor = aClass.getConstructor();
            System.out.println("获取指定的构造器(放入具体的类型):" + constructor);
            System.out.println("-===============================");
            //非public权限
            Constructor<?> declaredConstructor = aClass.getDeclaredConstructor();
            System.out.println("获取指定的构造器(放入具体的类型):" + declaredConstructor);
            System.out.println("-===============================");

        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}