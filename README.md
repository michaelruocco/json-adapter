# JSON Adapter

[![Build](https://github.com/michaelruocco/json-adapter/workflows/pipeline/badge.svg)](https://github.com/michaelruocco/json-adapter/actions)
[![codecov](https://codecov.io/gh/michaelruocco/json-adapter/branch/master/graph/badge.svg)](https://codecov.io/gh/michaelruocco/json-adapter)
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/dd359beb6cb74237add4bed29d8e5682)](https://www.codacy.com/gh/michaelruocco/json-adapter/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=michaelruocco/json-adapter&amp;utm_campaign=Badge_Grade)
[![BCH compliance](https://bettercodehub.com/edge/badge/michaelruocco/json-adapter?branch=master)](https://bettercodehub.com/)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=michaelruocco_json-adapter&metric=alert_status)](https://sonarcloud.io/dashboard?id=michaelruocco_json-adapter)
[![Technical Debt](https://sonarcloud.io/api/project_badges/measure?project=michaelruocco_json-adapter&metric=sqale_index)](https://sonarcloud.io/dashboard?id=michaelruocco_json-adapter)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=michaelruocco_json-adapter&metric=coverage)](https://sonarcloud.io/dashboard?id=michaelruocco_json-adapter)
[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=michaelruocco_json-adapter&metric=ncloc)](https://sonarcloud.io/dashboard?id=michaelruocco_json-adapter)
[![Maven Central](https://img.shields.io/maven-central/v/com.github.michaelruocco/json-adapter.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22com.github.michaelruocco%22%20AND%20a:%22json-adapter%22)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

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

## Useful Commands

```gradle
// cleans build directories
// prints currentVersion
// formats code
// builds code
// runs tests
// checks for gradle issues
// checks dependency versions
./gradlew clean currentVersion dependencyUpdates lintGradle spotlessApply build
```