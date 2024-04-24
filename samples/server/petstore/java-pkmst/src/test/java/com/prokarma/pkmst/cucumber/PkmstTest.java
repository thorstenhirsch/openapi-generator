package com.prokarma.pkmst.cucumber;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ActiveProfiles;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@ExtendWith(Cucumber.class)
@ActiveProfiles("test")
@CucumberOptions(format = { "pretty", "html:target/cucumber-html-report",
 "json:./report/pet-report-json/pet.json",
 "json:./report/store-report-json/store.json",
 "json:./report/user-report-json/user.json",
 })
public class PkmstTest {
}