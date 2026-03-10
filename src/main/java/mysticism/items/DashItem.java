package mysticism.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class DashItem extends Item {

    public DashItem(Item.Settings settings) {
        super(settings);
    }

    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        Vec3d movementVector = user.getRotationVector();
        Vec3d dashVector;
        dashVector = movementVector.multiply(2.0);
        user.addVelocity(dashVector);
        world.addParticleClient(ParticleTypes.GUST_EMITTER_LARGE, user.getX(), user.getY() + 1.0, user.getZ(), 0.0, 0.0, 0.0);
        return ActionResult.SUCCESS;
    }
}
