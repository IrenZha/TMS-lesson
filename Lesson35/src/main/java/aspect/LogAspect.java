package aspect;

import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
    @Pointcut("execution(public * service.RunService.run(..))")
    public void pointcut1() {
    }

@SneakyThrows
@Before("pointcut1()")
    public void printMassageStart() {
    System.out.println("-----------------------------------------------");
    System.out.println("                      3");
    Thread.sleep(1000);
    System.out.println("                      2");
    Thread.sleep(1000);
    System.out.println("                      1");
    Thread.sleep(1000);
    System.out.println("--------------------START---------------------");
    }

    @Pointcut("@annotation(config.Benchmark)")
    public void pointcut2() {
    }
@SneakyThrows
@Around("pointcut2()")
    public void timer(ProceedingJoinPoint joinPoint){
    long start = System.nanoTime();
    long end = System.nanoTime();
    String name = joinPoint.getSignature().getName();
    System.out.println("Bench time for " + name + " = " + (end - start));
}
}
