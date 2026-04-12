package mysticism.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class ThunderItem extends Item {

    public ThunderItem(Settings settings) {
        super(settings);
    }

    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        Vec3d position = user.getEntityPos();
        double radius = 6;
        Box entitydetect =new Box(
                position.x - radius, position.y - radius, position.z - radius,
                position.x + radius, position.y + radius, position.z + radius
        );
        List<Entity> nearbyEntities = world.getOtherEntities(
                user, // Exclude the user themselves
                entitydetect,
                (entity) -> entity instanceof Entity
        );

        for (Entity entity : nearbyEntities) {
            LightningEntity lightning = EntityType.LIGHTNING_BOLT.create(world, SpawnReason.EVENT);
            lightning.refreshPositionAndAngles(
                    entity.getX(),
                    entity.getY(),
                    entity.getZ(),
                    entity.getYaw(),
                    entity.getPitch()
            );
            world.spawnEntity(lightning);
        }
        return ActionResult.SUCCESS;
    }
}
