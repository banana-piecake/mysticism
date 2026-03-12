package mysticism.mixin;

import mysticism.items.DismemberPayload;
import mysticism.items.ModItems;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ServerPlayerEntity.class)
public abstract class PlayerEntityMixin {

    @Shadow public abstract float getHealth();
    @Shadow public abstract World getWorld();
    @Shadow public abstract PlayerInventory getInventory();
    @Shadow public abstract ItemStack getOffHandStack();
    @Shadow public abstract void dropStack(ItemStack stack);

    @Unique
    private boolean offhand = true; // Default value

    @Inject(method = "damage", at = @At("HEAD"), cancellable = true)
    private void onDamage(ServerWorld world, DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        ServerPlayerEntity playerInstance = (ServerPlayerEntity) (Object) this;

        if (source.getWeaponStack() != null &&
                source.getWeaponStack().isOf(ModItems.FELIXAXE) &&
                this.getHealth() - amount <= 0) {

            this.offhand = false;

            if (!this.getWorld().isClient()) {
                this.getWorld().getPlayers().forEach(p ->
                        ServerPlayNetworking.send((ServerPlayerEntity) p, new DismemberPayload(playerInstance.getUuidAsString()))
                );
            }

            this.dropStack(this.getOffHandStack());
            this.getInventory().removeStack(PlayerInventory.OFF_HAND_SLOT);

        }
    }

    // Assuming these are from an interface you've implemented
    public boolean mysticism$getOffhand() {
        return offhand;
    }

    public void mysticism$setOffhand(boolean offhand) {
        this.offhand = offhand;
    }
}