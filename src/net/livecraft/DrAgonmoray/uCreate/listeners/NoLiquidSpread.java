package net.livecraft.DrAgonmoray.uCreate.listeners;

import net.livecraft.DrAgonmoray.uCreate.uCreate;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFromToEvent;

public class NoLiquidSpread implements Listener {

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onBlockFromTo(BlockFromToEvent event) {
		if (uCreate.checkWorld(event.getBlock().getWorld().getName())) {
			int id = event.getBlock().getTypeId();
			if (id==8||id==9||id==10||id==11) 
				event.setCancelled(true);
		}
	}
}
