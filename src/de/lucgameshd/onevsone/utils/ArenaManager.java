package de.lucgameshd.onevsone.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cn.nukkit.utils.Config;

public class ArenaManager {

	private static File ordner = new File("plugins/1VS1");
	public static File file = new File(ordner, "ArenaManager.yml");
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
	
	public static void addInUsed(String arena){
		if(!isUsed.contains(arena)){
			isUsed.add(arena);
		}
	}
	
	public static void removeInUsed(String arena){
		if(isUsed.contains(arena)){
			isUsed.remove(arena);
		}
	}
	
	public static boolean isUsed(String arena){
		if(isUsed.contains(arena)){
			return true;
		}else{
			return false;
		}
	}
	
	public static String searchForArena(){
		List<String> list = cfg.getStringList("1vs1.Arenen.Names");
		Random r = new Random();
		boolean found = false;
		while(found == false){
			int rn = r.nextInt(list.size());
			if(isUsed(list.get(rn))){
				continue;
			}else{
				found = true;
				return searchInList();
			}
		}
		return "NothingFound!";
	}
	
	public static String searchInList(){
		List<String> list = cfg.getStringList("1vs1.Arenen.Names");
		for(String s : list){
			if(isUsed(s)){
				continue;
			}else{
				return s;
			}
		}
		return "NothingFound!";
	}
	
}
