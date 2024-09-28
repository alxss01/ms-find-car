package br.com.devsenior.ms_find_car.resources;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;

@RestController
@RequestMapping(value = "/health")
public class Health {

    @Autowired
    private ObjectMapper mapper;

    @GetMapping
    public ResponseEntity<String> health() throws Exception {
        HealthCheck status = new HealthCheck("Status Ok", Instant.now());
        String health = mapper.writeValueAsString(status);
        return ResponseEntity.ok(health);
    }

    @Data
    class HealthCheck {
        private String status;
        private Instant timestamp;

        public HealthCheck(String status, Instant timestamp) {
            this.status = status;
            this.timestamp = timestamp;
        }

        
    }
    
}
