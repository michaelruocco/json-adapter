# JSON Adapter

[![Build Status](https://travis-ci.org/michaelruocco/json-adapter.svg?branch=master)](https://travis-ci.org/michaelruocco/json-adapter)
[![codecov](https://codecov.io/gh/michaelruocco/json-adapter/branch/master/graph/badge.svg)](https://codecov.io/gh/michaelruocco/json-adapter)
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/a475e9dfd8b94547a678e5b4ec50e6cd)](https://www.codacy.com/manual/michaelruocco/json-adapter?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=michaelruocco/json-adapter&amp;utm_campaign=Badge_Grade)
[![BCH compliance](https://bettercodehub.com/edge/badge/michaelruocco/json-adapter?branch=master)](https://bettercodehub.com/)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=michaelruocco_json-adapter&metric=alert_status)](https://sonarcloud.io/dashboard?id=michaelruocco_json-adapter)
[![Technical Debt](https://sonarcloud.io/api/project_badges/measure?project=michaelruocco_json-adapter&metric=sqale_index)](https://sonarcloud.io/dashboard?id=michaelruocco_json-adapter)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=michaelruocco_json-adapter&metric=coverage)](https://sonarcloud.io/dashboard?id=michaelruocco_json-adapter)
[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=michaelruocco_json-adapter&metric=ncloc)](https://sonarcloud.io/dashboard?id=michaelruocco_json-adapter)
[![Download](https://api.bintray.com/packages/michaelruocco/maven/json-adapter/images/download.svg) ](https://bintray.com/michaelruocco/maven/json-adapter/_latestVersion)
[![Maven Central](https://img.shields.io/maven-central/v/com.github.michaelruocco/json-adapter.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22com.github.michaelruocco%22%20AND%20a:%22json-adapter%22)

This is a small java adapter library that provides an interface to "hide"
the details of using jackson from your application. It also provides some utility
classes that I find useful when working with Jackson to remove a lot of the
"redundant" catch blocks that you need to put into your code to handle exceptions
that for the most part I am not too bothered about / can't easily test, which in
turn has a negative impact on test coverage.

## Usage

To use the library you will need to add a dependency to your project. In
gradle you would do this by adding the following to your build.gradle file:

```
dependencies {
    compile 'com.github.michaelruocco:json-adapter:{latest-version}'
}
```

## Running the Tests

You can run the unit tests for this project by running:

```
./gradlew clean build
```

## Cleaning up the code

You can also run a small set of code cleaning rules that will clean
up things like spacing and other minor elements by running

```
./gradlew clean spotlessApply build
```

## Checking dependencies

You can check the current dependencies used by the project to see whether
they are currently up to date by running the following command:

```
./gradlew dependencyUpdates
```