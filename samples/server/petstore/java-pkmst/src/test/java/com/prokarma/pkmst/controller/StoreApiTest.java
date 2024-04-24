/*
 * OpenAPI Petstore
 * This is a sample server Petstore server. For this sample, you can use the api key `special-key` to test the authorization filters.
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.prokarma.pkmst.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import com.prokarma.pkmst.model.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

/**
 * API tests for StoreApi
 */
@Disabled
public class StoreApiTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    private final StoreApi api = new StoreApiController(objectMapper);

    private final String accept = "application/json";

    
    /**
     * Delete purchase order by ID
     *
     * For valid response try integer IDs with value &lt; 1000. Anything above 1000 or nonintegers will generate API errors
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void deleteOrderTest() throws Exception {
        String orderId = null;
    ResponseEntity<Void> response = api.deleteOrder(orderId , accept);

        // TODO: test validations
    }
    
    /**
     * Returns pet inventories by status
     *
     * Returns a map of status codes to quantities
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void getInventoryTest() throws Exception {
    ResponseEntity<Map<String, Integer>> response = api.getInventory(  accept);

        // TODO: test validations
    }
    
    /**
     * Find purchase order by ID
     *
     * For valid response try integer IDs with value &lt;&#x3D; 5 or &gt; 10. Other values will generate exceptions
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void getOrderByIdTest() throws Exception {
        Long orderId = null;
    ResponseEntity<Order> response = api.getOrderById(orderId , accept);

        // TODO: test validations
    }
    
    /**
     * Place an order for a pet
     *
     * 
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void placeOrderTest() throws Exception {
        Order body = null;
    ResponseEntity<Order> response = api.placeOrder(body , accept);

        // TODO: test validations
    }
    
}
