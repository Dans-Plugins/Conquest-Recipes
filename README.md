# What is this?
A plugin to add recipes matching textures in the Conquest Resource pack.

# Textures
This plugin supplies recipes, item names and lore. It does not supply textures.

Every item is an ordinary Minecraft item with a display name and lore applied — a Steel Longsword is an iron sword named "Steel Longsword", and a Bone Shield is a shield. With no resource pack installed, all 73 items therefore render as their base material. **If the swords look like iron swords, this is why.**

Distinct textures require the Conquest resource pack. Items are identified by display name only, so the pack has to match on item name — that is what OptiFine's Custom Item Textures does, and it is a client-side mod, so each player installs the pack and the mod themselves. A pack pushed from the server with `resource-pack` in `server.properties` cannot retexture these items, because a vanilla client keys custom models off `CustomModelData`, which this plugin does not yet set.

# Works Well With
Conquest Recipes is part of the **medieval roleplay** set of Dan's Plugins. These are companion plugins that suit the same kind of server and run side by side; Conquest Recipes does not depend on or call into any of them.

- [Medieval Roleplay Engine](https://github.com/Dans-Plugins/Medieval-Roleplay-Engine) ([SpigotMC](https://www.spigotmc.org/resources/medieval-roleplay-engine.79993/), `/dpm get medievalroleplayengine`): character cards, local, global, whisper and yell chat, emotes, dice and messenger birds.
- [Medieval Factions](https://github.com/Dans-Plugins/Medieval-Factions) ([SpigotMC](https://www.spigotmc.org/resources/medieval-factions.79941/), `/dpm get medievalfactions`): nation-like factions with land claims, diplomacy and laws. Its add-ons are listed in its [Expansions](https://github.com/Dans-Plugins/Medieval-Factions#expansions) section.
- [Mailboxes](https://github.com/Dans-Plugins/Mailboxes) ([SpigotMC](https://www.spigotmc.org/resources/mailboxes.96611/), `/dpm get mailboxes`): persistent mail between players, with item attachments.
- [Medieval Economy](https://github.com/Dans-Plugins/Medieval-Economy) ([SpigotMC](https://www.spigotmc.org/resources/medieval-economy.81836/), `/dpm get medievaleconomy`): a coinpurse and a physical currency item.
- [PlayerLore](https://github.com/Dans-Plugins/PlayerLore) ([SpigotMC](https://www.spigotmc.org/resources/playerlore.98602/), `/dpm get playerlore`): players write their own lore onto their items.
- [Medieval Cookery](https://github.com/Dans-Plugins/Medieval-Cookery) (no SpigotMC page, no stable release yet): cooking recipes for custom foods, defined by the server owner.

Every plugin above is listed on [dansplugins.com](https://dansplugins.com). Conquest Recipes is listed at [dansplugins.com/resources/conquest-recipes](https://dansplugins.com/resources/conquest-recipes) and can be installed in game with [Dan's Plugin Manager](https://github.com/Dans-Plugins/Dans-Plugin-Manager): `/dpm get conquestrecipes`.

# Notes
- A JDK of 11 or later is needed to build the project. The compiler targets Java 8 bytecode, so the JAR still runs on a Java 8 server, but the test suite uses Mockito 5 and will not run on a Java 8 toolchain. CI builds with JDK 17.
- Unit tests run as part of `mvn clean package`, and can be run on their own with `mvn test`.
- Manual testing can be done by running a local spigot server with the compiled JAR in the plugins folder and checking the console.

# Usage reporting

Usage reporting is on by default: when the plugin is enabled, and each time one of its commands is used, it sends its name, its version and the command's name to the author's trace server at `https://trace.danielstephenson.dev`, so it is known which plugins are actually in use. Nothing about players, worlds or IP addresses is sent, and nothing typed after a command. The plugin prints one line on every startup saying whether reporting is on and, if not, why.

Each event also carries a random server ID (the `server-id` line in `plugins/trace/config.yml`) so
servers can be counted rather than events. It identifies no person, account or IP address; delete
the line to get a new one.

To turn it off:

- for this plugin only: `usage-reporting.enabled: false` in `plugins/Conquest-Recipes/config.yml`
- for every plugin on the server that reports to trace: `enabled: false` in `plugins/trace/config.yml` (created on first start; plugins never turn it back on)
- for the whole server process: the environment variable `TRACE_USAGE_REPORTING=off` or `DO_NOT_TRACK=1`

Details: https://danielstephenson.dev/usage-reporting

# Supported Minecraft Versions
This plugin is supported on the Minecraft versions listed in [`minecraft-versions.json`](minecraft-versions.json): currently **1.19.4**, **1.21.11**, **26.2** and **26.3** (Spigot and its forks). Every stable release is booted on a real server of each of these versions before it is published, and every build checks that the plugin only uses Bukkit API that exists on all of them. Other versions from 1.19.4 onwards are expected to work but are not tested. To support another version, add it to the file: both checks pick it up.

# Versions
Release history is recorded in [CHANGELOG.md](CHANGELOG.md).
