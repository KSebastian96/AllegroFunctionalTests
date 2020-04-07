$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/searching.feature");
formatter.feature({
  "name": "searching",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Searching for ads as a non-logged user",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "User is on main page",
  "keyword": "Given "
});
formatter.step({
  "name": "User accept privacy policy",
  "keyword": "When "
});
formatter.step({
  "name": "User click on searching bar",
  "keyword": "And "
});
formatter.step({
  "name": "User fill the searching field with \u003cwanted item name\u003e",
  "keyword": "And "
});
formatter.step({
  "name": "User click search button",
  "keyword": "And "
});
formatter.step({
  "name": "Results should contains searched word",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "wanted item name"
      ]
    },
    {
      "cells": [
        "telefon"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Searching for ads as a non-logged user",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "User is on main page",
  "keyword": "Given "
});
formatter.match({
  "location": "Searching_Steps.userIsOnMainPage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User accept privacy policy",
  "keyword": "When "
});
formatter.match({
  "location": "Searching_Steps.userAcceptPrivacyPolicy()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User click on searching bar",
  "keyword": "And "
});
formatter.match({
  "location": "Searching_Steps.userClickOnSearchingBar()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User fill the searching field with telefon",
  "keyword": "And "
});
formatter.match({
  "location": "Searching_Steps.userFillTheSearchingFieldWithWantedItemName(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User click search button",
  "keyword": "And "
});
formatter.match({
  "location": "Searching_Steps.userClickSearchButton()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Results should contains searched word",
  "keyword": "Then "
});
formatter.match({
  "location": "Searching_Steps.resultsShouldContainsSearchedWord()"
});
formatter.result({
  "error_message": "java.lang.AssertionError: \nExpected: a string containing \"telefon\"\n     but: was \"oferta sponsorowana\nxiaomi mi 9t 6 + 64 gb nfc 48mp flame red +airdots\nod\nsuper sprzedawcy\nkolorczerwonyprzekątna ekranu6.39\"wbudowana pamięć64 gbpamięć ram6 gb\n1 512,00 zł\nkup teraz\n1 520,00 zł z dostawą\"\n\tat org.hamcrest.MatcherAssert.assertThat(MatcherAssert.java:20)\n\tat org.junit.Assert.assertThat(Assert.java:956)\n\tat org.junit.Assert.assertThat(Assert.java:923)\n\tat step_definitions.Searching_Steps.resultsShouldContainsSearchedWord(Searching_Steps.java:61)\n\tat ✽.Results should contains searched word(src/test/resources/features/searching.feature:9)\n",
  "status": "failed"
});
});