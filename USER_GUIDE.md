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
- **Bone armour** — a helm, chestplate, leggings and boots, all four named Bone Plate
- **Mesoamerican weapons** — Small Macuahuitl, Big Macuahuitl, Feathered Macuahuitl, Tepoztopilli, Cuauhololli
- **Shields** — African Tall Bamboo Shield, Bone Shield, Clean Hoplite Shield, Decorated Chimalli Shield, Spiral Chimalli Shield
- **Primitive weapons** — Boneclub, Stonespear, Dart, Simple Blowgun, Primitive Flail, etc.
- **Greek armour** — Bronze Greek Plate Helm, Bronze Greek Plate Chestpiece, Bronze Greek Plate Greaves, Bronze Greek Plate Sabatons
- **Rootmoss cloth armour** — Rootmoss Cloth Hood, Rootmoss Cloth Chestpiece, Rootmoss Cloth Leggings, Rootmoss Cloth Shoes
- **Other items** — Roots, Strawhat, Copper Chunk, Tin Chunk, Bronze Ingot, Steel Ingot

Use `/cr list` in-game to see the available items. The list is paged eight items at a time so that a page fits the chat window; `/cr list 2` shows the second page. The header names the page you are on and how many there are, and the footer points at the next one.

The names above are the items' display names. Commands take the name that `/cr list` prints instead, which has no spaces: `/cr get SteelLongsword 1` gives a Steel Longsword, while `/cr get Steel Longsword 1` is split at the space, reads `Longsword` as the amount, and is answered with `'Longsword' isn't a number`. Case does not matter. The `/cr list` name can differ from the display name by more than the spaces: for example, the four Bone Plate pieces are `BonePlateHelm`, `BonePlateChestplate`, `BonePlateLeggings` and `BonePlateBoots`, Copper Chunk is `Copper`, and Bronze Greek Plate Helm is `GreekPlateHelm`.

`/cr help`, or `/cr` on its own, lists the plugin's commands. Every command is described in [COMMANDS.md](COMMANDS.md).

## Crafting

Every recipe is laid out on the 3×3 grid of a crafting table, empty squares included. The plugin does not unlock its recipes in the recipe book, so each one has to be laid out by hand.

Every bronze item, the Greek armour and the Clean Hoplite Shield included, is made from Bronze Ingots; the Steel Longsword and Steel Bastardsword are made from Steel Ingots; and the Rootmoss Cloth armour, Stone Root Cleaver and Stone Root Dagger take Roots. These start from vanilla materials:

| Item | Recipe | Makes |
|------|--------|-------|
| Copper Chunk | 9 cobblestone, filling the grid | 4 |
| Tin Chunk | 9 gravel, filling the grid | 4 |
| Bronze Ingot | Top row: 3 Tin Chunks. Middle row: 3 Copper Chunks. Bottom row: Copper Chunk, coal or charcoal, Copper Chunk. | 3 |
| Steel Ingot | Top and bottom rows: coal, or charcoal (all six the same). Middle row: 3 iron ingots. | 2 |
| Roots | 1 oak, spruce, birch, jungle, acacia or dark oak sapling in the centre square | 2 |

Ingredients are matched exactly. Where a recipe calls for a Conquest Recipes item, only that item will do: a plain gold ingot is not a Bronze Ingot, even though a Bronze Ingot looks like one. Vanilla ingredients have to be plain too, so renamed cobblestone does not make Copper Chunks. Items given with `/cr get` are the same as crafted ones and work in any recipe.

The reverse does not hold. Each Conquest Recipes item is its base material underneath, and vanilla recipes accept it as that material: a Bronze Ingot crafts into a block of gold like any other gold ingot. Nothing in the plugin prevents this.

## What Each Item Is Underneath

The plugin gives an item a name and lore and nothing else: no enchantments, attribute changes or durability changes. Damage, armour, durability and every other property are those of the base material, so a Bronze Blade hits as hard as an iron sword and the Bone Plate pieces protect as much as chainmail.

The seven helmets made from a carved pumpkin are the exception worth knowing about. A carved pumpkin can be worn on the head, but it gives no armour, and the wearer sees the pumpkin overlay across the screen, just as with a plain carved pumpkin.

| Base material | Items |
|---------------|-------|
| Carved pumpkin | Bronze Corinthian Helmet, Bronze Gladiator Helmet, Eagle Helmet, Fancy Bronze Helmet, Feather Headdress, Jaguar Helmet, Strawhat |
| Chainmail armour | Bone Plate (all four pieces), Skeletal Skull, Skeletal Chest, Skeletal Legs, Skeletal Feet, Rootmoss Cloth Hood, Rootmoss Cloth Chestpiece, Rootmoss Cloth Leggings, Rootmoss Cloth Shoes |
| Golden armour | Bronze Greek Plate Helm, Bronze Greek Plate Chestpiece, Bronze Greek Plate Greaves, Bronze Greek Plate Sabatons |
| Shield | African Tall Bamboo Shield, Bone Shield, Clean Hoplite Shield, Decorated Chimalli Shield, Spiral Chimalli Shield |
| Iron sword | Bronze Blade, Bronze Dagger, Bronze Glaive, Bronze Greatsword, Bronze Katar, Bronze Khopesh, Steel Bastardsword, Steel Longsword |
| Iron axe | Bronze Axesword, Bronze Fancy Flail, Bronze Hatchet, Great Bronzeaxe |
| Iron pickaxe, shovel, hoe | Bronze Pickaxe, Bronze Spade, Bronze Hoe |
| Stone sword | Big Macuahuitl, Cuauhololli, Feathered Macuahuitl, Primitive Stoneblade, Small Macuahuitl, Stone Root Cleaver, Stone Root Dagger, Stonespear, Tepoztopilli |
| Stone axe | Boneclub, Primitive Warhammer, Stone Halbert |
| Wooden sword | Fancy Wooden Warclub, Large Wooden Club, Primitive Fishingspear, Primitive Hunting Spear, Sharpened Pole, Small Wooden Club |
| Wooden axe | Primitive Flail, Spiked Club, Spiked Halbert, Spiked Hatchet |
| Bow, arrow | Simple Blowgun (bow), Dart (arrow) |
| Crafting materials | Bronze Ingot (gold ingot), Steel Ingot (iron ingot), Copper Chunk (nether brick), Tin Chunk (firework star), Roots (dead bush), Sharpened Bamboo (bamboo) |

## Permissions

| Permission | Default | Description |
|------------|---------|-------------|
| `conquestrecipes.listitems` | `true` | List craftable items. |
| `conquestrecipes.get` | `op` | Use `/cr get` to receive items directly. |
| `conquestrecipes.default` | `true` | Grants access to default Conquest Recipes commands, including `/cr list`. |
| `conquestrecipes.admin` | `op` | Grants access to all Conquest Recipes commands, including `/cr get`. |

## Support

Ask questions in the [Discord server](https://discord.gg/xXtuAQ2) or open a [GitHub issue](https://github.com/Dans-Plugins/Conquest-Recipes/issues).
