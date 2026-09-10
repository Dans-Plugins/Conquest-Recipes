# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/).

## [Unreleased]

### Changed

- `COMMANDS.md` did not describe the whole command surface. `/cr` with no arguments — which prints the plugin version and the author — had no row at all, and the permission column named only one of the two nodes each subcommand accepts: `/cr list` is granted by `conquestrecipes.listitems` **or** `conquestrecipes.default`, and `/cr get` by `conquestrecipes.get` **or** `conquestrecipes.admin`. An operator reading only `COMMANDS.md` would have concluded that `conquestrecipes.admin` does not confer `/cr get`. Both nodes are now listed against each command, `/cr` and `/cr help` have rows, and the permission table in `USER_GUIDE.md` — which was already correct — is linked as the full reference.
- `CONTRIBUTING.md`'s "Adding a New Recipe" section listed three steps and omitted one of them: the lookup branch in `ItemStackService` that makes `/cr get` accept the name. Followed literally, it produced an item that could be crafted but not obtained — the bug fixed in `2.0.0-SNAPSHOT-8-8-2026`. Step 2 also named "the main plugin class" as where recipes are registered, which is `RecipeService.registerRecipes()`. The section now lists four accurate steps and names which command each one feeds.
- `README.md` and `USER_GUIDE.md` now have a **Textures** section. Neither said what an operator sees after installing the plugin with no resource pack: 73 correctly-named, correctly-crafted items wearing their base material's texture. `USER_GUIDE.md`'s "works with any server" — a statement about server compatibility that reads as a statement about needing nothing else — has been narrowed to "runs on any Spigot server". Both sections state that a resource pack is required, that items are matched by display name and so need a name-matching pack (OptiFine's Custom Item Textures, a client-side mod each player installs), that a server-pushed pack cannot retexture them while no `CustomModelData` is set, and that swords looking like iron swords is this and not a fault.

- `/cr list` is now paged. All 73 item names were previously printed at once, which came to 74 chat lines and pushed almost the whole list out of a chat window that shows about ten lines. Eight names are now shown per page, the header reports the current page and the total, and the footer reports which items are on screen and names the next page when there is one. An optional page number is accepted — `/cr list 2`, `/cr listitems 2` — with a non-numeric page answered by a usage message and a page outside the range answered by the available range.
- `README.md`'s **Notes** section said the project had to be built with Java 8. The compiler targets Java 8 bytecode, but the build itself needs a JDK of 11 or later, since the test suite uses Mockito 5; CI builds with JDK 17. The note now says that, and mentions the unit suite alongside the manual server check.
- `README.md`'s **Versions** list stopped at `1.0` and had fallen two releases behind `CHANGELOG.md`. It has been replaced with a link to `CHANGELOG.md`, which is the maintained record, so that the history is kept in one place.

### Fixed

- An unrecognised subcommand is no longer answered with silence. `CommandService` recognised only `get`, `list` and `listitems`, and returned control to Bukkit for anything else; Bukkit answers that by printing the command's usage message, and `plugin.yml` declares none, so `/cr craft`, `/cr help`, and a mistyped `/cr lst` produced no output whatsoever and were indistinguishable from a plugin that had failed to load. The offending subcommand is now named back to the sender and followed by the list of subcommands that are accepted.
- The `Dev Release` workflow now retries publishing the `dev` prerelease before giving up. The release and its tag have to be deleted and recreated for the tag to move to the new commit, and a transient API failure inside that window previously left the repository with no `dev` release at all until the workflow was re-run by hand. Each attempt now starts from a clean slate, and an exhausted retry fails loudly.

### Added

- A `/cr help` subcommand, which prints the plugin version, the author, and the list of accepted subcommands. The same list is now appended to the output of `/cr` on its own, which previously printed only the version and the author and gave no indication of what could be run next. Neither requires a permission node, matching the existing behaviour of `/cr`.
- Unit tests for `CommandService`, the class that routes every `/cr` subcommand, which had no coverage. Dispatch to `/cr get` and `/cr list` is asserted alongside the new unrecognised-subcommand and `help` behaviour, so a future change to the routing cannot silently drop a working subcommand.
- A build-time guard against the item-name set drifting apart. Adding an item means writing the same name into three unrelated places — the registration in `RecipeService`, the lookup branch in `ItemStackService`, and `ListItemsCommand`'s `CRAFTABLE_ITEMS` — and nothing made them agree at compile time. Two shipped bugs came from them diverging, and both were caught by reading rather than by any check. `ItemNameConsistencyTest` now asserts that all three name exactly the classes in `conquestrecipesystem.objects`, so the next divergence fails the build. This is an interim measure; the single registry that would remove the duplication outright is still open.
- An automated unit test suite (JUnit 5 and Mockito), covering the `/cr get` and `/cr list` command classes. The tests run as part of `mvn clean package`, so the existing build workflow now exercises them on every push and pull request. The new dependencies are test-scoped and are not shaded into the released JAR.
- A `Dev Release` workflow, which republishes a rolling `dev` prerelease of `main` on every non-documentation push. This is what Dan's Plugin Manager's experimental channel installs from: `/dpm get conquestrecipes --experimental` reads `releases/tags/dev`, so without it there is nothing for that command to download. The prerelease is unreleased, unreviewed code and is marked as such.

### Fixed

- `/cr get <item> <amount>` parsed the amount with an unguarded `Integer.parseInt`, so a non-numeric amount such as `/cr get BronzeBlade abc` raised a `NumberFormatException` and was reported to the player as an internal error. A non-numeric amount is now answered with a usage message, and an amount below 1 is rejected with its own message instead of being passed through to `ItemStack`.
- `/cr list` and `/cr get` produced no output at all when run from the server console. `/cr list` is now written to the sender rather than to a player, so it works from the console, and `/cr get` — which needs an inventory to deliver the item into — now explains that it must be run by a player.

## [2.0.0-SNAPSHOT-8-8-2026] – 2026-08-08

### Changed
- Conquest-Recipes is now developed AI-first. Day-to-day feature work, grooming, review and maintenance run through AI agents working directly against this repository, with the maintainers setting direction and approving what lands. The major version bump marks that change in how the project is built — it is not a break in behaviour, configuration or stored data, and existing installations can upgrade in place. Released as `2.0.0-SNAPSHOT-8-8-2026`: the AI-first line has not yet been verified in live operation, and the dated snapshot designation stays until it has.

### Fixed
- `plugin.yml`'s `main` field pointed at the old, removed `conquestrecipesystem.Main` class instead of `conquestrecipesystem.ConquestRecipes`, which prevented the plugin from enabling at all.
- Added a `permissions:` section to `plugin.yml` for `conquestrecipes.listitems`, `conquestrecipes.get`, `conquestrecipes.default`, and `conquestrecipes.admin`, matching the nodes already checked in code and documented in `USER_GUIDE.md`.
- `ItemStackService.getItemStack("BronzePickaxe", ...)` returned a Bronze Spade instead of a Bronze Pickaxe, and `"BronzeSpade"` had no lookup branch at all, so `/cr get BronzeSpade` reported the item as unrecognized despite it being craftable.
- `/cr list`, the form documented in `COMMANDS.md` and `USER_GUIDE.md`, was not recognized — only `/cr listitems` was dispatched. Both forms are now accepted.
- The item list printed by `/cr list` omitted 45 of the 73 craftable items and printed 15 names that are not Conquest Recipes items (`Salt` plus a block of vanilla items the plugin never makes uncraftable). The list now matches the names accepted by `/cr get` exactly, and the header no longer names a different plugin.
- `USER_GUIDE.md` listed `Salt` as a craftable item; no such item exists.

## [1.1]

### Added
- Crafting recipes for bronze, steel, and bone weapons and armour
- Mesoamerican weapons (Macuahuitl, Tepoztopilli, Cuauhololli, etc.)
- Greek plate armour set
- Primitive weapons (Stonespear, Blowgun, Dart, etc.)
- Shields (African Tall Shield, Bone Shield, Chimallis)
- `/cr list` and `/cr get` commands
