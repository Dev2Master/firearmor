package fr.master.firearmor;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class firearmor extends JavaPlugin implements Listener{
	ArrayList<Player> speedeffect =new ArrayList<Player>();
	ArrayList<Player> fireeffect =new ArrayList<Player>();
	@Override
	public boolean onCommand(org.bukkit.command.CommandSender sender, org.bukkit.command.Command command, String label
			, String[] args) {
		Player p = (Player) sender;
		if(label.equalsIgnoreCase("armorgui")){
			ouverturemenu(p);
		}
		return false;};
	private static Inventory inv;
	public void onEnable(){
		getCommand("armorgui").setExecutor(this);
		Bukkit.getPluginManager().registerEvents(this, this);
	}
	public void firearmorset(Player p){
		ItemStack firearmor =new ItemStack(Material.GOLD_CHESTPLATE);
		ItemMeta firearmormeta = firearmor.getItemMeta();
		firearmormeta.setDisplayName("§c§lFire Armor");
		List<String> firelore =new ArrayList<String>();
		firelore.add("§b§lUne Armure unique qui envoie du feux a ce qui vous attaquent");
		firearmormeta.setLore(firelore);
		firearmor.setItemMeta(firearmormeta);
		p.getInventory().setChestplate(firearmor);
	}
	public void effectfirearmor(Player p){
		ItemStack firearmor =new ItemStack(Material.GOLD_CHESTPLATE);
		ItemMeta firearmormeta = firearmor.getItemMeta();
		firearmormeta.setDisplayName("§c§lFire Armor");
		List<String> firelore =new ArrayList<String>();
		firelore.add("§b§lUne Armure unique qui envoie du feux a ce qui vous attaquent");
		firearmormeta.setLore(firelore);
		firearmor.setItemMeta(firearmormeta);
		if(p.getInventory().getChestplate().isSimilar(firearmor)){
			fireeffect.add(p);
		}
	}
	@EventHandler
	public void clickfirearmorevent(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		ItemStack firearmor =new ItemStack(Material.GOLD_CHESTPLATE);
		ItemMeta firearmormeta = firearmor.getItemMeta();
		firearmormeta.setDisplayName("§c§lFire Armor");
		List<String> firelore =new ArrayList<String>();
		firelore.add("§b§lUne Armure unique qui envoie du feux a ce qui vous attaquent");
		firearmormeta.setLore(firelore);
		firearmor.setItemMeta(firearmormeta);
		ItemStack speedLeggings =new ItemStack(Material.DIAMOND_LEGGINGS);
		ItemMeta speedleggingsmeta = speedLeggings.getItemMeta();
		speedleggingsmeta.setDisplayName("§6Speed Legging");
		List<String> lorespeed =new ArrayList<String>();
		lorespeed.add("§5Speed legging if you have them you gonna have morespeed");
		speedleggingsmeta.setLore(lorespeed);
		speedLeggings.setItemMeta(speedleggingsmeta);
		if(e.getCurrentItem().isSimilar(speedLeggings) && e.getInventory().getName().equalsIgnoreCase("§2Spéciales Armures")){
			e.setCancelled(true);
			speedeffect(p);
			speedleggingsset(p);
			p.closeInventory();
		}
		if(e.getCurrentItem().isSimilar(firearmor) && e.getInventory().getName().equalsIgnoreCase("§2Spéciales Armures")){
			e.setCancelled(true);
			firearmorset(p);
			effectfirearmor(p);
			p.closeInventory();
		}
	}
	public void ouverturemenu(Player p){
		inv = Bukkit.createInventory(null, 9, "§2Spéciales Armures");
		
		ItemStack firearmor =new ItemStack(Material.GOLD_CHESTPLATE);
		ItemMeta firearmormeta = firearmor.getItemMeta();
		firearmormeta.setDisplayName("§c§lFire Armor");
		List<String> firelore =new ArrayList<String>();
		firelore.add("§b§lUne Armure unique qui envoie du feux a ce qui vous attaquent");
		firearmormeta.setLore(firelore);
		firearmor.setItemMeta(firearmormeta);
		
		inv.setItem(0, firearmor);
		
		ItemStack speedLeggings =new ItemStack(Material.DIAMOND_LEGGINGS);
		ItemMeta speedleggingsmeta = speedLeggings.getItemMeta();
		speedleggingsmeta.setDisplayName("§6Speed Legging");
		List<String> lorespeed =new ArrayList<String>();
		lorespeed.add("§5Speed legging if you have them you gonna have morespeed");
		speedleggingsmeta.setLore(lorespeed);
		speedLeggings.setItemMeta(speedleggingsmeta);
		inv.setItem(1, speedLeggings);
		p.openInventory(inv);
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void moveevent(PlayerMoveEvent event){
		Player p = event.getPlayer();
		if(fireeffect.contains(p)){
			p.playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 5);
		}
		if(speedeffect.contains(p)){
			p.playEffect(p.getLocation(), Effect.SMOKE, 5);
			p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 40, 1));
		}
	}
	@EventHandler
	public void firedamagebyentity(EntityDamageByEntityEvent eve){
		Player damager = (Player) eve.getDamager();
		Player damaged = (Player) eve.getEntity();
		ItemStack firearmor =new ItemStack(Material.GOLD_CHESTPLATE);
		ItemMeta firearmormeta = firearmor.getItemMeta();
		firearmormeta.setDisplayName("§c§lFire Armor");
		List<String> firelore =new ArrayList<String>();
		firelore.add("§b§lUne Armure unique qui envoie du feux a ce qui vous attaquent");
		firearmormeta.setLore(firelore);
		firearmor.setItemMeta(firearmormeta);
		if(damaged.getInventory().getChestplate().isSimilar(firearmor)){
			damager.setFireTicks(60);
		}
	}
	public void speedeffect(Player p){
		speedeffect.add(p);
	}
	public void speedleggingsset(Player p){
		ItemStack speedLeggings =new ItemStack(Material.DIAMOND_LEGGINGS);
		ItemMeta speedleggingsmeta = speedLeggings.getItemMeta();
		speedleggingsmeta.setDisplayName("§6Speed Legging");
		List<String> lorespeed =new ArrayList<String>();
		lorespeed.add("§5Speed legging if you have them you gonna have morespeed");
		speedleggingsmeta.setLore(lorespeed);
		speedLeggings.setItemMeta(speedleggingsmeta);
		p.getInventory().setLeggings(speedLeggings);
	}
	
}
