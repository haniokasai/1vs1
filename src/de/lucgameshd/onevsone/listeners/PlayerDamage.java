package de.lucgameshd.onevsone.listeners;

import java.util.HashMap;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.entity.EntityDamageByEntityEvent;
import cn.nukkit.event.entity.EntityDamageEvent;
import de.lucgameshd.onevsone.Main;

public class PlayerDamage implements Listener{
	
	public HashMap<String, String> challengesend = new HashMap<String, String>();
	public HashMap<String, String> challangerequest = new HashMap<String, String>();
	
	@EventHandler
	public void onChallangePlayer(EntityDamageEvent e){
		if(e instanceof EntityDamageByEntityEvent){
			if(e.getEntity() instanceof Player){
				if(((EntityDamageByEntityEvent) e).getDamager() instanceof Player){
					Player p = (Player) e.getEntity();
					Player damager = (Player) ((EntityDamageByEntityEvent) e).getDamager();
					
					if(challengesend.containsKey(p.getName()) || challangerequest.containsKey(damager.getName())){
						if(challengesend.get(p.getName()).equals(damager.getName()) && challangerequest.get(damager.getName()).equals(p.getName())){
							
							challengesend.remove(p.getName(), damager.getName());
							challangerequest.remove(damager.getName(), p.getName());
							
							p.sendMessage("Angenommen");
							damager.sendMessage("Angenommen");
							
							e.setCancelled(true);
						}else{
							if(!challangerequest.containsKey(p.getName())){
								if(!challengesend.containsKey(damager.getName())){
									damager.sendTip("�3Du hast �e" + p.getName() + " �3herrausgefordert");
									p.sendMessage(Main.prefix + "�3Du wurdest von �e" + damager.getName() + " �3herrausgefordert");
									challengesend.put(damager.getName(), p.getName());
									challangerequest.put(p.getName(), damager.getName());
									e.setCancelled(true);
								}
							}else{
								damager.sendMessage(Main.prefix + "�3Du hast schon �e" + p.getName() + " �3herrausgefordert!");
								e.setCancelled(true);
							}
						}
					}else{
						if(!challangerequest.containsKey(p.getName())){
							if(!challengesend.containsKey(damager.getName())){
								damager.sendTip("�3Du hast �e" + p.getName() + " �3herrausgefordert");
								p.sendMessage(Main.prefix + "�3Du wurdest von �e" + damager.getName() + " �3herrausgefordert");
								challengesend.put(damager.getName(), p.getName());
								challangerequest.put(p.getName(), damager.getName());
								e.setCancelled(true);
							}
						}else{
							damager.sendMessage(Main.prefix + "�3Du hast schon �e" + p.getName() + " �3herrausgefordert!");
							e.setCancelled(true);
						}
					}
					
				}
			}
		}
	}
}
