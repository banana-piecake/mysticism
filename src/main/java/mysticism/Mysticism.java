package mysticism;

import mysticism.items.ModItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class Mysticism implements ModInitializer {

    public static final String MOD_ID = "mysticism";
    public static final Process LOGGER = null;
    public static SoundEvent BAT = registerSoundEvent("bat");

    private static SoundEvent registerSoundEvent(String name) {
            Identifier id = Identifier.of(Mysticism.MOD_ID, name);
            return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
}
    @Override
    public void onInitialize() {
        ModItems.registerModItems();

    }
}