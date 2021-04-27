package cn.cerny.anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component("myAspect")
@Aspect //标注当前MyAspect是一个切面类
public class MyAspect {
    //配置前置通知
    @Before("execution(* cn.cerny.anno.*.*(..))")
    public void Before(){
        System.out.println("前置增强。");
    }

    @AfterReturning("execution(* cn.cerny.anno.*.*(..))")
    public void afterreturning(){
        System.out.println("后置增强。。。");
    }

    //Proceeding JoinPoint：正在执行的连接点==切点
    //@Around("execution(* cn.cerny.anno.*.*(..))")
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint pjp){
        System.out.println("环绕前增强。。");
        Object proceed = null;
        try {
            proceed = pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("环绕后增强。。");
        return proceed;
    }

    public void afterThrowing(){
        System.out.println("异常抛出后增强。。。");
    }


    //@After("execution(* cn.cerny.anno.*.*(..))")
    @After("MyAspect.pointcut()")
    public void After(){
        System.out.println("最终增强");
    }

    //定义切点表达式
    @Pointcut("execution(* cn.cerny.anno.*.*(..))")
    public void pointcut(){}
}
