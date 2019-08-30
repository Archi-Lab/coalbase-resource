package io.archilab.coalbase.resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.ForwardedHeaderFilter;

@SpringBootApplication
public class CoalbaseResourceApplication {

  public static void main(String[] args) {
    SpringApplication.run(CoalbaseResourceApplication.class, args);
  }


  @Bean
  ForwardedHeaderFilter forwardedHeaderFilter() {
    return new ForwardedHeaderFilter();
  }
}
