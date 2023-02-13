package com.Ecommerce.Amazon.Service;

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

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class ProductTest {

    String create_url = "http://localhost:8081/product/create";
    String Get_url = "http://localhost:8081/product/get";
    String Delete_url = "http://localhost:8081/product/delete/6";

    @Autowired
    private TestRestTemplate template;

    @Test
    void testAddProduct() {
        String requestBody = "{\"name\":\"Sweat Shirts\",\"price\":1020}";
        HttpHeaders headers = createHttpContentType();
        HttpEntity<String> httpEntity = new HttpEntity<>(requestBody, headers);
        ResponseEntity<String> responseEntity = template.exchange(create_url, HttpMethod.POST, httpEntity, String.class);
        assertEquals(200, responseEntity.getStatusCodeValue());
    }

    @Test
    void testListAllProducts() throws JSONException {
        HttpHeaders headers = createHttpContentType();
        HttpEntity<String> httpEntity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> responseEntity = template.exchange(Get_url, HttpMethod.GET, httpEntity, String.class);
        String expectedResponse = "[{\"proId\":1,\"name\":\"Watches\",\"price\":10.0},{\"proId\":2,\"name\":\"Tshirts\",\"price\":10.0},{\"proId\":3,\"name\":\"Sweat Shirts\",\"price\":1020.0}]";
        assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        assertEquals("application/json", responseEntity.getHeaders().get("Content-Type").get(0));
        JSONAssert.assertEquals(expectedResponse, responseEntity.getBody(), false);
    }

    @Test
    void testDeleteProduct() {
        HttpHeaders headers = createHttpContentType();
        HttpEntity<String> httpEntity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> responseEntity = template.exchange(Delete_url, HttpMethod.DELETE, httpEntity, String.class);
        assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
    }
    private HttpHeaders createHttpContentType() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return headers;
    }

}