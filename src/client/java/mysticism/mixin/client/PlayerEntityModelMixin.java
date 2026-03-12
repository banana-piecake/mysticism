package mysticism.mixin.client;

import mysticism.extension.PlayerEntityExtension;
import net.minecraft.client.gui.widget.ClickableWidget;import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.render.entity.state.PlayerEntityRenderState;import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntityModel.class)
public abstract class PlayerEntityModelMixin extends BipedEntityModel<PlayerEntityRenderState> {

    private ClickableWidget leftSleeve;public PlayerEntityModelMixin(ModelPart root) { super(root); }

    @Inject(method = "setAngles", at = @At("TAIL"))
    private void hideArm(PlayerEntityRenderState state, CallbackInfo ci) {
        // 'state' in 1.21.1 carries the entity data
        if (state.entityType instanceof PlayerEntityExtension ext) {
            boolean hasArm = ext.mysticism$getOffhand();
            this.leftArm.visible = hasArm;
            this.leftSleeve.visible = hasArm;
        }
    }
}