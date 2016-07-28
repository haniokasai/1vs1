package de.lucgameshd.onevsone.utils;

import java.io.File;
import java.io.IOException;

import cn.nukkit.utils.Config;


public class ArenaManager {

	private static File ordner = new File("plugins/1VS1");
	public static File file = new File(ordner, "ArenaManager.yml");
	public static Config cfg = new Config(file, 2);
	
	public static void createFiles(){
		if(!ordner.exists()){
			ordner.mkdirs();
		}
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
