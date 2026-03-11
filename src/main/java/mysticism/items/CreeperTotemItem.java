package mysticism;


import net.minecraft.component.type.DeathProtectionComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraft.world.World.ExplosionSourceType;

public class CreeperTotemItem extends Item {

    public CreeperTotemItem(Settings settings) {
        super(settings);
    }

    public Record DeathProtectionComponent (World world, PlayerEntity user, Hand hand) {
        world.createExplosion(
                user,
                user.getX(),
                user.getY(),
                user.getZ(),
                4.0F, // explosion strength
                ExplosionSourceType.MOB);
        return ActionResult.SUCCESS;
    }
}
