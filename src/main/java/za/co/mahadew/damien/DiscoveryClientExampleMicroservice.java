package za.co.mahadew.damien;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by DAMIEN6 on 01/11/2016.
 */
@SpringBootApplication
//Need the annotation below to register a microservice
@EnableDiscoveryClient
public class DiscoveryClientExampleMicroservice {
}
