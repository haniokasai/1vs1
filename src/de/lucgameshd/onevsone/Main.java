package de.lucgameshd.onevsone;

import cn.nukkit.plugin.PluginBase;
import de.lucgameshd.onevsone.commands.Command_1vs1;
import de.lucgameshd.onevsone.listeners.PlayerDamage;
import de.lucgameshd.onevsone.utils.ArenaManager;
import de.lucgameshd.onevsone.utils.Arenen;
import de.lucgameshd.onevsone.utils.LocationAPI;

public class Main extends PluginBase{
	
	public static String prefix = "§8[§41vs1§8] ";
	
	@Override
	public void onEnable() {
		this.registerCommands();
		this.registerListeners();
		this.loadArenenLevel();
		ArenaManager.createFiles();
		LocationAPI.createFiles();
		super.onEnable();
	}
	
	@Override
	public void onDisable() {
		Arenen.resetArenen();
		super.onDisable();
	}
	
	
	private void registerCommands(){
		this.getServer().getCommandMap().register("help", new Command_1vs1("1vs1"));
	}
	
	private void registerListeners(){
		this.getServer().getPluginManager().registerEvents(new PlayerDamage(), this);
	}
	
	private void loadArenenLevel(){
		this.getServer().loadLevel(LocationAPI.getArenenLevel());
	}

}
