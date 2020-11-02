package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class ExampleMod implements ModInitializer {
	//whool example
	public static ConfiguredFeature<?, ?> WHOOL_OTHERWORLD = Feature.ORE.configure(new OreFeatureConfig(
			OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, Blocks.WHITE_WOOL.getDefaultState(), 5)) // vein size
			.decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(0, // bottom offset
					20, // min y level
					40))) // max y level
			.spreadHorizontally()
			.repeat(10); // number of veins per chunk
	@Override
	public void onInitialize() {
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier("modid", "whool_otherworld"), WHOOL_OTHERWORLD);
	}
}
