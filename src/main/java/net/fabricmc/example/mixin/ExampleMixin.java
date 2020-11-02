package net.fabricmc.example.mixin;

import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.fabricmc.example.ExampleMod;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

public class ExampleMixin {
	@Mixin(DefaultBiomeFeatures.class)
	public static class DefaultBiomeFeaturesMixin {
		@Inject(method = "addDefaultOres(Lnet/minecraft/world/biome/GenerationSettings$Builder;)V", at = @At("TAIL"))
		private static void addDefaultOres(GenerationSettings.Builder builder, CallbackInfo ci) {
			builder.feature(GenerationStep.Feature.UNDERGROUND_ORES, ExampleMod.WHOOL_OTHERWORLD);
		}
	}
}
