package net.flydem.crystalx.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.flydem.crystalx.potion.RedCrystallinityPotionEffect;
import net.flydem.crystalx.CrystalxModVariables;
import net.flydem.crystalx.CrystalxMod;

import java.util.Map;
import java.util.Collection;

public class CrystalRedWhenEatedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				CrystalxMod.LOGGER.warn("Failed to load dependency entity for procedure CrystalRedWhenEated!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			double _setval = ((entity.getCapability(CrystalxModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new CrystalxModVariables.PlayerVariables())).simultaneously_eated_red_crystals + 1);
			entity.getCapability(CrystalxModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.simultaneously_eated_red_crystals = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(("" + new java.text.DecimalFormat(
					"\u041E\u0434\u043D\u043E\u0432\u0440\u0435\u043C\u0435\u043D\u043D\u043E \u0441\u044A\u0435\u0434\u0435\u043D\u043E \u043A\u0440\u0438\u0441\u0442\u0430\u043B\u043B\u043E\u0432: \u00A7c#")
							.format((entity.getCapability(CrystalxModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new CrystalxModVariables.PlayerVariables())).simultaneously_eated_red_crystals))),
					(true));
		}
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
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(RedCrystallinityPotionEffect.potion, (int) (new Object() {
					int check(Entity _entity) {
						if (_entity instanceof LivingEntity) {
							Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
							for (EffectInstance effect : effects) {
								if (effect.getPotion() == RedCrystallinityPotionEffect.potion)
									return effect.getDuration();
							}
						}
						return 0;
					}
				}.check(entity) + 70), (int) ((entity.getCapability(CrystalxModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new CrystalxModVariables.PlayerVariables())).simultaneously_eated_red_crystals - 1)));
		} else {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(RedCrystallinityPotionEffect.potion, (int) 280,
						(int) ((entity.getCapability(CrystalxModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new CrystalxModVariables.PlayerVariables())).simultaneously_eated_red_crystals - 1)));
		}
	}
}
