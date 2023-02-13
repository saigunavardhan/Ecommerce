package com.Ecommerce.Amazon.Service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class OrderTest {


     String Create_url = "http://localhost:8081/order/create";
    @Autowired
   private TestRestTemplate template;

    @Test
    void testOrder(){
       String requestBody = "{\"id\":2, \"orderStatus\":\"Pending\"}";
        HttpHeaders headers = createHttpContentType();
        HttpEntity<String> httpEntity = new HttpEntity<>(requestBody, headers);
        ResponseEntity<String> responseEntity = template.exchange(Create_url, HttpMethod.POST, httpEntity, String.class);
        assertEquals(201, responseEntity.getStatusCodeValue());

    }

    private HttpHeaders createHttpContentType() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return headers;
    }
}