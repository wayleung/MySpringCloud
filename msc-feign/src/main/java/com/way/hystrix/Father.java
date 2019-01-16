package com.way.hystrix;

/**
 * @Auther: Way Liang
 * @Date: 12/28/2018 17:30
 * @Description:
 */
public class Father {

    static {
        System.out.println("static");
    }


    {
        System.out.println("dynamic");
    }

    public void method1(){

    }

    public final void method2(){

    }
}
