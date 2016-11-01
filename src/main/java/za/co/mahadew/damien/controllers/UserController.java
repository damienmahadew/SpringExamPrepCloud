package za.co.mahadew.damien.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import za.co.mahadew.damien.domain.User;

/**
 * Created by DAMIEN6 on 01/11/2016.
 */
@RestController
@EnableDiscoveryClient
public class UserController {

    //Spring inject a "smart" service aware tempalte configured with
    // RibbonHttpRequestClient to do a load balanced lookup
    @Autowired
    @LoadBalanced
    RestTemplate restTemplate;

    @RequestMapping(value = "/{id}")
    public User getUser(String id) {
        User user = null ;//fetch data using id
        //the name users referes to the application name used in application.yml
        //this is the service name
        return restTemplate.getForObject("http://users/", User.class, id);

    }
}
