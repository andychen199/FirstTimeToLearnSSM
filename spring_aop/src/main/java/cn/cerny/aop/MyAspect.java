package cn.cerny.aop;

public class MyAspect {
    public void Before(){
        System.out.println("前置增强。");
    }
    public void After(){
        System.out.println("后置增强");
    }
}
