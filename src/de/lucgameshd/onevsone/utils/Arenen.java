package de.lucgameshd.onevsone.utils;

import java.io.File;
import java.util.List;

import cn.nukkit.Player;
import cn.nukkit.level.Position;
import cn.nukkit.utils.Config;

public class Arenen {
	
	private static File ordner = new File("plugins/1VS1");
	public static File file = new File(ordner, "ArenaManager.yml");
	public static Config cfg = new Config(file, 2);
	
	public static void createArena(String arena){
		List<String> list = cfg.getStringList("1vs1.Maps");
		list.add(arena);
		cfg.set("1vs1.Maps", list);
		cfg.save();
	}
	
	public static void setStart1(Player p, String arena){
		LocationAPI.setArenaLocation("Start1", arena, p.getLocation());
	}
	
	public static Position getStart1(String arenen){
		return LocationAPI.getArenaLocation("Start1", arenen);
	}
	
	public static void setStart2(Player p, String arena){
		LocationAPI.setArenaLocation("Start2", arena, p.getLocation());
	}
	
	public static Position getStart2(String arenen){
		return LocationAPI.getArenaLocation("Start2", arenen);
	}

}
