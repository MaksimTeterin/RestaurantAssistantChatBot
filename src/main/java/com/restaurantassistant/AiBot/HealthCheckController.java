package com.restaurantassistant.AiBot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @RequestMapping("/")
    public String healthCheck() {
        return "API is working";
    }
}
