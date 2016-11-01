package za.co.mahadew.damien;

import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by DAMIEN6 on 01/11/2016.
 */
@SpringBootApplication
@EnableEurekaServer
//The above annotation requires the spring-cloud-starter-eureka-server dependency
public class DiscoveryServiceExample {
    //See application.yml for service configuration
}
