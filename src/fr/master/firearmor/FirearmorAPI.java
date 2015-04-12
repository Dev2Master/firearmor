package fr.master.firearmor;

import org.bukkit.entity.Player;

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

}
