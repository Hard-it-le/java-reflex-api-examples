package com.reflex;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PrivateMethodAccess {
    public static void main(String[] args) {
        try {
            getPrivateMethod();
            modifyPrivateFiled();
            modifyFinalFiled();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 访问对象的私有方法
     */
    private static void getPrivateMethod() throws Exception {

        final Class<?> aClass = Class.forName("com.reflex.demo.PrivateClass");
        PrivateClass privateClass = new PrivateClass();

        //2. 获取私有方法
        //第一个参数为要获取的私有方法的名称
        //第二个为要获取方法的参数的类型，参数为 Class...，没有参数就是null
        //方法参数也可这么写 ：new Class[]{String.class , int.class}
        Method privateMethod =
                aClass.getDeclaredMethod("privateMethod", String.class, int.class);

        System.out.println(privateMethod);
        //3. 开始操作方法
        //获取私有方法的访问权
        //只是获取访问权，并不是修改实际权限
        privateMethod.setAccessible(true);

        //使用 invoke 反射调用私有方法
        //privateMethod 是获取到的私有方法
        //PrivateClass 要操作的对象
        //后面两个参数传实参
        privateMethod.invoke(privateClass, "Java Reflect ", 666);
    }

    /**
     * 修改对象私有变量的值
     *
     */
    private static void modifyPrivateFiled() throws Exception {
        final Class<?> aClass = Class.forName("com.reflex.demo.PrivateClass");
        PrivateClass privateClass = new PrivateClass();

        //2. 获取私有变量
        Field privateField = aClass.getDeclaredField("MSG");

        //3. 操作私有变量
        //获取私有变量的访问权
        privateField.setAccessible(true);

        //修改私有变量，并输出以测试
        System.out.println("Before Modify：MSG = " + privateClass.getMsg());

        //调用 set(object , value) 修改变量的值
        //privateField 是获取到的私有变量
        //privateClass 要操作的对象
        //"Modified" 为要修改成的值
        privateField.set(privateClass, "Modified");
        System.out.println("After Modify：MSG = " + privateClass.getMsg());
    }


    /**
     * 修改对象私有常量的值
     *
     */
    private static void modifyFinalFiled() throws Exception {
        //1. 获取 Class 类实例
        final Class<?> aClass = Class.forName("com.reflex.demo.PrivateClass");
        PrivateClass privateClass = new PrivateClass();

        //2. 获取私有常量
        Field finalField = aClass.getDeclaredField("FINAL_VALUE");

        //3. 修改常量的值

        //获取私有常量的访问权
        finalField.setAccessible(true);

        //调用 finalField 的 getter 方法
        //输出 FINAL_VALUE 修改前的值
        System.out.println("Before Modify：FINAL_VALUE = "
                + finalField.get(privateClass));

        //修改私有常量
        finalField.set(privateClass, "Modified");

        //调用 finalField 的 getter 方法
        //输出 FINAL_VALUE 修改后的值
        System.out.println("After Modify：FINAL_VALUE = "
                + finalField.get(privateClass));

        //使用对象调用类的 getter 方法
        //获取值并输出
        System.out.println("Actually ：FINAL_VALUE = "
                + privateClass.getFinalValue());
    }
}