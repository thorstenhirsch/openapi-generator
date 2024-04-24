/*
 * OpenAPI Petstore
 * This spec is mainly for testing Petstore server and contains fake endpoints, models. Please do not use this for any other purpose. Special characters: \" \\
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package org.openapitools.client.api;

import org.openapitools.client.model.FooGetDefaultResponse;

import org.openapitools.client.Configuration;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;
import io.vertx.core.Vertx;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import io.vertx.ext.unit.junit.RunTestOnContext;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.Async;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for DefaultApi
 */
@ExtendWith(VertxUnitRunner.class)
@Disabled
public class DefaultApiTest {

    private DefaultApi api;

    @BeforeAll
    public void setupApiClient() {
        JsonObject config = new JsonObject();
        Vertx vertx = Vertx.vertx();
        Configuration.setupDefaultApiClient(vertx, config);

        api = new DefaultApiImpl();
    }
    
    /**
     * 
     * 
     *
     * @param context Vertx test context for doing assertions
     */
    @Test
    public void fooGetTest(TestContext testContext) {
        Async async = testContext.async();
        api.fooGet(result -> {
            // TODO: test validations
            async.complete();
        });
    }
    
}
