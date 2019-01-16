package com.way.hystrix;

/**
 * @Auther: Way Liang
 * @Date: 12/28/2018 17:31
 * @Description:
 */
public class Son extends Father {
    @Override
    public void method1() {
        super.method1();
    }

    public static void main(String[] args) {
        Father father  = new Father();
    }
}
