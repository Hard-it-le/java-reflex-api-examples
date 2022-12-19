package com.reflex.demo;

/**
 * @author 余嘉乐
 * @date 2022/09/11
 * 获取反射类的三种方法
 **/
public class GetClassMethod {

    public static void main(String[] args) {
        getClassMethod01();
        System.out.println("================================================================");
        getClassMethod02();
        System.out.println("================================================================");
        getClassMainMethod();
    }


    /**
     * 反射获取方法一：通过 new 对象，然后使用对象 .getClass 来使用
     */
    public static void getClassMethod01(){
        Person person = new Person();
        System.out.println("使用 对象.getClass 来使用反射前的 Person：" + person);
        Class<? extends Person> aClass = person.getClass();
        System.out.println("使用 对象.getClass 来使用反射后的 Person：" + aClass);
    }


    /**
     * 反射获取方法二：直接使用类.class 来使用
     */
    public static void getClassMethod02(){
        Class<Person> personClass = Person.class;
        System.out.println("使用 类.class 反射后的 Person：" + personClass);
    }

    /**
     * 反射获取方法三（推荐使用）：使用 Class.forName()。forName 中包含需要反射的包路径和包名
     */
    public static void getClassMainMethod(){
        System.out.println("使用 Class.forName() 来使用反射前的 Person：" + Class.class);
        try {
            Class<?> aClass = Class.forName("com.reflex.demo.Person");
            System.out.println("使用 Class.forName(com.yjl.reflection.Person) 来使用反射前的 Person：" + aClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}