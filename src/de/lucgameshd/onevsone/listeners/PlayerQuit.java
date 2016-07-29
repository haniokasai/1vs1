package de.lucgameshd.onevsone.listeners;

import java.util.List;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerQuitEvent;
import de.lucgameshd.onevsone.utils.Arenen;
import de.lucgameshd.onevsone.utils.Match;

public class PlayerQuit implements Listener{
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e){
		Player p = e.getPlayer();
		String arena = Arenen.getArena(p);
		String status = Arenen.getStatus(arena);
		List<String> players = Arenen.getPlayers(arena);
		int playerSize = players.size();
		
		if(Arenen.isInArena(p)){
			if(status.equals("Ingame")){
				Arenen.removePlayer(arena, p.getName());
				if((playerSize -1) < 2){
					for(String names : players){
						Player pl = Server.getInstance().getPlayerExact(names);
						if(pl != null){
							Match.removeMatch(pl);
						}
					}
				}
			}
		}
		e.getQuitMessage().setText("");
	}
}
