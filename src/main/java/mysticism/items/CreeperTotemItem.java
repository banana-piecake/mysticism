package mysticism;


import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraft.world.World.ExplosionSourceType;

public class CreeperTotemItem extends Item {

    public CreeperTotemItem(Settings settings) {
        super(settings);
    }
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        world.createExplosion(
                user,
                user.getX(),
                user.getY(),
                user.getZ(),
                12.0F, // explosion strength
                ExplosionSourceType.MOB);
        if (!world.isClient()) {
            user.kill((ServerWorld) world);
        }
        user.getStackInHand(hand).decrement(1);
        return ActionResult.SUCCESS;
    }
}
