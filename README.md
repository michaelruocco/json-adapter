# JSON Adapter

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
gradlew clean build
```

## Cleaning up the code

Additionally you can run a small set of code cleaning rules that will clean
up things like spacing and other minor elements by running

```
gradlew clean spotlessApply build
```

## Checking dependencies

You can check the current dependencies used by the project to see whether
they are currently up to date by running the following command:

```
gradlew dependencyUpdates
```