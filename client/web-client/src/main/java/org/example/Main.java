package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.web_client.ApiClient;
import org.example.web_client.api.DefaultApi;
import org.example.web_client.model.Order;
import org.springframework.web.reactive.function.client.WebClientRequestException;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import javax.validation.constraints.NotNull;

public class Main {
    public static void main(String[] args) {
        DefaultApi apiInstance = new DefaultApi(new ApiClient().setBasePath("http://localhost:8080/v1"));
        Order order = new Order();
        try {
            Order result = apiInstance.createOrder(order).block();
            System.out.println(new ObjectMapper().writeValueAsString(result));
        } catch (WebClientResponseException e) {
            System.err.println("Exception when calling DefaultApi#createPets");
            System.err.println("Status code: " + e.getStatusCode());
            System.err.println("Reason: " + e.getResponseBodyAsString());
            System.err.println("Response headers: " + e.getHeaders());
        } catch (WebClientRequestException e) {
            System.err.println("Exception when calling DefaultApi#createPets");
            System.err.println("Status code: " + e.getMessage());
            System.err.println("Response headers: " + e.getHeaders());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}