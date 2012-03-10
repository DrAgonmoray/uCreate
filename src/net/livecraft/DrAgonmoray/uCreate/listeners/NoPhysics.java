package net.livecraft.DrAgonmoray.uCreate.listeners;

import net.livecraft.DrAgonmoray.uCreate.uCreate;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPhysicsEvent;

public class NoPhysics implements Listener {
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onBlockPhysics(BlockPhysicsEvent event) {
		Material type = event.getBlock().getType();
		if (uCreate.checkWorld(event.getBlock().getWorld().getName())) {
			if (type.equals(Material.SAND)||type.equals(Material.GRAVEL))
				event.setCancelled(true);
		}
	}
}
