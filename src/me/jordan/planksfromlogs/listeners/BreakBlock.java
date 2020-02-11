package me.jordan.planksfromlogs.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import me.jordan.planksfromlogs.Main;

public class BreakBlock implements Listener{
	
	private Main plugin;
	
	public BreakBlock(Main plugin) {
		Bukkit.getPluginManager().registerEvents(this, plugin);
		this.plugin = plugin;
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onBlockBreak(BlockBreakEvent e){
		Player p = e.getPlayer();
		if (!p.hasPermission("pfl.log")) {
			int planksToDrop = plugin.getConfig().getInt("droppedplanks");
			if (e.getBlock().getType() == Material.ACACIA_LOG || e.getBlock().getType() == Material.STRIPPED_ACACIA_LOG || e.getBlock().getType() == Material.STRIPPED_ACACIA_WOOD || e.getBlock().getType() == Material.ACACIA_WOOD) {
				changeDrop(e.getBlock(),new ItemStack(Material.ACACIA_PLANKS, planksToDrop));
			}else if (e.getBlock().getType() == Material.BIRCH_LOG || e.getBlock().getType() == Material.STRIPPED_BIRCH_LOG|| e.getBlock().getType() == Material.STRIPPED_BIRCH_WOOD || e.getBlock().getType() == Material.BIRCH_WOOD) {
				changeDrop(e.getBlock(),new ItemStack(Material.BIRCH_PLANKS, planksToDrop));
			}else if (e.getBlock().getType() == Material.DARK_OAK_LOG || e.getBlock().getType() == Material.STRIPPED_DARK_OAK_LOG|| e.getBlock().getType() == Material.STRIPPED_DARK_OAK_WOOD || e.getBlock().getType() == Material.DARK_OAK_WOOD) {
				changeDrop(e.getBlock(),new ItemStack(Material.DARK_OAK_PLANKS, planksToDrop));
			}else if (e.getBlock().getType() == Material.JUNGLE_LOG || e.getBlock().getType() == Material.STRIPPED_JUNGLE_LOG|| e.getBlock().getType() == Material.STRIPPED_JUNGLE_WOOD || e.getBlock().getType() == Material.JUNGLE_WOOD) {
				changeDrop(e.getBlock(),new ItemStack(Material.JUNGLE_PLANKS, planksToDrop));
			}else if (e.getBlock().getType() == Material.SPRUCE_LOG || e.getBlock().getType() == Material.STRIPPED_SPRUCE_LOG|| e.getBlock().getType() == Material.STRIPPED_SPRUCE_WOOD || e.getBlock().getType() == Material.SPRUCE_WOOD) {
				changeDrop(e.getBlock(),new ItemStack(Material.SPRUCE_PLANKS, planksToDrop));
			}else if (e.getBlock().getType() == Material.OAK_LOG || e.getBlock().getType() == Material.STRIPPED_OAK_LOG|| e.getBlock().getType() == Material.STRIPPED_OAK_WOOD || e.getBlock().getType() == Material.OAK_WOOD) {
				changeDrop(e.getBlock(), new ItemStack(Material.OAK_PLANKS, planksToDrop));
			}
		}
	}
	
	public void changeDrop(Block block, ItemStack newDrop) {
		block.setType(Material.AIR);
		block.getWorld().dropItemNaturally(block.getLocation(), newDrop);
	}
}
