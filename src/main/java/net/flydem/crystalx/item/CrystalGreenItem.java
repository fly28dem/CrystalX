
package net.flydem.crystalx.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.LivingEntity;

import net.flydem.crystalx.procedures.CrystalGreenWhenEatedProcedure;
import net.flydem.crystalx.itemgroup.CrystalXItemGroup;
import net.flydem.crystalx.CrystalxModElements;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

@CrystalxModElements.ModElement.Tag
public class CrystalGreenItem extends CrystalxModElements.ModElement {
	@ObjectHolder("crystalx:crystal_green")
	public static final Item block = null;

	public CrystalGreenItem(CrystalxModElements instance) {
		super(instance, 11);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(CrystalXItemGroup.tab).maxStackSize(4).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(0).saturation(0.2f).setAlwaysEdible()

							.build()));
			setRegistryName("crystal_green");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 30;
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.DRINK;
		}

		@Override
		public net.minecraft.util.SoundEvent getEatSound() {
			return net.minecraft.util.SoundEvents.ENTITY_GENERIC_DRINK;
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemstack, world, entity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();

			CrystalGreenWhenEatedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			return retval;
		}
	}
}
