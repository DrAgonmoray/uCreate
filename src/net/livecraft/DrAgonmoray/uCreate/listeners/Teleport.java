package net.livecraft.DrAgonmoray.uCreate.listeners;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

import net.livecraft.DrAgonmoray.uCreate.uCreate;


public class Teleport implements Listener {
	
	@EventHandler(priority = EventPriority.MONITOR)
	public void onPlayerTeleport(PlayerTeleportEvent event) {
		if (uCreate.checkWorld(event.getTo().getWorld().getName())) {
			if (event.getPlayer().hasPermission("ucreate.notch"))
				event.getPlayer().setGameMode(GameMode.CREATIVE);
		} else {
			event.getPlayer().setGameMode(GameMode.SURVIVAL);
		}
	}
	
}

