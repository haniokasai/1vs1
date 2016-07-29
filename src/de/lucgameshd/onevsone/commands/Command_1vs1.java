package de.lucgameshd.onevsone.commands;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import de.lucgameshd.onevsone.Main;
import de.lucgameshd.onevsone.utils.Arenen;
import de.lucgameshd.onevsone.utils.LocationAPI;

public class Command_1vs1 extends Command{

	public Command_1vs1(String name) {
		super(name);
	}

	@Override
	public boolean execute(CommandSender sender, String arg1, String[] args) {
		Player p = (Player) sender;
		
		if(p.isOp()){
			if(args.length == 0){
				p.sendMessage(Main.prefix + "§c- /1vs1 setlobby");
				p.sendMessage(Main.prefix + "§c- /1vs1 setarenen");
				p.sendMessage(Main.prefix + "§c- /1vs1 create <arena>");
				p.sendMessage(Main.prefix + "§c- /1vs1 setstart1 <arena>");
				p.sendMessage(Main.prefix + "§c- /1vs1 setstart2 <arena>");
			}else
			if(args.length == 1){
				if(args[0].equalsIgnoreCase("setlobby")){
					LocationAPI.setLocation("Lobby", p.getLocation());
					p.sendMessage(Main.prefix + "§aDu hast die Lobby für 1vs1 gesetzt!");
				}else
				if(args[0].equalsIgnoreCase("setarenen")){
					LocationAPI.setArenenLevel(p.getLevel());
					p.sendMessage(Main.prefix + "§aDu hast die Arenen Welt festgelegt!");
				}else{
					p.sendMessage(Main.prefix + "§c- /1vs1 setlobby");
					p.sendMessage(Main.prefix + "§c- /1vs1 create <arena>");
					p.sendMessage(Main.prefix + "§c- /1vs1 setstart1 <arena>");
					p.sendMessage(Main.prefix + "§c- /1vs1 setstart2 <arena>");
				}
			}else
			if(args.length == 2){
				if(args[0].equalsIgnoreCase("create")){
					Arenen.createArena(args[1]);
					p.sendMessage(Main.prefix + "§aDu hast die Arena §e" + args[1] + " §aerstellt!");
				}else
				if(args[0].equalsIgnoreCase("setstart1")){
					Arenen.setStart1(p, args[1]);
					p.sendMessage(Main.prefix + "§aDu hast die erste Position für die Arena §e" + args[1] + " §agesetzt!");
				}else
				if(args[0].equalsIgnoreCase("setstart2")){
					Arenen.setStart2(p, args[1]);
					p.sendMessage(Main.prefix + "§aDu hast die zweite Position für die Arena §e" + args[1] + " §agesetzt!");
				}else{
					p.sendMessage(Main.prefix + "§c- /1vs1 setlobby");
					p.sendMessage(Main.prefix + "§c- /1vs1 create <arena>");
					p.sendMessage(Main.prefix + "§c- /1vs1 setstart1 <arena>");
					p.sendMessage(Main.prefix + "§c- /1vs1 setstart2 <arena>");
				}
			}
			
		}else{
			p.sendMessage(Main.prefix + "§cDu hast keine Rechte für diesen Command!");
		}
		
		return true;
	}

}
