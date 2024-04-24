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

package org.openapitools.codegen.java.play;

import io.swagger.parser.OpenAPIParser;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.parser.core.models.ParseOptions;

import org.openapitools.codegen.ClientOptInput;
import org.openapitools.codegen.CodegenConstants;
import org.openapitools.codegen.DefaultGenerator;
import org.openapitools.codegen.TestUtils;
import org.openapitools.codegen.languages.JavaPlayFrameworkCodegen;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Files;

public class JavaPlayFrameworkCodegenTest {

    @Test
    public void testInitialConfigValues() throws Exception {
        final JavaPlayFrameworkCodegen codegen = new JavaPlayFrameworkCodegen();
        codegen.processOpts();

        Assertions.assertEquals(codegen.additionalProperties().get(CodegenConstants.HIDE_GENERATION_TIMESTAMP), Boolean.FALSE);
        Assertions.assertEquals(codegen.isHideGenerationTimestamp(), false);
        Assertions.assertEquals(codegen.modelPackage(), "apimodels");
        Assertions.assertEquals(codegen.additionalProperties().get(CodegenConstants.MODEL_PACKAGE), "apimodels");
        Assertions.assertEquals(codegen.apiPackage(), "controllers");
        Assertions.assertEquals(codegen.additionalProperties().get(CodegenConstants.API_PACKAGE), "controllers");
        Assertions.assertEquals(codegen.getInvokerPackage(), "org.openapitools.api");
        Assertions.assertEquals(codegen.additionalProperties().get(CodegenConstants.INVOKER_PACKAGE), "org.openapitools.api");
        Assertions.assertEquals(codegen.getBasePackage(), "org.openapitools");
        Assertions.assertEquals(codegen.additionalProperties().get(JavaPlayFrameworkCodegen.BASE_PACKAGE), "org.openapitools");
        Assertions.assertEquals(codegen.getConfigPackage(), "org.openapitools.configuration");
        Assertions.assertEquals(codegen.additionalProperties().get(JavaPlayFrameworkCodegen.CONFIG_PACKAGE), "org.openapitools.configuration");
    }

    @Test
    public void testSettersForConfigValues() throws Exception {
        final JavaPlayFrameworkCodegen codegen = new JavaPlayFrameworkCodegen();
        codegen.setHideGenerationTimestamp(true);
        codegen.setModelPackage("xx.yyyyyyyy.model");
        codegen.setApiPackage("xx.yyyyyyyy.api");
        codegen.setInvokerPackage("xx.yyyyyyyy.invoker");
        codegen.setBasePackage("xx.yyyyyyyy.base");
        codegen.setConfigPackage("xx.yyyyyyyy.config");
        codegen.processOpts();

        Assertions.assertEquals(codegen.additionalProperties().get(CodegenConstants.HIDE_GENERATION_TIMESTAMP), Boolean.TRUE);
        Assertions.assertEquals(codegen.isHideGenerationTimestamp(), true);
        Assertions.assertEquals(codegen.modelPackage(), "xx.yyyyyyyy.model");
        Assertions.assertEquals(codegen.additionalProperties().get(CodegenConstants.MODEL_PACKAGE), "xx.yyyyyyyy.model");
        Assertions.assertEquals(codegen.apiPackage(), "xx.yyyyyyyy.api");
        Assertions.assertEquals(codegen.additionalProperties().get(CodegenConstants.API_PACKAGE), "xx.yyyyyyyy.api");
        Assertions.assertEquals(codegen.getInvokerPackage(), "xx.yyyyyyyy.invoker");
        Assertions.assertEquals(codegen.additionalProperties().get(CodegenConstants.INVOKER_PACKAGE), "xx.yyyyyyyy.invoker");
        Assertions.assertEquals(codegen.getBasePackage(), "xx.yyyyyyyy.base");
        Assertions.assertEquals(codegen.additionalProperties().get(JavaPlayFrameworkCodegen.BASE_PACKAGE), "xx.yyyyyyyy.base");
        Assertions.assertEquals(codegen.getConfigPackage(), "xx.yyyyyyyy.config");
        Assertions.assertEquals(codegen.additionalProperties().get(JavaPlayFrameworkCodegen.CONFIG_PACKAGE), "xx.yyyyyyyy.config");
    }

