package com.Ecommerce.Amazon.Service;

import org.checkerframework.checker.units.qual.A;
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
class FavServiceTest {
    @Autowired
    private TestRestTemplate template;
    private String create_url = "http://localhost:8081/WishList/create";
    private String Get_Url = "http://localhost:8081/WishList/get";

    @Test
    void savFav() {
        String requestBody = "{\"proId\":7,\"customerId\":2}";
        HttpHeaders headers = createHttpContentType();
        HttpEntity<String> httpEntity = new HttpEntity<>(requestBody, headers);
        ResponseEntity<String> responseEntity = template.exchange(create_url, HttpMethod.POST, httpEntity, String.class);
        assertEquals(200, responseEntity.getStatusCodeValue());
    }

    @Test
    void listFav() throws JSONException {
        HttpHeaders headers = createHttpContentType();
        HttpEntity<String> httpEntity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> responseEntity = template.exchange(Get_Url, HttpMethod.GET, httpEntity, String.class);
        String expectedResponse = "[{\"favId\":2},{\"favId\":3}]";
        assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        assertEquals("application/json", responseEntity.getHeaders().get("Content-Type").get(0));
        JSONAssert.assertEquals(expectedResponse, responseEntity.getBody(), false);
    }


    private HttpHeaders createHttpContentType() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return headers;
    }

}