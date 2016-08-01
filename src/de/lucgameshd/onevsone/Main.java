package de.lucgameshd.onevsone;

import cn.nukkit.plugin.PluginBase;
import de.lucgameshd.onevsone.commands.Command_1vs1;
import de.lucgameshd.onevsone.listeners.PlayerDamage;
import de.lucgameshd.onevsone.listeners.PlayerJoin;
import de.lucgameshd.onevsone.listeners.PlayerQuit;
import de.lucgameshd.onevsone.utils.ArenaManager;
import de.lucgameshd.onevsone.utils.Arenen;
import de.lucgameshd.onevsone.utils.LocationAPI;

public class Main extends PluginBase{
	
	public static String prefix = "§8[§41vs1§8] ";
	
	@Override
	public void onEnable() {
		getDataFolder().mkdir();
		this.registerCommands();
		this.registerListeners();
		this.loadArenenLevel();
		ArenaManager.createFiles();
		LocationAPI.createFiles();
		Arenen.resetArenen();
		super.onEnable();
	}
	
	@Override
	public void onDisable() {
		super.onDisable();
	}
	
	
	private void registerCommands(){
		this.getServer().getCommandMap().register("help", new Command_1vs1("1vs1"));
	}
	
	private void registerListeners(){
		this.getServer().getPluginManager().registerEvents(new PlayerDamage(), this);
		this.getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
		this.getServer().getPluginManager().registerEvents(new PlayerQuit(), this);
	}
	
	private void loadArenenLevel(){
		this.getServer().loadLevel(LocationAPI.getArenenLevel());
	}

}
