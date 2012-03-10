package net.livecraft.DrAgonmoray.uCreate.listeners;

import net.livecraft.DrAgonmoray.uCreate.uCreate;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class NoWeather implements Listener {

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onWeatherChange(WeatherChangeEvent event) {
		if (uCreate.checkWorld(event.getWorld().getName())) {
			event.setCancelled(true);	
			event.getWorld().setStorm(false);
			event.getWorld().setThundering(false);
		}
	}
}
