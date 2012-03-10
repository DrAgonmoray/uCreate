package net.livecraft.DrAgonmoray.uCreate.listeners;

import net.livecraft.DrAgonmoray.uCreate.uCreate;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockSpreadEvent;

public class NoFireSpread implements Listener {

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onBlockSpread(BlockSpreadEvent event) {
		if (event.getSource().getType().equals(Material.FIRE)) {
			if (uCreate.checkWorld(event.getSource().getWorld().getName()))
				event.setCancelled(true);
		}
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onBlockBurn(BlockBurnEvent event) {
		if (uCreate.checkWorld(event.getBlock().getWorld().getName()))
			event.setCancelled(true);
	}
}
