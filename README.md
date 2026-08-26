# What is this?
A plugin to add recipes matching textures in the Conquest Resource pack.

# Notes
- A JDK of 11 or later is needed to build the project. The compiler targets Java 8 bytecode, so the JAR still runs on a Java 8 server, but the test suite uses Mockito 5 and will not run on a Java 8 toolchain. CI builds with JDK 17.
- Unit tests run as part of `mvn clean package`, and can be run on their own with `mvn test`.
- Manual testing can be done by running a local spigot server with the compiled JAR in the plugins folder and checking the console.

# Versions
Release history is recorded in [CHANGELOG.md](CHANGELOG.md).
