package org.ssn.app.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EVMLoggingAspectHandler {
  @Autowired
  CustomLogService customLog;

  @Pointcut("within(@org.springframework.stereotype.Repository *)" +
            " || within(@org.springframework.stereotype.Service *)" +
            " || within(@org.springframework.web.bind.annotation.RestController *)")
  public void springImplPointcut() {}

  @Pointcut("within(org.ssn.app..*)" +
            " || within(org.ssn.app.service..*)" +
            " || within(org.ssn.app.controller..*)")
  public void applicationPointCut() {}

  @Pointcut("@annotation(org.ssn.app.config.CustomLogged)")
  public void customAnnotationPointCut() {}

  @Around("springImplPointcut() && applicationPointCut()")
  public void logEntryLevelInfo(final ProceedingJoinPoint lJoinPoint) throws Throwable {
    System.out.println("Inside logEntryLevelInfo for method ::" + lJoinPoint.getSignature().getName());
    lJoinPoint.proceed();
    customLog.logEntryLevelInfo(lJoinPoint);
  }

  @Around("customAnnotationPointCut()")
  public void logCustomAnnotatedInfo(final ProceedingJoinPoint lJoinPoint) throws Throwable {
    System.out.println("Inside logCustomAnnotatedInfo for annotated method ::" + lJoinPoint.getSignature().getName());
    lJoinPoint.proceed();
  }
}
