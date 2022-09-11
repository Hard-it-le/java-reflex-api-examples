package com.reflex.demo;

/**
 * @author 余嘉乐
 * @date 2022/09/11
 **/
public class PrivateClass {
    private String MSG = "Original";

    private final String FINAL_VALUE = "hello";


    private void privateMethod(String head, int tail) {
        System.out.print(head + tail);
    }

    public String getMsg() {
        return MSG;
    }

    public String getFinalValue() {
        return FINAL_VALUE;
    }
}