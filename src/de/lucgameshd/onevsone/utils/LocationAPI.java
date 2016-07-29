package de.lucgameshd.onevsone.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import cn.nukkit.Server;
import cn.nukkit.level.Level;
import cn.nukkit.level.Position;
import cn.nukkit.utils.Config;

public class LocationAPI {

	private static File ordner = new File("plugins/1VS1");
	public static File file = new File(ordner, "Locations.yml");
	public static Config cfg = new Config(file, 2);
	
	public static ArrayList<String> isUsed = new ArrayList<String>();
	
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
	
	public static void setArenenLevel(Level level){
		cfg.set("1vs1.ArenenLevel", level.getName());
		cfg.save();
	}
	
	public static String getArenenLevel(){
		return cfg.getString("1vs1.ArenenLevel");
	}
	
	public static void setLocation(String path, Position loc){
		cfg.set("1vs1." + path + ".World", loc.getLevel().getName());
		cfg.set("1vs1." + path + ".X", loc.getX());
		cfg.set("1vs1." + path + ".Y", loc.getY());
		cfg.set("1vs1." + path + ".Z", loc.getZ());
		cfg.save();
	}
	
	public static Position getLocation(String path){
		Position pos = null;
		Level level = Server.getInstance().getLevelByName(cfg.getString("1vs1." + path + ".World"));
		double x = cfg.getDouble("1vs1." + path + ".X");
		double y = cfg.getDouble("1vs1." + path + ".Y");
		double z = cfg.getDouble("1vs1." + path + ".Z");
		pos = new Position(x, y, z, level);
		return pos;
	}
	
	public static void setArenaLocation(String path, String arena, Position loc){
		cfg.set("1vs1.Arena." + arena + "." + path + ".World", loc.getLevel().getName());
		cfg.set("1vs1.Arena." + arena + "." + path + ".X", loc.getX());
		cfg.set("1vs1.Arena." + arena + "." + path + ".Y", loc.getY());
		cfg.set("1vs1.Arena." + arena + "." + path + ".Z", loc.getZ());
		cfg.save();
	}
	
	public static Position getArenaLocation(String path, String arena){
		Position pos = null;
		Level level = Server.getInstance().getLevelByName(cfg.getString("1vs1.Arena." + arena + "." + path + ".World"));
		double x = cfg.getDouble("1vs1.Arena." + arena + "." + path + ".X");
		double y = cfg.getDouble("1vs1.Arena." + arena + "." + path + ".Y");
		double z = cfg.getDouble("1vs1.Arena." + arena + "." + path + ".Z");
		pos = new Position(x, y, z, level);
		return pos;
	}
	
}
