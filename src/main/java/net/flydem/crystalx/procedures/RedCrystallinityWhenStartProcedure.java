package net.flydem.crystalx.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import net.flydem.crystalx.potion.RedCrystallinityPotionEffect;
import net.flydem.crystalx.CrystalxModVariables;
import net.flydem.crystalx.CrystalxMod;

import java.util.Map;
import java.util.Collection;

public class RedCrystallinityWhenStartProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				CrystalxMod.LOGGER.warn("Failed to load dependency world for procedure RedCrystallinityWhenStart!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				CrystalxMod.LOGGER.warn("Failed to load dependency x for procedure RedCrystallinityWhenStart!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				CrystalxMod.LOGGER.warn("Failed to load dependency y for procedure RedCrystallinityWhenStart!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				CrystalxMod.LOGGER.warn("Failed to load dependency z for procedure RedCrystallinityWhenStart!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				CrystalxMod.LOGGER.warn("Failed to load dependency entity for procedure RedCrystallinityWhenStart!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if (new Object() {
			boolean check(Entity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == RedCrystallinityPotionEffect.potion)
							return true;
					}
				}
				return false;
			}
		}.check(entity)) {
			if ((entity.getCapability(CrystalxModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new CrystalxModVariables.PlayerVariables())).simultaneously_eated_red_crystals == 1) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"attribute @p generic.attack_damage base set 2.5");
				}
			} else if ((entity.getCapability(CrystalxModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new CrystalxModVariables.PlayerVariables())).simultaneously_eated_red_crystals == 2) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"attribute @p generic.attack_damage base set 4.5");
				}
			} else if ((entity.getCapability(CrystalxModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new CrystalxModVariables.PlayerVariables())).simultaneously_eated_red_crystals == 3) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"attribute @p generic.attack_damage base set 6");
				}
			} else if ((entity.getCapability(CrystalxModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new CrystalxModVariables.PlayerVariables())).simultaneously_eated_red_crystals == 4) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"attribute @p generic.attack_damage base set 7.5");
				}
			} else if ((entity.getCapability(CrystalxModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new CrystalxModVariables.PlayerVariables())).simultaneously_eated_red_crystals == 5) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"attribute @p generic.attack_damage base set 9");
				}
			} else if ((entity.getCapability(CrystalxModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new CrystalxModVariables.PlayerVariables())).simultaneously_eated_red_crystals == 6) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"attribute @p generic.attack_damage base set 10.5");
				}
			} else if ((entity.getCapability(CrystalxModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new CrystalxModVariables.PlayerVariables())).simultaneously_eated_red_crystals == 7) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"attribute @p generic.attack_damage base set 12");
				}
			} else if ((entity.getCapability(CrystalxModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new CrystalxModVariables.PlayerVariables())).simultaneously_eated_red_crystals == 8) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"attribute @p generic.attack_damage base set 13.5");
				}
			} else if ((entity.getCapability(CrystalxModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new CrystalxModVariables.PlayerVariables())).simultaneously_eated_red_crystals >= 9) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"attribute @p generic.attack_damage base set 15.5");
				}
			}
		}
	}
}
