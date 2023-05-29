package com.example.frontendmicro.FrontendController;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class FrontendItemController {
    @RequestMapping("/items")
    @ResponseBody
    public ResponseEntity<?> getItems(HttpServletRequest request) {
        RestTemplate restTemplate = new RestTemplate();

        String gatewayUrl = "http://localhost:8080";
        String requestUrl = gatewayUrl + request.getRequestURI();

        ResponseEntity<?> response = restTemplate.exchange(
                requestUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Object>() {});

        Object responseBody = response.getBody();

        return ResponseEntity.ok(responseBody);

    }
    @RequestMapping("/items/{id}")
    @ResponseBody
    public ResponseEntity<?> getById(@PathVariable long id,  HttpServletRequest request) {
        RestTemplate restTemplate = new RestTemplate();

        String gatewayUrl = "http://localhost:8080";
        String requestUrl = gatewayUrl + request.getRequestURI();

        ResponseEntity<?> response = restTemplate.exchange(
                requestUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Object>() {});

        Object responseBody = response.getBody();

        return ResponseEntity.ok(responseBody);

    }
    @RequestMapping("/items/{id}/name")
    @ResponseBody
    public ResponseEntity<?> getNameById(@PathVariable long id, HttpServletRequest request) {
        RestTemplate restTemplate = new RestTemplate();

        String gatewayUrl = "http://localhost:8080";
        String requestUrl = gatewayUrl + request.getRequestURI();

        ResponseEntity<?> response = restTemplate.exchange(
                requestUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Object>() {});

        Object responseBody = response.getBody();

        return ResponseEntity.ok(responseBody);

    }
    @RequestMapping("/items/{id}/price")
    @ResponseBody
    public ResponseEntity<?> getSsnById(@PathVariable long id, HttpServletRequest request) {
        RestTemplate restTemplate = new RestTemplate();

        String gatewayUrl = "http://localhost:8080";
        String requestUrl = gatewayUrl + request.getRequestURI();

        ResponseEntity<?> response = restTemplate.exchange(
                requestUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Object>() {});

        Object responseBody = response.getBody();

        return ResponseEntity.ok(responseBody);

    }
    @RequestMapping("/items/{id}/delete")
    @ResponseBody
    public ResponseEntity<?> deleteById(@PathVariable long id, HttpServletRequest request) {
        RestTemplate restTemplate = new RestTemplate();

        String gatewayUrl = "http://localhost:8080";
        String requestUrl = gatewayUrl + request.getRequestURI();

        ResponseEntity<?> response = restTemplate.exchange(
                requestUrl,
                HttpMethod.DELETE,
                null,
                new ParameterizedTypeReference<Void>() {});

        return ResponseEntity.status(response.getStatusCode()).build();
    }
    @RequestMapping("/items/{id}/update")
    @ResponseBody
    public ResponseEntity<?> updateById(@PathVariable long id, @RequestBody String requestBody) {
        RestTemplate restTemplate = new RestTemplate();

        String gatewayUrl = "http://localhost:8080";
        String requestUrl = gatewayUrl + "/items/"+id+"/update";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        HttpEntity<String> httpEntity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<?> response = restTemplate.exchange(
                requestUrl,
                HttpMethod.PUT,
                httpEntity,
                Void.class);

        return ResponseEntity.status(response.getStatusCode()).build();
    }
}
