package org.ssn.app.config;

import net.logstash.logback.marker.Markers;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

public class EVMLogger implements Serializable {
  private static final long serialVersionUID = -1005966703246448922L;
  private final Logger logger;

  public EVMLogger(String className) {
    logger = LoggerFactory.getLogger(className);
  }

  public void debug(JSONObject lJsonObject) {
    logger.debug("Debug Msg...", Markers.appendRaw("app_msg", lJsonObject.toString()));
  }

  @CustomLogged
  public void debug(Object lMsg) {
    logger.debug("Custom Debug Msg...", Markers.appendRaw("app_msg", lMsg.toString()));
  }
}
