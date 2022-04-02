# java-auto-framework [![Actions Status](https://github.com/KrisGj/java-auto-framework/workflows/tests/badge.svg)](https://github.com/KrisGj/java-auto-framework/actions)

Just a wee dummy repo to use as a Java automation playground and experiment with things.

# Running the tests

### Setting up Java (if necessary)

1. Install `SDKMAN!`
```shell
curl -s "https://get.sdkman.io" | bash
```

2. Install Java (>=14)
```shell
sdk list java
sdk install java 18-open
```

### Setting up Maven and Chrome (if necessary)

1. Install Maven
```shell
sudo apt install maven
```

2. Install Chrome
```shell
wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
sudo apt install ./google-chrome-stable_current_amd64.deb
```

### Setting up variables and running the tests

1. Export necessary variables
```shell
export HOST=https://demoqa.com
export HEADLESS=true
```
2. Run tests
```shell
mvn test
```
