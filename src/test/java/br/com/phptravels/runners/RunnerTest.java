package br.com.phptravels.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@CucumberOptions(

		features = { "src/test/resources/feature/demonstracaoSite.feature" },

		glue = { "br.com.phptravels.steps", "br.com.phptravels.hooks" }, plugin = { "pretty",
				"html:relatórios/cucumber-reports", }, snippets = SnippetType.CAMELCASE, monochrome = true, dryRun = false, strict = true

)

@RunWith(Cucumber.class)
public class RunnerTest {

}