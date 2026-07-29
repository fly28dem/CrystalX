
package net.flydem.crystalx.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.flydem.crystalx.item.CrystalXBlueItem;
import net.flydem.crystalx.CrystalxModElements;

@CrystalxModElements.ModElement.Tag
public class CrystalXItemGroup extends CrystalxModElements.ModElement {
	public CrystalXItemGroup(CrystalxModElements instance) {
		super(instance, 15);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabcrystal_x") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(CrystalXBlueItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