    @Test
    public void testAdditionalPropertiesPutForConfigValues() throws Exception {
        final JavaPlayFrameworkCodegen codegen = new JavaPlayFrameworkCodegen();
        codegen.additionalProperties().put(CodegenConstants.HIDE_GENERATION_TIMESTAMP, "true");
        codegen.additionalProperties().put(CodegenConstants.MODEL_PACKAGE, "xyz.yyyyy.mmmmm.model");
        codegen.additionalProperties().put(CodegenConstants.API_PACKAGE, "xyz.yyyyy.aaaaa.api");
        codegen.additionalProperties().put(CodegenConstants.INVOKER_PACKAGE,"xyz.yyyyy.iiii.invoker");
        codegen.additionalProperties().put(JavaPlayFrameworkCodegen.BASE_PACKAGE,"xyz.yyyyy.bbbb.base");
        codegen.additionalProperties().put(JavaPlayFrameworkCodegen.CONFIG_PACKAGE,"xyz.yyyyy.cccc.config");
        codegen.additionalProperties().put("serverPort","8088");
        codegen.processOpts();

        Assertions.assertEquals(codegen.additionalProperties().get(CodegenConstants.HIDE_GENERATION_TIMESTAMP), Boolean.TRUE);
        Assertions.assertEquals(codegen.isHideGenerationTimestamp(), true);
        Assertions.assertEquals(codegen.modelPackage(), "xyz.yyyyy.mmmmm.model");
        Assertions.assertEquals(codegen.additionalProperties().get(CodegenConstants.MODEL_PACKAGE), "xyz.yyyyy.mmmmm.model");
        Assertions.assertEquals(codegen.apiPackage(), "xyz.yyyyy.aaaaa.api");
        Assertions.assertEquals(codegen.additionalProperties().get(CodegenConstants.API_PACKAGE), "xyz.yyyyy.aaaaa.api");
        Assertions.assertEquals(codegen.getInvokerPackage(), "xyz.yyyyy.iiii.invoker");
        Assertions.assertEquals(codegen.additionalProperties().get(CodegenConstants.INVOKER_PACKAGE), "xyz.yyyyy.iiii.invoker");
        Assertions.assertEquals(codegen.getBasePackage(), "xyz.yyyyy.bbbb.base");
        Assertions.assertEquals(codegen.additionalProperties().get(JavaPlayFrameworkCodegen.BASE_PACKAGE), "xyz.yyyyy.bbbb.base");
        Assertions.assertEquals(codegen.getConfigPackage(), "xyz.yyyyy.cccc.config");
        Assertions.assertEquals(codegen.additionalProperties().get(JavaPlayFrameworkCodegen.CONFIG_PACKAGE), "xyz.yyyyy.cccc.config");
    }

    @Test
    public void testExtraAnnotations() throws Exception {

        File output = Files.createTempDirectory("test").toFile().getCanonicalFile();
        output.deleteOnExit();
        String outputPath = output.getAbsolutePath().replace('\\', '/');

        OpenAPI openAPI = new OpenAPIParser()
                .readLocation("src/test/resources/3_0/issue_11772.yml", null, new ParseOptions()).getOpenAPI();

        JavaPlayFrameworkCodegen codegen = new JavaPlayFrameworkCodegen();
        codegen.setOutputDir(output.getAbsolutePath());

        ClientOptInput input = new ClientOptInput();
        input.openAPI(openAPI);
        input.config(codegen);

        DefaultGenerator generator = new DefaultGenerator();

        generator.setGeneratorPropertyDefault(CodegenConstants.MODELS, "true");
        generator.setGeneratorPropertyDefault(CodegenConstants.MODEL_TESTS, "false");
        generator.setGeneratorPropertyDefault(CodegenConstants.MODEL_DOCS, "false");
        generator.setGeneratorPropertyDefault(CodegenConstants.APIS, "false");
        generator.setGeneratorPropertyDefault(CodegenConstants.SUPPORTING_FILES, "false");
        generator.opts(input).generate();

        TestUtils.assertExtraAnnotationFiles(outputPath + "/app/apimodels");

    }
}
