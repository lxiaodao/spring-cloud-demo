package com.ecrm.mq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

@RestController
//@EnableDiscoveryClient
@SpringBootApplication
public class SpringbootMqApplication {

  private static Logger log = LoggerFactory.getLogger(SpringbootMqApplication.class);

 

  public static void main(String[] args) {
    SpringApplication.run(SpringbootMqApplication.class, args);
  }
}
