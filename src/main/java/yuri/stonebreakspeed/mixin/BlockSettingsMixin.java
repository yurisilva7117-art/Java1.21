package yuri.stonebreakspeed.mixin;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractBlock.class)
public abstract class BlockSettingsMixin {
    @Shadow @Mutable
    protected float hardness;

    @Inject(method = "<init>", at = @At("TAIL"))
    private void stoneBreakSpeed$afterInit(AbstractBlock.Settings settings, CallbackInfo ci) {
        if ((Object)this == Blocks.OBSIDIAN || (Object)this == Blocks.END_STONE || (Object)this == Blocks.COBBLESTONE) {
            this.hardness = Blocks.STONE.getHardness();
        }
    }
  }
