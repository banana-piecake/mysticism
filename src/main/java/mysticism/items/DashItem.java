package mysticism.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
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
        return ActionResult.SUCCESS;
    }
}
