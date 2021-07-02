package org.ssn.app.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class CustomLogService {
  private static final EVMLogger log = EVMLogger.getEVMLoggerInstance(CustomLogService.class.getName());

  public void logEntryLevelInfo(ProceedingJoinPoint lJoinPoint) {
    JSONObject lJsonObject = null;
    try {
      lJsonObject = new JSONObject();
      lJsonObject.put("mthd_name", lJoinPoint.getSignature().getName());
      lJsonObject.put("mtd_args", lJoinPoint.getArgs());
      log.debug(lJsonObject);
    }
    catch (Exception e) {
      System.out.println(e);
    }
  }
}
