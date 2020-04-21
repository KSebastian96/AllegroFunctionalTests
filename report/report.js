$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/filtering.feature");
formatter.feature({
  "name": "Adding to cart",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Adding items to cart as non-logged user",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "User is on main page and privacy policy is accepted",
  "keyword": "Given "
});
formatter.match({
  "location": "FilteringSteps.userIsOnMainPageAndPrivacyPolicyIsAccepted()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User click fashion category",
  "keyword": "When "
});
formatter.match({
  "location": "FilteringSteps.userClickFashionCategory()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User click on subcategory",
  "keyword": "And "
});
formatter.match({
  "location": "FilteringSteps.userClickOnSubcategory()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User click watches subcategory",
  "keyword": "And "
});
formatter.match({
  "location": "FilteringSteps.userClickWatchesSubcategory()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User click powystawowe filter",
  "keyword": "And "
});
formatter.match({
  "location": "FilteringSteps.userClickPowystawoweFilter()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User click kup teraz filter",
  "keyword": "And "
});
formatter.match({
  "location": "FilteringSteps.userClickKupTerazFilter()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User change view",
  "keyword": "And "
});
formatter.match({
  "location": "FilteringSteps.userChangeView()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User click below 25zł filter",
  "keyword": "And "
});
formatter.match({
  "location": "FilteringSteps.userClickBelowZłFilter()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Chosen filter should be visible on page under the category section",
  "keyword": "Then "
});
formatter.match({
  "location": "FilteringSteps.chosenFilterShouldBeVisibleOnPageUnderTheCategorySection()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Ads should match the filters",
  "keyword": "And "
});
formatter.match({
  "location": "FilteringSteps.adsShouldMatchTheFilters()"
});
formatter.result({
  "status": "passed"
});
});