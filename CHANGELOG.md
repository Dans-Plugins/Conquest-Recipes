# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/).

## [Unreleased]

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
