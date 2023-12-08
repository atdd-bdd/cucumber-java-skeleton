# Cucumber-Java Skeleton

This code has been adopted from the Cucumber Skeleton Code.    
It adds support for step definition tables and gives examples of how tables are passed to step definitions 

There is a single scenario with three steps.   Two of the steps just print the values in the table.    

## Get the original code - you can get a maven or a gradle version   

Git:  

    git clone https://github.com/cucumber/cucumber-java-skeleton.git
    cd cucumber-java-skeleton

Subversion:

    svn checkout https://github.com/cucumber/cucumber-java-skeleton/trunk cucumber-java-skeleton
    cd cucumber-java-skeleton

## The remainder of the instructions are copied from the original github

## Use Maven

Open a command window and run:

    cd maven
    ./mvnw test

This runs Cucumber features using Cucumber's JUnit Platform Engine. The `Suite`
annotation on the `RunCucumberTest` class tells JUnit to kick off Cucumber.


## Overriding options

The Cucumber runtime uses configuration parameters to know what features to run,
where the glue code lives, what plugins to use etc. When using JUnit, these
configuration parameters are provided through the `@ConfigurationParameter`
annotation on your test.

For available parameters see: `io.cucumber.junit.platform.engine.Constants`

### Run a subset of Features or Scenarios

Specify a particular scenario by *line*

    @SelectClasspathResource(value = "io/cucumber/skeleton/belly.feature", line = 3)

In case you have multiple feature files or scenarios to run against repeat the
annotation.

You can also specify what to run by *tag*:

    @IncludeTags("zucchini")

## Running a single scenario or feature

Maven and Gradle do not (yet) support selecting single features or scenarios
with JUnit selectors. As a work around the `cucumber.features` property can be
used. Because this property will cause Cucumber to ignore any other selectors
from JUnit it is prudent to only execute the Cucumber engine.

### With Maven

To select the scenario on line 3 of the `belly.feature` file use:

```
./mvnw test -Dsurefire.includeJUnit5Engines=cucumber -Dcucumber.plugin=pretty -Dcucumber.features=src/test/resources/io/cucumber/skeleton/belly.feature:3 
```

Note: Add `-Dcucumber.plugin=pretty` to get test reports. Maven does not report
tests without a class.

### With Gradle

TODO: (Feel free to send a pull request. ;))
