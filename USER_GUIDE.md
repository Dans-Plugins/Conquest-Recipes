# Conquest Recipes User Guide

## What is Conquest Recipes?

Conquest Recipes is a Spigot plugin that adds crafting recipes for historical and fantasy weapons, armour, and items inspired by ancient civilisations. It is designed to complement the Conquest Reforged resource pack, and runs on any Spigot server.

## Textures

What the plugin provides on its own is recipes, item names and lore. Textures are not included, and are not part of the JAR.

Each item is an ordinary Minecraft item carrying a display name and lore, so it behaves exactly as its base material does. Without a resource pack, that is also how it looks: a Steel Longsword is an iron sword named "Steel Longsword". **If the swords look like iron swords, this is why — the plugin is working, the textures are simply not installed.**

Distinct textures require the Conquest Reforged resource pack. Items are matched by their display name, so the pack must be one that retextures by item name; OptiFine's Custom Item Textures is the usual way that is done, and being a client-side mod it has to be installed by each player alongside the pack. A pack pushed from the server through `resource-pack` in `server.properties` will not retexture these items, because a vanilla client selects custom models by `CustomModelData` and the plugin does not set it.

## Installation

1. Download the latest `Conquest-Recipes-<version>.jar` from the [Releases](https://github.com/Dans-Plugins/Conquest-Recipes/releases) page.
2. Place the JAR in your server's `plugins/` folder.
3. Restart the server.

## Craftable Items

Conquest Recipes adds recipes for dozens of items, including:

- **Bronze weapons and armour** — Bronze Blade, Bronze Dagger, Bronze Greatsword, Bronze Khopesh, Bronze Corinthian Helmet, Bronze Gladiator Helmet, etc.
- **Steel weapons** — Steel Longsword, Steel Bastardsword
- **Bone armour** — Bone Plate Boots, Chestplate, Helm, Leggings
- **Mesoamerican weapons** — Macuahuitl (small and large), Tepoztopilli, Cuauhololli
- **Shields** — African Tall Shield, Bone Shield, Chimallis (decorated and spiral)
- **Primitive weapons** — Boneclub, Stonespear, Dart, Blowgun, Primitive Flail, etc.
- **Greek armour** — Greek Plate Helm, Chestpiece, Greaves, Sabatons
- **Other items** — Roots, Rootmoss cloth, Strawhat, Copper, Tin, Bronze Ingot, Steel Ingot

Use `/cr list` in-game to see the available items. The list is paged eight items at a time so that a page fits the chat window; `/cr list 2` shows the second page. The header names the page you are on and how many there are, and the footer points at the next one.

## Permissions

| Permission | Default | Description |
|------------|---------|-------------|
| `conquestrecipes.listitems` | `true` | List craftable items. |
| `conquestrecipes.get` | `op` | Use `/cr get` to receive items directly. |
| `conquestrecipes.default` | `true` | Grants access to default Conquest Recipes commands, including `/cr list`. |
| `conquestrecipes.admin` | `op` | Grants access to all Conquest Recipes commands, including `/cr get`. |

## Support

Ask questions in the [Discord server](https://discord.gg/xXtuAQ2) or open a [GitHub issue](https://github.com/Dans-Plugins/Conquest-Recipes/issues).
