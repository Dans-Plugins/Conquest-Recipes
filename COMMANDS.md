# Conquest Recipes Commands

All commands use `/cr` or `/conquestrecipes` as the base. Either can also be typed with the plugin's name as a prefix, as `/conquest-recipes:cr` or `/conquest-recipes:conquestrecipes`, which reaches this plugin even when another plugin has also claimed `/cr`.

| Command | Description | Permission |
|---------|-------------|------------|
| `/cr` | Show the plugin version, the author, and the list of subcommands. | None |
| `/cr help` | Same as `/cr`. | None |
| `/cr list [page]` | List the items that can be crafted with Conquest Recipes, one page at a time. | `conquestrecipes.listitems`, `conquestrecipes.default` or `conquestrecipes.admin` |
| `/cr listitems [page]` | Alias for `/cr list`. | `conquestrecipes.listitems`, `conquestrecipes.default` or `conquestrecipes.admin` |
| `/cr get <itemName> <amount>` | Give yourself a specified amount of a Conquest Recipes item. | `conquestrecipes.get` or `conquestrecipes.admin` |

Any one of the nodes listed against a command grants it; holding more than one is not required. `conquestrecipes.default` and `conquestrecipes.listitems` both default to `true`, so revoking only one of them still leaves the listing available. The full set of nodes and their defaults is in [USER_GUIDE.md](USER_GUIDE.md#permissions).

`<itemName>` is an item's name exactly as `/cr list` prints it — a single word with no spaces, such as `BronzeBlade` or `SteelLongsword` — and is matched without regard to case, so `bronzeblade` is accepted too. The in-game display name, `Bronze Blade`, is not: the space splits it into two arguments, and `Blade` is then read as the amount. A name that matches no item is answered with `That isn't an item in Conquest Recipes!`.

`<amount>` must be a whole number from 1 to 100 stacks of the item, the limit vanilla `/give` uses: 6400 for ingots, which stack to 64, and 100 for swords and tools, which do not stack. An amount that is not a number is answered with a usage message, one below 1 with `The amount must be at least 1.`, and one above the limit with a message naming it, for example `You can't get more than 100 SteelLongsword at once.` Nothing is given or dropped in any of these cases.

`/cr get` puts as much of the amount as fits into the main inventory (armour and off-hand slots do not count), filling existing stacks of the same item first and then empty slots, and drops the rest on the ground at the player's feet, in stacks no larger than the item normally stacks to (64 for ingots, one each for swords and tools). A stack of the same item with room left in it is enough, so the command works even when no slot is empty. The player is told how many were dropped, for example `4 didn't fit in your inventory and were dropped at your feet.` Items that do not stack, such as swords and tools, need a slot each. When none of the amount fits, the command is answered with `Inventory full.` and nothing is given or dropped.

`[page]` is optional and defaults to 1. Eight item names are shown per page. The header reports the current page and the total number of pages, and the footer reports which items are on screen and names the next page when there is one. A page that is not a number is answered with a usage message, and a page outside the available range is answered with the range.

`/cr list` and `/cr listitems` can be run from the server console as well as in game. `/cr get` cannot, because the item is delivered into the sender's inventory — running it from the console reports that a player is required.

A subcommand that is not one of the above is named back to the sender and followed by the list of subcommands that are accepted.
