package com.Ecommerce.Amazon.Service;

import com.Ecommerce.Amazon.Entity.Customer;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class CustomerTest {


    private static String Get_Url = "http://localhost:8081/customer/get";
    private static String signup_url = "http://localhost:8081/customer/signUp";
    private static String signIn_url = "http://localhost:8081/customer/signIn";

    @Autowired
    private TestRestTemplate template;

    @Test
    void testListAllCustomers() throws JSONException {
        HttpHeaders headers = createHttpContentType();
        HttpEntity<String> httpEntity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> responseEntity = template.exchange(Get_Url, HttpMethod.GET, httpEntity, String.class);
        String expectedResponse = "[{\"customerId\":1,\"customerName\":\"Guna\",\"customerEmailId\":\"guna@gmail.com\",\"password\":\"Guna12\"},{\"customerId\":2,\"customerName\":\"John\",\"customerEmailId\":\"john@gmail.com\",\"password\":\"John12\"}]";
        assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        assertEquals("application/json", responseEntity.getHeaders().get("Content-Type").get(0));
        JSONAssert.assertEquals(expectedResponse, responseEntity.getBody(), false);
    }

    @Test
    void testRegistration() {
        String requestBody = "{\"customerName\":\"Alex\",\"customerEmailId\":\"Alex@gmail.com\",\"password\":\"J12\"}";
        HttpHeaders headers = createHttpContentType();
        HttpEntity<String> httpEntity = new HttpEntity<>(requestBody, headers);
        ResponseEntity<String> responseEntity = template.exchange(signup_url, HttpMethod.POST, httpEntity, String.class);
        assertEquals(200, responseEntity.getStatusCodeValue());
    }





    private HttpHeaders createHttpContentType() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return headers;
    }


}