
package net.flydem.cristalx.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.flydem.cristalx.item.CrystalXBlueItem;
import net.flydem.cristalx.CristalxModElements;

@CristalxModElements.ModElement.Tag
public class CrystalXItemGroup extends CristalxModElements.ModElement {
	public CrystalXItemGroup(CristalxModElements instance) {
		super(instance, 3);
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
