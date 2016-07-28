package de.lucgameshd.onevsone;

import cn.nukkit.plugin.PluginBase;
import de.lucgameshd.onevsone.utils.ArenaManager;
import de.lucgameshd.onevsone.utils.LocationAPI;

public class Main extends PluginBase{
	
	
	@Override
	public void onEnable() {
		this.registerCommands();
		this.registerListeners();
		ArenaManager.createFiles();
		LocationAPI.createFiles();
		super.onEnable();
	}
	
	@Override
	public void onDisable() {

		super.onDisable();
	}
	
	
	private void registerCommands(){
		
	}
	
	private void registerListeners(){
		
	}

}
