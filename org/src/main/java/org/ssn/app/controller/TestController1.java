package org.ssn.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ssn.app.config.EVMLogger;
import org.ssn.app.service.TestServiceImpl;

@RestController("/get")
public class TestController1 {
  private static final EVMLogger log = EVMLogger.getEVMLoggerInstance(TestController1.class.getName());

  @Autowired
  TestServiceImpl testServiceImpl;

  @GetMapping("/getreq")
  public String showSampleData() {
    testServiceImpl.tryService("Message1");
    log.debug("From Controller---");
    return "Hello sample";
  }
}
