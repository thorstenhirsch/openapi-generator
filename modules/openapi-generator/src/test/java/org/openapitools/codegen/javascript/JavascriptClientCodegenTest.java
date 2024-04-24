/*
 * Copyright 2018 OpenAPI-Generator Contributors (https://openapi-generator.tech)
 * Copyright 2018 SmartBear Software
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.openapitools.codegen.javascript;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.media.Schema;
import org.openapitools.codegen.*;
import org.openapitools.codegen.languages.JavascriptClientCodegen;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class JavascriptClientCodegenTest {

    @Test
    public void testInitialConfigValues() throws Exception {
        final JavascriptClientCodegen codegen = new JavascriptClientCodegen();
        codegen.processOpts();

        Assertions.assertEquals(codegen.additionalProperties().get(CodegenConstants.HIDE_GENERATION_TIMESTAMP), Boolean.TRUE);
        Assertions.assertEquals(codegen.isHideGenerationTimestamp(), true);
        Assertions.assertEquals(codegen.modelPackage(), "model");
        Assertions.assertEquals(codegen.additionalProperties().get(CodegenConstants.MODEL_PACKAGE), null);
        Assertions.assertEquals(codegen.apiPackage(), "api");
        Assertions.assertEquals(codegen.additionalProperties().get(CodegenConstants.API_PACKAGE), null);
        Assertions.assertEquals(codegen.getInvokerPackage(), null);
        Assertions.assertEquals(codegen.additionalProperties().get(CodegenConstants.INVOKER_PACKAGE), null);
    }

    @Test
    public void testSettersForConfigValues() throws Exception {
        final JavascriptClientCodegen codegen = new JavascriptClientCodegen();
        codegen.setHideGenerationTimestamp(false);
        codegen.processOpts();

        Assertions.assertEquals(codegen.additionalProperties().get(CodegenConstants.HIDE_GENERATION_TIMESTAMP), Boolean.FALSE);
        Assertions.assertEquals(codegen.isHideGenerationTimestamp(), false);
    }

    @Test
    public void testAdditionalPropertiesPutForConfigValues() throws Exception {
        final JavascriptClientCodegen codegen = new JavascriptClientCodegen();
        codegen.additionalProperties().put(CodegenConstants.HIDE_GENERATION_TIMESTAMP, false);
        codegen.processOpts();

        Assertions.assertEquals(codegen.additionalProperties().get(CodegenConstants.HIDE_GENERATION_TIMESTAMP), Boolean.FALSE);
        Assertions.assertEquals(codegen.isHideGenerationTimestamp(), false);
    }

    @Test(description = "test defaultValueWithParam for model's properties")
    public void bodyParameterTest() {
        final OpenAPI openAPI = TestUtils.parseFlattenSpec("src/test/resources/3_0/petstore.yaml");
        final JavascriptClientCodegen codegen = new JavascriptClientCodegen();
        final Schema pet = openAPI.getComponents().getSchemas().get("Pet");
        codegen.setOpenAPI(openAPI);
        final CodegenModel cm = codegen.fromModel("Pet", pet);

        Assertions.assertEquals(cm.name, "Pet");
        Assertions.assertEquals(cm.classname, "Pet");
        Assertions.assertEquals(cm.description, "A pet for sale in the pet store");
        Assertions.assertEquals(cm.vars.size(), 6);

        // category (property)
        final CodegenProperty property1 = cm.vars.get(1);
        Assertions.assertEquals(property1.baseName, "category");
        Assertions.assertEquals(property1.dataType, "Category");
        Assertions.assertEquals(property1.name, "category");
        Assertions.assertEquals(property1.baseType, "Category");
        Assertions.assertEquals(property1.defaultValueWithParam, " = Category.constructFromObject(data['category']);");
        Assertions.assertFalse(property1.required);
        Assertions.assertFalse(property1.isContainer);

        // name (property)
        final CodegenProperty property2 = cm.vars.get(2);
        Assertions.assertEquals(property2.baseName, "name");
        Assertions.assertEquals(property2.dataType, "String");
        Assertions.assertEquals(property2.name, "name");
        Assertions.assertEquals(property2.baseType, "String");
        Assertions.assertEquals(property2.defaultValueWithParam, " = ApiClient.convertToType(data['name'], 'String');");
        Assertions.assertTrue(property2.required); // test required
        Assertions.assertFalse(property2.isContainer);
    }

    @Test(description = "test isDefault in the response")
    public void testResponseIsDefault() throws Exception {
        final OpenAPI openAPI = TestUtils.parseFlattenSpec("src/test/resources/3_0/petstore.yaml");
        final DefaultCodegen codegen = new DefaultCodegen();
        codegen.setOpenAPI(openAPI);

        Operation textOperation = openAPI.getPaths().get("/user").getPost();
        CodegenOperation coText = codegen.fromOperation("/user", "post", textOperation, null);

        for (CodegenResponse cr : coText.responses) {
            Assertions.assertTrue(cr.isDefault);
        }

        Assertions.assertEquals(coText.responses.size(), 1);

    }

    @Test(description = "test multiple file upload collection is correct")
    public void testMultipleFileUpload() throws Exception {
        final OpenAPI openAPI = TestUtils.parseFlattenSpec("src/test/resources/3_0/form-multipart-binary-array.yaml");
        final JavascriptClientCodegen codegen = new JavascriptClientCodegen();
        codegen.setOpenAPI(openAPI);

        final String requestPath = "/multipart-array";
        Operation textOperation = openAPI.getPaths().get(requestPath).getPost();
        CodegenOperation operation = codegen.fromOperation(requestPath, "post", textOperation, null);
        CodegenParameter codegenParameter = operation.allParams.get(0);

        Assertions.assertEquals(codegenParameter.collectionFormat, "passthrough");
    }

    @Test(description = "test isJson, isXml")
    public void testIsJsonIsXmlInConsumes() throws Exception {
        final OpenAPI openAPI = TestUtils.parseFlattenSpec("src/test/resources/3_0/petstore.yaml");
        final DefaultCodegen codegen = new DefaultCodegen();
        codegen.setOpenAPI(openAPI);

        Operation textOperation = openAPI.getPaths().get("/pet").getPost();
        CodegenOperation coText = codegen.fromOperation("/user", "post", textOperation, null);

        for (Map<String, String> consume: coText.consumes) {
            if ("application/json".equals(consume.get("mediaType"))) {
                Assertions.assertEquals(consume.get("isJson"), "true");
            }

            if ("application/xml".equals(consume.get("mediaType"))) {
                Assertions.assertEquals(consume.get("isXml"), "true");
            }
        }
    }

    @Test(description = "test isJson, isXml")
    public void testIsJsonIsXmlInProduces() throws Exception {
        final OpenAPI openAPI = TestUtils.parseFlattenSpec("src/test/resources/3_0/petstore.yaml");
        final DefaultCodegen codegen = new DefaultCodegen();
        codegen.setOpenAPI(openAPI);

        Operation textOperation = openAPI.getPaths().get("/pet/{petId}").getGet();
        CodegenOperation coText = codegen.fromOperation("/user", "get", textOperation, null);

        for (Map<String, String> consume: coText.produces) {
            if ("application/json".equals(consume.get("mediaType"))) {
                Assertions.assertEquals(consume.get("isJson"), "true");
            }

            if ("application/xml".equals(consume.get("mediaType"))) {
                Assertions.assertEquals(consume.get("isXml"), "true");
            }
        }
    }

    @Test(description = "test additional properties for code generation")
    public void testAdditionalProperties() throws Exception {
        final JavascriptClientCodegen codegen = new JavascriptClientCodegen();
        codegen.additionalProperties().put("customProperty", "customValue");
        codegen.processOpts();

        Assertions.assertEquals(codegen.additionalProperties().get("customProperty"), "customValue");
    }

}
