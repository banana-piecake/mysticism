package mysticism.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class BatItem extends Item {

    public BatItem(Settings settings) {
        super(settings);
    }

    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof PlayerEntity player) {
            Vec3d dashVector = attacker.getRotationVector().multiply(-0.5);

            player.addVelocity(dashVector.x, dashVector.y, dashVector.z);

        }
    }
}
