package mysticism.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class EnderItem extends Item {

    public EnderItem(Settings settings) {
        super(settings);
    }

    public ActionResult use(World world, PlayerEntity user, Hand hand) {
       // world.addParticleClient((ParticleEffect) ParticleTypes.DRAGON_BREATH, user.getX(), user.getY() + 1.0, user.getZ(), 0.0, 0.0, 0.0);
            if (!user.getEntityWorld().isClient() && user.isAlive()) {
                double d = user.getX() + (user.getRandom().nextDouble() - (double) 0.5F) * (double) 16.0F;
                double e = user.getY() + (double) (user.getRandom().nextInt(32) - 16);
                double f = user.getZ() + (user.getRandom().nextDouble() - (double) 0.5F) * (double) 16.0F;
                user.teleport(d,e,f, true);
            }

                return ActionResult.SUCCESS;
            }
        }

