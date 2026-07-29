package net.flydem.crystalx.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;

import net.flydem.crystalx.particle.RedCrystalityParticleParticle;
import net.flydem.crystalx.CrystalxMod;

import java.util.Map;

public class RedCrystallinityEveryTickParticleProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				CrystalxMod.LOGGER.warn("Failed to load dependency world for procedure RedCrystallinityEveryTickParticle!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				CrystalxMod.LOGGER.warn("Failed to load dependency x for procedure RedCrystallinityEveryTickParticle!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				CrystalxMod.LOGGER.warn("Failed to load dependency y for procedure RedCrystallinityEveryTickParticle!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				CrystalxMod.LOGGER.warn("Failed to load dependency z for procedure RedCrystallinityEveryTickParticle!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if (world instanceof ServerWorld) {
			((ServerWorld) world).spawnParticle(RedCrystalityParticleParticle.particle, x, y, z, (int) 1, 0.3, 0.8, 0.3, 0.1);
		}
	}
}
