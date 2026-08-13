# Conquest Recipes Commands

All commands use `/cr` or `/conquestrecipes` as the base.

| Command | Description | Permission |
|---------|-------------|------------|
| `/cr list` | List all items that can be crafted with Conquest Recipes. | `conquestrecipes.listitems` |
| `/cr listitems` | Alias for `/cr list`. | `conquestrecipes.listitems` |
| `/cr get <itemName> <amount>` | Give yourself a specified amount of a Conquest Recipes item. | `conquestrecipes.get` |

`<amount>` must be a whole number of 1 or more; anything else is answered with a usage message.

`/cr list` and `/cr listitems` can be run from the server console as well as in game. `/cr get` cannot, because the item is delivered into the sender's inventory — running it from the console reports that a player is required.
