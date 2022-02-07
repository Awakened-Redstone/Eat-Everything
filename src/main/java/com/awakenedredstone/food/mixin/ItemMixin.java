package com.awakenedredstone.food.mixin;

import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Item.class)
public class ItemMixin {
    @Mutable @Shadow @Final private @Nullable FoodComponent foodComponent;

    @Inject(method = "<init>", at = @At(value = "TAIL"))
    private void init(Item.Settings settings, CallbackInfo ci) {
        if (this.foodComponent == null)
            this.foodComponent = new FoodComponent.Builder().hunger(4).saturationModifier(1.3f).build();
    }
}
