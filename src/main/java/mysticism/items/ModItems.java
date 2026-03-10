package mysticism.items;

import mysticism.Mysticism;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
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
    public static final Item DASHTEST = registerItem("dash_item_test", DashItem::new, new Item.Settings().useCooldown(3));

    public static void registerModItems() {

    }
}