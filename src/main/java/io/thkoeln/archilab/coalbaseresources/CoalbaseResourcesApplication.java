package io.thkoeln.archilab.coalbaseresources;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.ForwardedHeaderFilter;

@SpringBootApplication
public class CoalbaseResourcesApplication {

  public static void main(String[] args) {
    SpringApplication.run(CoalbaseResourcesApplication.class, args);
  }


  @Bean
  ForwardedHeaderFilter forwardedHeaderFilter() {
    return new ForwardedHeaderFilter();
  }
}
