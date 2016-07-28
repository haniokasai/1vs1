package de.lucgameshd.onevsone.utils;

import java.io.File;
import java.util.List;

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
	
	

}
