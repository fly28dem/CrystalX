package net.flydem.cristalx.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.flydem.cristalx.CristalxMod;

import java.util.Map;

public class CrystalBlueWhenEatenProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				CristalxMod.LOGGER.warn("Failed to load dependency world for procedure CrystalBlueWhenEaten!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				CristalxMod.LOGGER.warn("Failed to load dependency x for procedure CrystalBlueWhenEaten!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				CristalxMod.LOGGER.warn("Failed to load dependency y for procedure CrystalBlueWhenEaten!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				CristalxMod.LOGGER.warn("Failed to load dependency z for procedure CrystalBlueWhenEaten!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				CristalxMod.LOGGER.warn("Failed to load dependency entity for procedure CrystalBlueWhenEaten!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		world.addParticle(ParticleTypes.EXPLOSION, x, y, z, 0, 1, 0);
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 24, (int) 1));
	}
}
