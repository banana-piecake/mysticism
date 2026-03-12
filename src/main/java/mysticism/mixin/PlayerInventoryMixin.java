package mysticism.mixin;

import mysticism.extension.PlayerEntityExtension;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.ArrayList;
import java.util.Collections;

@Mixin(PlayerInventory.class)
public class PlayerInventoryMixin {
    @Shadow
    @Final
    public PlayerEntity player;

    @Redirect(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/collection/DefaultedList;ofSize(ILjava/lang/Object;)Lnet/minecraft/util/collection/DefaultedList;",
            ordinal = 2))
    private DefaultedList<ItemStack> of (int size, Object defaultValue) {
        return new DefaultedList<>(new ArrayList<>(Collections.nCopies(size, (ItemStack) defaultValue)), (ItemStack) defaultValue) {
            @Override
            public ItemStack set(int index, ItemStack element) {
                if (player.getEntityWorld() instanceof ServerWorld serverWorld) {
                    if (((PlayerEntityExtension) player).mysticism$getOffhand() || element == ItemStack.EMPTY)
                        return super.set(index, element);
                    if (player.getEntityWorld() instanceof ServerWorld)
                        player.dropStack(serverWorld, element);
                    return ItemStack.EMPTY;
                }
                return ItemStack.EMPTY;
            };
        };
        }
    }