package conquestrecipesystem.services;

import conquestrecipesystem.ConquestRecipes;
import conquestrecipesystem.objects.*;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * The one list of Conquest Recipes items. {@link RecipeService} registers a recipe for each entry,
 * {@link ItemStackService#getItemStack(String, int)} accepts each entry's name, and /cr list prints each
 * entry's name, so an item added here is craftable, obtainable and listed at once.
 *
 * An item's name is its class's simple name, so no name is written out by hand. The class is named four
 * times on its line, and the compiler rejects a line where the four disagree.
 *
 * Entries are kept in the order their recipes were registered before this list existed, so recipes still
 * reach Bukkit in the same order. /cr list sorts the names itself, so the order here does not affect what
 * it prints.
 */
public final class ItemRegistry {

    /** One craftable item: its name, and how to register its recipe and build a stack of it. */
    public static final class Entry {
        private final String name;
        private final Consumer<ConquestRecipes> recipeRegistration;
        private final BiFunction<ConquestRecipes, Integer, ItemStack> itemStackFactory;

        private Entry(String name, Consumer<ConquestRecipes> recipeRegistration, BiFunction<ConquestRecipes, Integer, ItemStack> itemStackFactory) {
            this.name = name;
            this.recipeRegistration = recipeRegistration;
            this.itemStackFactory = itemStackFactory;
        }

        public String getName() {
            return name;
        }

        public void registerRecipe(ConquestRecipes plugin) {
            recipeRegistration.accept(plugin);
        }

        public ItemStack getItemStack(ConquestRecipes plugin, int amount) {
            return itemStackFactory.apply(plugin, amount);
        }
    }

    private static final List<Entry> ENTRIES = Collections.unmodifiableList(Arrays.asList(
            item(SteelIngot.class, SteelIngot::new, SteelIngot::registerRecipe, SteelIngot::getItemStack),
            item(SimpleBlowgun.class, SimpleBlowgun::new, SimpleBlowgun::registerRecipe, SimpleBlowgun::getItemStack),
            item(Dart.class, Dart::new, Dart::registerRecipe, Dart::getItemStack),
            item(SharpenedBamboo.class, SharpenedBamboo::new, SharpenedBamboo::registerRecipe, SharpenedBamboo::getItemStack),
            item(LargeWoodenClub.class, LargeWoodenClub::new, LargeWoodenClub::registerRecipe, LargeWoodenClub::getItemStack),
            item(PrimitiveFishingSpear.class, PrimitiveFishingSpear::new, PrimitiveFishingSpear::registerRecipe, PrimitiveFishingSpear::getItemStack),
            item(PrimitiveHuntingSpear.class, PrimitiveHuntingSpear::new, PrimitiveHuntingSpear::registerRecipe, PrimitiveHuntingSpear::getItemStack),
            item(Stonespear.class, Stonespear::new, Stonespear::registerRecipe, Stonespear::getItemStack),
            item(Boneclub.class, Boneclub::new, Boneclub::registerRecipe, Boneclub::getItemStack),
            item(SharpenedPole.class, SharpenedPole::new, SharpenedPole::registerRecipe, SharpenedPole::getItemStack),
            item(SmallWoodenClub.class, SmallWoodenClub::new, SmallWoodenClub::registerRecipe, SmallWoodenClub::getItemStack),
            item(SpikedHalberd.class, SpikedHalberd::new, SpikedHalberd::registerRecipe, SpikedHalberd::getItemStack),
            item(FancyWoodenWarclub.class, FancyWoodenWarclub::new, FancyWoodenWarclub::registerRecipe, FancyWoodenWarclub::getItemStack),
            item(PrimitiveWarhammer.class, PrimitiveWarhammer::new, PrimitiveWarhammer::registerRecipe, PrimitiveWarhammer::getItemStack),
            item(SpikedClub.class, SpikedClub::new, SpikedClub::registerRecipe, SpikedClub::getItemStack),
            item(SteelLongsword.class, SteelLongsword::new, SteelLongsword::registerRecipe, SteelLongsword::getItemStack),
            item(SteelBastardsword.class, SteelBastardsword::new, SteelBastardsword::registerRecipe, SteelBastardsword::getItemStack),
            item(PrimitiveFlail.class, PrimitiveFlail::new, PrimitiveFlail::registerRecipe, PrimitiveFlail::getItemStack),
            item(SpikedHatchet.class, SpikedHatchet::new, SpikedHatchet::registerRecipe, SpikedHatchet::getItemStack),
            item(PrimitiveStoneblade.class, PrimitiveStoneblade::new, PrimitiveStoneblade::registerRecipe, PrimitiveStoneblade::getItemStack),
            item(RootCleaver.class, RootCleaver::new, RootCleaver::registerRecipe, RootCleaver::getItemStack),
            item(RootDagger.class, RootDagger::new, RootDagger::registerRecipe, RootDagger::getItemStack),
            item(BigMacuahuitl.class, BigMacuahuitl::new, BigMacuahuitl::registerRecipe, BigMacuahuitl::getItemStack),
            item(Cuauhololli.class, Cuauhololli::new, Cuauhololli::registerRecipe, Cuauhololli::getItemStack),
            item(FeatheredMacuahuitl.class, FeatheredMacuahuitl::new, FeatheredMacuahuitl::registerRecipe, FeatheredMacuahuitl::getItemStack),
            item(SmallMacuahuitl.class, SmallMacuahuitl::new, SmallMacuahuitl::registerRecipe, SmallMacuahuitl::getItemStack),
            item(Tepoztopilli.class, Tepoztopilli::new, Tepoztopilli::registerRecipe, Tepoztopilli::getItemStack),
            item(StoneHalberd.class, StoneHalberd::new, StoneHalberd::registerRecipe, StoneHalberd::getItemStack),
            item(Roots.class, Roots::new, Roots::registerRecipe, Roots::getItemStack),
            item(BonePlateBoots.class, BonePlateBoots::new, BonePlateBoots::registerRecipe, BonePlateBoots::getItemStack),
            item(BonePlateChestplate.class, BonePlateChestplate::new, BonePlateChestplate::registerRecipe, BonePlateChestplate::getItemStack),
            item(BonePlateHelm.class, BonePlateHelm::new, BonePlateHelm::registerRecipe, BonePlateHelm::getItemStack),
            item(BonePlateLeggings.class, BonePlateLeggings::new, BonePlateLeggings::registerRecipe, BonePlateLeggings::getItemStack),
            item(BoneShield.class, BoneShield::new, BoneShield::registerRecipe, BoneShield::getItemStack),
            item(AfricanTallShield.class, AfricanTallShield::new, AfricanTallShield::registerRecipe, AfricanTallShield::getItemStack),
            item(DecoratedChimalliShield.class, DecoratedChimalliShield::new, DecoratedChimalliShield::registerRecipe, DecoratedChimalliShield::getItemStack),
            item(SpiralChimalliShield.class, SpiralChimalliShield::new, SpiralChimalliShield::registerRecipe, SpiralChimalliShield::getItemStack),
            item(SkeletalSkull.class, SkeletalSkull::new, SkeletalSkull::registerRecipe, SkeletalSkull::getItemStack),
            item(SkeletalChest.class, SkeletalChest::new, SkeletalChest::registerRecipe, SkeletalChest::getItemStack),
            item(SkeletalLegs.class, SkeletalLegs::new, SkeletalLegs::registerRecipe, SkeletalLegs::getItemStack),
            item(SkeletalFeet.class, SkeletalFeet::new, SkeletalFeet::registerRecipe, SkeletalFeet::getItemStack),
            item(RootmossClothHelmet.class, RootmossClothHelmet::new, RootmossClothHelmet::registerRecipe, RootmossClothHelmet::getItemStack),
            item(RootmossClothChestpiece.class, RootmossClothChestpiece::new, RootmossClothChestpiece::registerRecipe, RootmossClothChestpiece::getItemStack),
            item(RootmossClothLeggings.class, RootmossClothLeggings::new, RootmossClothLeggings::registerRecipe, RootmossClothLeggings::getItemStack),
            item(RootmossClothShoes.class, RootmossClothShoes::new, RootmossClothShoes::registerRecipe, RootmossClothShoes::getItemStack),
            item(Copper.class, Copper::new, Copper::registerRecipe, Copper::getItemStack),
            item(Tin.class, Tin::new, Tin::registerRecipe, Tin::getItemStack),
            item(BronzeIngot.class, BronzeIngot::new, BronzeIngot::registerRecipe, BronzeIngot::getItemStack),
            item(BronzeAxesword.class, BronzeAxesword::new, BronzeAxesword::registerRecipe, BronzeAxesword::getItemStack),
            item(BronzeBlade.class, BronzeBlade::new, BronzeBlade::registerRecipe, BronzeBlade::getItemStack),
            item(BronzeCorinthianHelmet.class, BronzeCorinthianHelmet::new, BronzeCorinthianHelmet::registerRecipe, BronzeCorinthianHelmet::getItemStack),
            item(BronzeDagger.class, BronzeDagger::new, BronzeDagger::registerRecipe, BronzeDagger::getItemStack),
            item(BronzeFancyFlail.class, BronzeFancyFlail::new, BronzeFancyFlail::registerRecipe, BronzeFancyFlail::getItemStack),
            item(BronzeGladiatorHelmet.class, BronzeGladiatorHelmet::new, BronzeGladiatorHelmet::registerRecipe, BronzeGladiatorHelmet::getItemStack),
            item(BronzeGlaive.class, BronzeGlaive::new, BronzeGlaive::registerRecipe, BronzeGlaive::getItemStack),
            item(BronzeGreatsword.class, BronzeGreatsword::new, BronzeGreatsword::registerRecipe, BronzeGreatsword::getItemStack),
            item(BronzeHatchet.class, BronzeHatchet::new, BronzeHatchet::registerRecipe, BronzeHatchet::getItemStack),
            item(BronzeKhopesh.class, BronzeKhopesh::new, BronzeKhopesh::registerRecipe, BronzeKhopesh::getItemStack),
            item(BronzePickaxe.class, BronzePickaxe::new, BronzePickaxe::registerRecipe, BronzePickaxe::getItemStack),
            item(BronzeSpade.class, BronzeSpade::new, BronzeSpade::registerRecipe, BronzeSpade::getItemStack),
            item(CleanHopliteShield.class, CleanHopliteShield::new, CleanHopliteShield::registerRecipe, CleanHopliteShield::getItemStack),
            item(FancyBronzeHelmet.class, FancyBronzeHelmet::new, FancyBronzeHelmet::registerRecipe, FancyBronzeHelmet::getItemStack),
            item(GreatBronzeaxe.class, GreatBronzeaxe::new, GreatBronzeaxe::registerRecipe, GreatBronzeaxe::getItemStack),
            item(GreekPlateChestpiece.class, GreekPlateChestpiece::new, GreekPlateChestpiece::registerRecipe, GreekPlateChestpiece::getItemStack),
            item(GreekPlateGreaves.class, GreekPlateGreaves::new, GreekPlateGreaves::registerRecipe, GreekPlateGreaves::getItemStack),
            item(GreekPlateHelm.class, GreekPlateHelm::new, GreekPlateHelm::registerRecipe, GreekPlateHelm::getItemStack),
            item(GreekPlateSabatons.class, GreekPlateSabatons::new, GreekPlateSabatons::registerRecipe, GreekPlateSabatons::getItemStack),
            item(Strawhat.class, Strawhat::new, Strawhat::registerRecipe, Strawhat::getItemStack),
            item(EagleHelmet.class, EagleHelmet::new, EagleHelmet::registerRecipe, EagleHelmet::getItemStack),
            item(FeatherHeaddress.class, FeatherHeaddress::new, FeatherHeaddress::registerRecipe, FeatherHeaddress::getItemStack),
            item(BronzeHoe.class, BronzeHoe::new, BronzeHoe::registerRecipe, BronzeHoe::getItemStack),
            item(BronzeKatar.class, BronzeKatar::new, BronzeKatar::registerRecipe, BronzeKatar::getItemStack),
            item(JaguarHelmet.class, JaguarHelmet::new, JaguarHelmet::registerRecipe, JaguarHelmet::getItemStack)
    ));

    private ItemRegistry() {
    }

    /** Every item, in recipe registration order. */
    public static List<Entry> getEntries() {
        return ENTRIES;
    }

    /** The item whose name matches {@code name} without regard to case, or null if there is none. */
    public static Entry find(String name) {
        for (Entry entry : ENTRIES) {
            if (entry.getName().equalsIgnoreCase(name)) {
                return entry;
            }
        }
        return null;
    }

    private static <T> Entry item(Class<T> type, Function<ConquestRecipes, T> constructor, Consumer<T> registerRecipe, BiFunction<T, Integer, ItemStack> getItemStack) {
        return new Entry(type.getSimpleName(),
                plugin -> registerRecipe.accept(constructor.apply(plugin)),
                (plugin, amount) -> getItemStack.apply(constructor.apply(plugin), amount));
    }

}
