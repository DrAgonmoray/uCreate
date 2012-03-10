package net.livecraft.DrAgonmoray.uCreate.listeners;

import net.livecraft.DrAgonmoray.uCreate.uCreate;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.inventory.ItemStack;

public class Commands implements Listener {
	
	@EventHandler(priority = EventPriority.LOWEST)
	public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
		Player player = event.getPlayer();
		String[] message = event.getMessage().trim().substring(1).split(" ");
		String com = message[0].toLowerCase();		
		if (uCreate.checkWorld(player.getWorld().getName())) {
			if (com.equals("i")||com.equals("item")) {
				if (uCreate.itemspawn) {
					try {
						if (message.length >=2) {
							if (player.hasPermission("ucreate.itemspawn"))
								return;
							int qty = (message.length>=3)?Integer.parseInt(message[2]):uCreate.stacksize;
							String item = message[1].split(":")[0];
							int damage = (message.length >= 4)?Integer.parseInt(message[3]):0;
							ItemStack stack = new ItemStack(Material.matchMaterial(item), qty, (byte)damage);
							player.getInventory().addItem(stack);
						}
					} catch (Exception e) {
						//wat.
					}
					event.setCancelled(true);
				}
			} else if (com.equals("wool")) {
				if (uCreate.wool) {
					if (player.hasPermission("ucreate.wool"))
						return;
					for (int i = 1; i <= 15; i++) {
						player.getInventory().addItem(new ItemStack(35, 64, (short)i, (byte)i));
					}
					event.setCancelled(true);
				}
			} else if (com.equals("clearinv")) {
				if (uCreate.clearinv) {
					if (player.hasPermission("ucreate.clearinv"))
						return;
					player.getInventory().clear();
					event.setCancelled(true);
				}
			}
		}
	}
	
}
