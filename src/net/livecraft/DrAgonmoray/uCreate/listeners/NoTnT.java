package net.livecraft.DrAgonmoray.uCreate.listeners;

import net.livecraft.DrAgonmoray.uCreate.uCreate;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class NoTnT implements Listener {

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onEntityExplode(EntityExplodeEvent event) {
		if (uCreate.checkWorld(event.getEntity().getWorld().getName()))
			event.setCancelled(true);
	}
}
