package de.lucgameshd.onevsone.listeners;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import de.lucgameshd.onevsone.utils.Arenen;

public class PlayerJoin implements Listener{
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		String arena = Arenen.getArena(p);
		if(Arenen.isInArena(p)){
			Arenen.removePlayer(arena, p.getName());
		}
		
		p.sendMessage("ßeßlª ßrß3Willkommen ße" + p.getName() + " ß3auf dem 1vs1 Server");
		p.sendMessage("ßeßlª ßrß3Der Server ist derzeit in der ßcBETA");
		p.sendMessage("ßeßlª ßrß3Seid nett zu anderen und habt Spaﬂ!");
		
		p.setHealth(20);
		p.getFoodData().reset();
		p.setOnFire(0);
		p.getInventory().clearAll();
		p.getEffects().clear();
		
		e.getJoinMessage().setText("");
	}

}
