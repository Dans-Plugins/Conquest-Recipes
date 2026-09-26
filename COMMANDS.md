# Conquest Recipes Commands

All commands use `/cr` or `/conquestrecipes` as the base.

| Command | Description | Permission |
|---------|-------------|------------|
| `/cr` | Show the plugin version, the author, and the list of subcommands. | None |
| `/cr help` | Same as `/cr`. | None |
| `/cr list [page]` | List the items that can be crafted with Conquest Recipes, one page at a time. | `conquestrecipes.listitems` or `conquestrecipes.default` |
| `/cr listitems [page]` | Alias for `/cr list`. | `conquestrecipes.listitems` or `conquestrecipes.default` |
| `/cr get <itemName> <amount>` | Give yourself a specified amount of a Conquest Recipes item. | `conquestrecipes.get` or `conquestrecipes.admin` |

Either of the two nodes listed against a command grants it; holding both is not required. `conquestrecipes.default` and `conquestrecipes.listitems` both default to `true`, so revoking only one of them still leaves the listing available. The full set of nodes and their defaults is in [USER_GUIDE.md](USER_GUIDE.md#permissions).

`<itemName>` is an item's name exactly as `/cr list` prints it — a single word with no spaces, such as `BronzeBlade` or `SteelLongsword` — and is matched without regard to case, so `bronzeblade` is accepted too. The in-game display name, `Bronze Blade`, is not: the space splits it into two arguments, and `Blade` is then read as the amount. A name that matches no item is answered with `That isn't an item in Conquest Recipes!`.

`<amount>` must be a whole number of 1 or more; anything else is answered with a usage message.

`[page]` is optional and defaults to 1. Eight item names are shown per page. The header reports the current page and the total number of pages, and the footer reports which items are on screen and names the next page when there is one. A page that is not a number is answered with a usage message, and a page outside the available range is answered with the range.

`/cr list` and `/cr listitems` can be run from the server console as well as in game. `/cr get` cannot, because the item is delivered into the sender's inventory — running it from the console reports that a player is required.

A subcommand that is not one of the above is named back to the sender and followed by the list of subcommands that are accepted.
