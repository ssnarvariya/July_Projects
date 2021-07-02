package org.ssn.app.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class CustomLogService {
  private EVMLogger log;

  @Autowired
  public CustomLogService(ApplicationContext applicationContext) {
    log = applicationContext.getBean(EVMLogger.class, getClass().getName());
  }

  public void logEntryLevelInfo(ProceedingJoinPoint lJoinPoint) {
    JSONObject lJsonObject = null;
    try {
      lJsonObject = new JSONObject();
      lJsonObject.put("mthd_name", lJoinPoint.getSignature().getName());
      lJsonObject.put("mtd_args", lJoinPoint.getArgs());
      log.debug(lJsonObject);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}
