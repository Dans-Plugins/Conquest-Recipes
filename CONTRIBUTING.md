# Contributing

## Thank You

Thank you for your interest in contributing to Conquest Recipes! This guide will help you get started.

## Links

- [Website](https://dansplugins.com)
- [Discord](https://discord.gg/xXtuAQ2)

## Requirements

- A GitHub account
- Git installed on your local machine
- A Java IDE or text editor
- A basic understanding of Java

## Getting Started

1. [Sign up for GitHub](https://github.com/signup) if you don't have an account.
2. Fork the repository by clicking **Fork** at the top right of the repo page.
3. Clone your fork: `git clone https://github.com/<your-username>/Conquest-Recipes.git`
4. Open the project in your IDE.
5. Build the plugin: `mvn clean package`
   If you encounter errors, please open an issue.

## Identifying What to Work On

### Issues

Work items are tracked as [GitHub issues](https://github.com/Dans-Plugins/Conquest-Recipes/issues).

### Milestones

Issues are grouped into [milestones](https://github.com/Dans-Plugins/Conquest-Recipes/milestones) representing upcoming releases.

## Making Changes

1. Make sure an issue exists for the work. If not, create one.
2. Switch to `main`: `git checkout main`
3. Create a branch: `git checkout -b <branch-name>`
4. Make your changes.
5. Test your changes.
6. Commit: `git commit -m "Description of changes"`
7. Push: `git push origin <branch-name>`
8. Open a pull request against `main`, link the related issue with `#<number>`.
9. Address review feedback.

## Adding a New Recipe

Each craftable item has its own class in `src/main/java/conquestrecipesystem/objects/`. To add a new recipe:

1. Create a new class in that package modelled after an existing item class.
2. Register the new recipe in the main plugin class.
3. Add the item to the list returned by `ListItemsCommand`.

All three steps are required. `ItemNameConsistencyTest` asserts that the recipe registrations, the `/cr get` lookup branches and `ListItemsCommand`'s `CRAFTABLE_ITEMS` name exactly the classes in the `objects` package, so missing a step fails the build.

## Testing

Run the build with:

Linux / macOS:

    mvn clean package

Windows:

    mvn clean package

The unit tests live in `src/test/java/` and run as part of that build; they can also be run on their own with `mvn test`. JUnit 5 and Mockito are used, and Bukkit types such as `Player` and `CommandSender` are mocked rather than started, so no server is needed. Tests are expected alongside any change to behaviour.

For manual testing, place the built JAR from `target/` into a local Spigot server's `plugins` folder and restart the server.

## Questions

Ask in the [Discord server](https://discord.gg/xXtuAQ2).
