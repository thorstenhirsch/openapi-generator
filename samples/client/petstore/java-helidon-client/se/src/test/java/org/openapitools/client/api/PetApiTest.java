/**
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

import java.io.File;
import java.util.List;
import java.util.Map;
import org.openapitools.client.model.ModelApiResponse;
import org.openapitools.client.model.Pet;
import java.util.Set;

import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiResponse;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.helidon.common.reactive.Single;
import io.helidon.webclient.WebClientResponse;

import static org.hamcrest.MatcherAssertions.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * 
 * OpenAPI Petstore Test
 *
 * 
 * API tests for PetApi
 */
public class PetApiTest {

    private static ApiClient apiClient;
    private static PetApi api;
    private static final String baseUrl = "http://localhost:8080";

    @BeforeAll
    public static void setup() {
        apiClient = ApiClient.builder().build();
        api = PetApiImpl.create(apiClient);
    }

   /**
    * Add a new pet to the store
    * 
    */
    @Test
    public void addPetTest() {
        // TODO - assign values to the input arguments.
        Pet pet = null;

        // TODO - uncomment the following two lines to invoke the service with valid parameters.
        //ApiResponse<Void> response = api.addPet(pet);
        //response.webClientResponse().await();
        // TODO - check for appropriate return status
        // assertThat("Return status", response.get().status().code(), is(expectedStatus));

        // TODO: test validations
    }

   /**
    * Deletes a pet
    * 
    */
    @Test
    public void deletePetTest() {
        // TODO - assign values to the input arguments.
        Long petId = null;
        // TODO - assign values to the input arguments.
        String apiKey = null;

        // TODO - uncomment the following two lines to invoke the service with valid parameters.
        //ApiResponse<Void> response = api.deletePet(petId, apiKey);
        //response.webClientResponse().await();
        // TODO - check for appropriate return status
        // assertThat("Return status", response.get().status().code(), is(expectedStatus));

        // TODO: test validations
    }

   /**
    * Finds Pets by status
    * Multiple status values can be provided with comma separated strings
    */
    @Test
    public void findPetsByStatusTest() {
        // TODO - assign values to the input arguments.
        List<String> status = null;

        // TODO - uncomment the following two lines to invoke the service with valid parameters.
        //ApiResponse<List<Pet>> response = api.findPetsByStatus(status);
        //response.webClientResponse().await();
        // TODO - check for appropriate return status
        // assertThat("Return status", response.get().status().code(), is(expectedStatus));

        // TODO: test validations
    }

   /**
    * Finds Pets by tags
    * Multiple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
    */
    @Test
    public void findPetsByTagsTest() {
        // TODO - assign values to the input arguments.
        Set<String> tags = null;

        // TODO - uncomment the following two lines to invoke the service with valid parameters.
        //ApiResponse<List<Pet>> response = api.findPetsByTags(tags);
        //response.webClientResponse().await();
        // TODO - check for appropriate return status
        // assertThat("Return status", response.get().status().code(), is(expectedStatus));

        // TODO: test validations
    }

   /**
    * Find pet by ID
    * Returns a single pet
    */
    @Test
    public void getPetByIdTest() {
        // TODO - assign values to the input arguments.
        Long petId = null;

        // TODO - uncomment the following two lines to invoke the service with valid parameters.
        //ApiResponse<Pet> response = api.getPetById(petId);
        //response.webClientResponse().await();
        // TODO - check for appropriate return status
        // assertThat("Return status", response.get().status().code(), is(expectedStatus));

        // TODO: test validations
    }

   /**
    * Update an existing pet
    * 
    */
    @Test
    public void updatePetTest() {
        // TODO - assign values to the input arguments.
        Pet pet = null;

        // TODO - uncomment the following two lines to invoke the service with valid parameters.
        //ApiResponse<Void> response = api.updatePet(pet);
        //response.webClientResponse().await();
        // TODO - check for appropriate return status
        // assertThat("Return status", response.get().status().code(), is(expectedStatus));

        // TODO: test validations
    }

   /**
    * Updates a pet in the store with form data
    * 
    */
    @Test
    public void updatePetWithFormTest() {
        // TODO - assign values to the input arguments.
        Long petId = null;
        // TODO - assign values to the input arguments.
        String name = null;
        // TODO - assign values to the input arguments.
        String status = null;

        // TODO - uncomment the following two lines to invoke the service with valid parameters.
        //ApiResponse<Void> response = api.updatePetWithForm(petId, name, status);
        //response.webClientResponse().await();
        // TODO - check for appropriate return status
        // assertThat("Return status", response.get().status().code(), is(expectedStatus));

        // TODO: test validations
    }

   /**
    * uploads an image
    * 
    */
    @Test
    public void uploadFileTest() {
        // TODO - assign values to the input arguments.
        Long petId = null;
        // TODO - assign values to the input arguments.
        String additionalMetadata = null;
        // TODO - assign values to the input arguments.
        File _file = null;

        // TODO - uncomment the following two lines to invoke the service with valid parameters.
        //ApiResponse<ModelApiResponse> response = api.uploadFile(petId, additionalMetadata, _file);
        //response.webClientResponse().await();
        // TODO - check for appropriate return status
        // assertThat("Return status", response.get().status().code(), is(expectedStatus));

        // TODO: test validations
    }

   /**
    * uploads an image (required)
    * 
    */
    @Test
    public void uploadFileWithRequiredFileTest() {
        // TODO - assign values to the input arguments.
        Long petId = null;
        // TODO - assign values to the input arguments.
        File requiredFile = null;
        // TODO - assign values to the input arguments.
        String additionalMetadata = null;

        // TODO - uncomment the following two lines to invoke the service with valid parameters.
        //ApiResponse<ModelApiResponse> response = api.uploadFileWithRequiredFile(petId, requiredFile, additionalMetadata);
        //response.webClientResponse().await();
        // TODO - check for appropriate return status
        // assertThat("Return status", response.get().status().code(), is(expectedStatus));

        // TODO: test validations
    }

}
