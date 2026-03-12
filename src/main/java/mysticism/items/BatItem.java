package mysticism.items;

import mysticism.Mysticism;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
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
            Vec3d dashVector = attacker.getRotationVector().multiply(2);

            target .addVelocity(dashVector.x, 2, dashVector.z);
            target.setVelocity(target.getVelocity().x, 1.5, target.getVelocity().z);
            player.knockedBack = true;
            target.playSound( Mysticism.BAT, 2f, 1f);
        }
    }
}
