package mysticism;

import mysticism.items.ModItems;
import net.fabricmc.api.ModInitializer;

public class Mysticism implements ModInitializer {

    public static final String MOD_ID = "mysticism";
    public static final Process LOGGER = null;

    @Override
    public void onInitialize() {
        ModItems.registerModItems();
    }
}