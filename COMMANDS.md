# Conquest Recipes Commands

All commands use `/cr` or `/conquestrecipes` as the base.

| Command | Description | Permission |
|---------|-------------|------------|
| `/cr list [page]` | List the items that can be crafted with Conquest Recipes, one page at a time. | `conquestrecipes.listitems` |
| `/cr listitems [page]` | Alias for `/cr list`. | `conquestrecipes.listitems` |
| `/cr get <itemName> <amount>` | Give yourself a specified amount of a Conquest Recipes item. | `conquestrecipes.get` |

`<amount>` must be a whole number of 1 or more; anything else is answered with a usage message.

`[page]` is optional and defaults to 1. Eight item names are shown per page, and the header and footer report the current page, the total number of pages, and which items are on screen. A page that is not a number is answered with a usage message, and a page outside the available range is answered with the range.

`/cr list` and `/cr listitems` can be run from the server console as well as in game. `/cr get` cannot, because the item is delivered into the sender's inventory — running it from the console reports that a player is required.
