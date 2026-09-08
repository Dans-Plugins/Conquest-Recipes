# What is this?
A plugin to add recipes matching textures in the Conquest Resource pack.

# Textures
This plugin supplies recipes, item names and lore. It does not supply textures.

Every item is an ordinary Minecraft item with a display name and lore applied — a Steel Longsword is an iron sword named "Steel Longsword", and a Bone Shield is a shield. With no resource pack installed, all 73 items therefore render as their base material. **If the swords look like iron swords, this is why.**

Distinct textures require the Conquest resource pack. Items are identified by display name only, so the pack has to match on item name — that is what OptiFine's Custom Item Textures does, and it is a client-side mod, so each player installs the pack and the mod themselves. A pack pushed from the server with `resource-pack` in `server.properties` cannot retexture these items, because a vanilla client keys custom models off `CustomModelData`, which this plugin does not yet set.

# Notes
- A JDK of 11 or later is needed to build the project. The compiler targets Java 8 bytecode, so the JAR still runs on a Java 8 server, but the test suite uses Mockito 5 and will not run on a Java 8 toolchain. CI builds with JDK 17.
- Unit tests run as part of `mvn clean package`, and can be run on their own with `mvn test`.
- Manual testing can be done by running a local spigot server with the compiled JAR in the plugins folder and checking the console.

# Versions
Release history is recorded in [CHANGELOG.md](CHANGELOG.md).
