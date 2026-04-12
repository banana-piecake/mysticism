package mysticism.items;

import mysticism.CreeperTotemItem;
import mysticism.Mysticism;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.DeathProtectionComponent;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {

    public static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        final RegistryKey<Item> registerKey =
                RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Mysticism.MOD_ID, name));

        return Items.register(registerKey, factory, settings);
    }

    public static final Item RUBY = registerItem("ruby", Item::new, new Item.Settings());
    public static final Item WINDORB = registerItem("wind_orb", DashItem::new, new Item.Settings().useCooldown(3));
    public static final Item THUNDERORB = registerItem("thunder_orb", DashItem::new, new Item.Settings().useCooldown(15));    public static final Item CREEPERTOTEM = registerItem("creeper_totem", CreeperTotemItem::new, new Item.Settings());
    public static final Item ENDORB = registerItem("mysterious_pearl", EnderItem::new, new Item.Settings().useCooldown(0.2f));
    public static final Item BAT = registerItem("bat", BatItem::new, new Item.Settings().sword(ToolMaterial.IRON,2.7f, -1.2f));
    public static final Item FELIXAXE = registerItem("felix_axe", FelixAxeItem::new, new Item.Settings().sword(ToolMaterial.IRON,3.7f, -1f));

    public static void registerModItems() {

    }
}