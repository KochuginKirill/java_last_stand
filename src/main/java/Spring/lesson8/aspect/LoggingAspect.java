package Spring.lesson8.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j // Slf4j - Simple logging facade for java
@Aspect
@Component
public class LoggingAspect {

  // Before
  // AfterThrowing
  // AfterReturning
  // After = AfterReturning + AfterThrowing
  // Around ->

//  Bean = TimesheetService, obj = timesheetService
  // proxyTimesheetService(obj)

  @Pointcut("execution(* Spring.lesson8.*.*.*(..))")
  public void lesson8Pointcut() {
  }

//   Pointcut - точка входа в аспект
  @Before(value = "lesson8Pointcut()")
  public void beforeTimesheetServiceFindById(JoinPoint jp) {
    Object[] signatureArgs = jp.getArgs();
    for (Object signatureArg: signatureArgs) {
      System.out.println("Arg: " + signatureArg);
    }
  }

//  @AfterThrowing(value = "timesheetServiceMethodsPointcut()", throwing = "ex")
//  public void afterTimesheetServiceFindById(JoinPoint jp, Exception ex) {
//    String methodName = jp.getSignature().getName();
//    log.info("AfterThrowing -> TimesheetService#{} -> {}", methodName, ex.getClass().getName());
//  }

}
