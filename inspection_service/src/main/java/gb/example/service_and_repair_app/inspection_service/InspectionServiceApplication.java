package gb.example.service_and_repair_app.inspection_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class InspectionServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(InspectionServiceApplication.class, args);
    }
}
