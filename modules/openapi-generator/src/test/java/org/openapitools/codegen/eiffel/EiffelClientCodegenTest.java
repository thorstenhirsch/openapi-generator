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

package org.openapitools.codegen.eiffel;

import org.openapitools.codegen.CodegenConstants;
import org.openapitools.codegen.languages.EiffelClientCodegen;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EiffelClientCodegenTest {

    @Test
    public void testInitialConfigValues() throws Exception {
        final EiffelClientCodegen codegen = new EiffelClientCodegen();
        codegen.processOpts();

        Assertions.assertEquals(codegen.additionalProperties().get(CodegenConstants.HIDE_GENERATION_TIMESTAMP), Boolean.TRUE);
        Assertions.assertTrue(codegen.isHideGenerationTimestamp());
    }

    @Test
    public void testSettersForConfigValues() throws Exception {
        final EiffelClientCodegen codegen = new EiffelClientCodegen();
        codegen.setHideGenerationTimestamp(false);
        codegen.processOpts();

        Assertions.assertEquals(codegen.additionalProperties().get(CodegenConstants.HIDE_GENERATION_TIMESTAMP), Boolean.FALSE);
        Assertions.assertFalse(codegen.isHideGenerationTimestamp());
    }

    @Test
    public void testAdditionalPropertiesPutForConfigValues() throws Exception {
        final EiffelClientCodegen codegen = new EiffelClientCodegen();
        codegen.additionalProperties().put(CodegenConstants.HIDE_GENERATION_TIMESTAMP, false);
        codegen.processOpts();

        Assertions.assertEquals(codegen.additionalProperties().get(CodegenConstants.HIDE_GENERATION_TIMESTAMP), Boolean.FALSE);
        Assertions.assertFalse(codegen.isHideGenerationTimestamp());
    }

}
