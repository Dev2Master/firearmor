package fr.master.firearmor;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class FirearmorAPI {
	
	public static boolean hasfireeffect(Player p){
		if(Firearmor.fireeffect.contains(p)){
			return true;
		} else {
			return false;
		}
	}
	public static boolean hasspeedeffect(Player p){
		if(Firearmor.speedeffect.contains(p)){
			return true;
		} else {
			return false;
		}
	}
	public static void firearmorset(Player p){
		ItemStack firearmor =new ItemStack(Material.GOLD_CHESTPLATE);
		ItemMeta firearmormeta = firearmor.getItemMeta();
		firearmormeta.setDisplayName("§c§lFire Armor");
		List<String> firelore =new ArrayList<String>();
		firelore.add("§b§lUne Armure unique qui envoie du feux a ce qui vous attaquent");
		firearmormeta.setLore(firelore);
		firearmor.setItemMeta(firearmormeta);
		p.getInventory().setChestplate(firearmor);
	}
}
