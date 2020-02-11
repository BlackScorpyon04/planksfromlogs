package me.jordan.planksfromlogs;

import org.bukkit.plugin.java.JavaPlugin;

import me.jordan.planksfromlogs.listeners.BreakBlock;


public class Main extends JavaPlugin {
	
	public static Main plugin;
	
	public void onEnable() {
		plugin = this;
		
		saveDefaultConfig();
		
		new BreakBlock(this);
	}

}
