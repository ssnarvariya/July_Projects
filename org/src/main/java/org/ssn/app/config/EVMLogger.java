package org.ssn.app.config;

import net.logstash.logback.marker.Markers;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class EVMLogger implements Serializable {
  private static final long serialVersionUID = -1005966703246448922L;
  private static Logger sLogger = null;
  private static EVMLogger evmLogger = null;

  public static EVMLogger getEVMLoggerInstance(String lClassName) {
    if (evmLogger == null) {
      evmLogger = new EVMLogger();
      sLogger = LoggerFactory.getLogger(lClassName);
    }
    sLogger.info("Inside Class::" + lClassName);
    return evmLogger;
  }

  public void debug(JSONObject lJsonObject) {
    //Implementation from Custom Appender
    sLogger.debug("Debug Msg...", Markers.appendRaw("app_msg", lJsonObject.toString()));
  }

  @CustomLogged
  public void debug(Object lMsg) {
    sLogger.debug("Custom Debug Msg...", Markers.appendRaw("app_msg", lMsg.toString()));
  }
}
