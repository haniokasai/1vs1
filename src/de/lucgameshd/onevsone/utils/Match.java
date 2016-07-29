package de.lucgameshd.onevsone.utils;

import java.util.HashMap;

import cn.nukkit.Player;
import cn.nukkit.Server;
import de.lucgameshd.onevsone.Main;

public class Match {
	
	private static HashMap<String, Integer> countdown = new HashMap<String, Integer>();
	
	private static String foundedmap;
	
	public static String getArenaName(){
		return foundedmap;
	}
	
	public static void startMatch(Player p1, Player p2){
		foundedmap = ArenaManager.searchForArena();
		if(foundedmap.equals("NothingFound!")){
			p1.sendMessage(Main.prefix + "§cEs konnte keine Freie Arena gefunden werden. Bitte versuche es gleich nochmal");
			p2.sendMessage(Main.prefix + "§cEs konnte keine Freie Arena gefunden werden. Bitte versuche es gleich nochmal");
			return;
		}
		Arenen.addPlayer(foundedmap, p1.getName());
		Arenen.addPlayer(foundedmap, p2.getName());
		
		p1.teleport(Arenen.getStart1(foundedmap));
		p2.teleport(Arenen.getStart2(foundedmap));
		
		p1.getInventory().clearAll();
		p2.getInventory().clearAll();
		
		
		Arenen.setStatus(foundedmap, "Ingame");
		ArenaManager.addInUsed(foundedmap);
		
		//TODO Kit dem Spieler zuweisen
		
		countdown.put(foundedmap, 4);
		
		
		Server.getInstance().getScheduler().scheduleRepeatingTask(new Runnable() {
			
			@Override
			public void run() {
				int time = countdown.get(foundedmap);
				if(time != 0){
					time--;
					countdown.put(foundedmap, time);
					if(time == 3 || time == 2 || time == 1){
						p1.sendMessage(Main.prefix + "§3Der Kampf beginnt in §e" + time + " §3Sekunde(n)");			
						p2.sendMessage(Main.prefix + "§3Der Kampf beginnt in §e" + time + " §3Sekunde(n)");			
					}else
					if(time == 0){
						p1.sendMessage(Main.prefix + "§aDer Kampf beginnt! Viel Glück!");
						p2.sendMessage(Main.prefix + "§aDer Kampf beginnt! Viel Glück!");	
					}
				}
				
			}
		}, 20);
		
	}
	
	public static void removeMatch(Player p){
		String arena = Arenen.getArena(p);
		Arenen.removePlayer(arena, p.getName());
		p.setHealth(20);
		p.getFoodData().reset();
		p.setOnFire(0);
		p.getEffects().clear();
		p.getInventory().clearAll();
		p.sendMessage(Main.prefix + "§aGlückwunsch du hast das Match gewonnen!");
		p.teleport(LocationAPI.getLocation("Lobby"));
		Arenen.setStatus(arena, "Frei");
		ArenaManager.removeInUsed(arena);
	}
}
