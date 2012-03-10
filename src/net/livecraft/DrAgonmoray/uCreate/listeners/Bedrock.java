package net.livecraft.DrAgonmoray.uCreate.listeners;

import net.livecraft.DrAgonmoray.uCreate.uCreate;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class Bedrock implements Listener {
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onBlockPlace(BlockPlaceEvent event) {
		if (uCreate.checkWorld(event.getBlock().getWorld().getName())) {
			if (event.getBlock().getType() == Material.BEDROCK)
				event.setCancelled(true);
		}
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onBlockBreak(BlockBreakEvent event) {
		if (uCreate.checkWorld(event.getBlock().getWorld().getName())) {
			if (event.getBlock().getType() == Material.BEDROCK)
				event.setCancelled(true);
		}
	}
}
