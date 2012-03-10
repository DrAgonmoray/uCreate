package net.livecraft.DrAgonmoray.uCreate.api;

import net.livecraft.DrAgonmoray.uCreate.uCreate;

import org.bukkit.World;

public class uCreateAPI {
	public void registerWorld(World world) {
		uCreate.worlds.add(world.getName());
	}
	
	public void registerWorld(String world) {
		uCreate.worlds.add(world);
	}
	
	public void unregisterWorld(World world) {
		uCreate.worlds.add(world.getName());
	}
	
	public void unregisterWorld(String world) {
		uCreate.worlds.add(world);
	}
	
	public boolean isWorlduCreative(World world) {
		return uCreate.checkWorld(world.getName());
	}
	
	public boolean isWorlduCreative(String world) {
		return uCreate.checkWorld(world);
	}
}
