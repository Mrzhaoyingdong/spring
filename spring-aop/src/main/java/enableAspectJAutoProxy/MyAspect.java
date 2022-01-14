package enableAspectJAutoProxy;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 *  @Description: 切面
 *  @author: zhao_yd
 *  @Date: 2021/2/6 1:32 下午
 *
 */

@Component
@Aspect
public class MyAspect {

    @Pointcut("execution (* *..*(..))")
    public void pc(){}

    @Before("pc()")
    public void befor(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        Object target = joinPoint.getTarget();
        System.out.println("我是前置通知，target:" +target);
    }

    @Around("pc()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("@Around通知start");
        Object result = joinPoint.proceed();
        System.out.println("@Around绕通知end");
        return result;
    }

    @After("pc()")
    public void after() throws Throwable {
        System.out.println("@After通知!");
    }

    @AfterReturning("pc()")
    public void afterReturning() throws Throwable {
        System.out.println("@AfterReturning通知!");
    }

    @AfterThrowing("pc()")
    public void afterThrowing() {
        System.out.println("@AfterThrowing通知!");
    }
}
