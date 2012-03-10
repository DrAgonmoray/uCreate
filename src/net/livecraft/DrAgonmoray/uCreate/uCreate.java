package net.livecraft.DrAgonmoray.uCreate;

import java.io.IOException;
import java.util.HashSet;

import net.livecraft.DrAgonmoray.uCreate.listeners.Bedrock;
import net.livecraft.DrAgonmoray.uCreate.listeners.Commands;
import net.livecraft.DrAgonmoray.uCreate.listeners.NoDrops;
import net.livecraft.DrAgonmoray.uCreate.listeners.NoFireSpread;
import net.livecraft.DrAgonmoray.uCreate.listeners.NoLiquidSpread;
import net.livecraft.DrAgonmoray.uCreate.listeners.NoMobs;
import net.livecraft.DrAgonmoray.uCreate.listeners.NoPhysics;
import net.livecraft.DrAgonmoray.uCreate.listeners.NoTnT;
import net.livecraft.DrAgonmoray.uCreate.listeners.NoWeather;
import net.livecraft.DrAgonmoray.uCreate.listeners.Teleport;

import org.bukkit.World;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class uCreate extends JavaPlugin {
	public static HashSet<String> worlds = new HashSet<String>();
	public static boolean itemspawn = false;
	public static boolean clearinv = false;
	public static boolean wool = false;
	public static int stacksize = 64;
	
	@Override
	public void onEnable() {
		getConfig().options().copyDefaults(true);
	    saveConfig();
	    try {
	        MetricsLite metrics = new MetricsLite(this);
	        metrics.start();
	    } catch (IOException e) {
	       
	    }
	    for (String s : getConfig().getString("settings.worlds", "").replace(" ", "").split(",")) {
	    	worlds.add(s);
	    }
		PluginManager pm = getServer().getPluginManager();
		itemspawn = getConfig().getBoolean("commands.itemSpawning");
		clearinv = getConfig().getBoolean("commands.clearinv");
		wool = getConfig().getBoolean("commands.wool");
		stacksize = getConfig().getInt("settings.defaultStackSize");
        if (getConfig().getBoolean("physics.noExplosions")) pm.registerEvents(new NoTnT(), this);
        if (getConfig().getBoolean("world.noWeather")) pm.registerEvents(new NoWeather(), this);
        if (getConfig().getBoolean("general.useBedrock")) pm.registerEvents(new Bedrock(), this);
        if (getConfig().getBoolean("physics.noBlockFall")) pm.registerEvents(new NoPhysics(), this);
        if (getConfig().getBoolean("physics.noLiquidSpread")) pm.registerEvents(new NoLiquidSpread(), this);
        if (getConfig().getBoolean("physics.noFireSpread")) pm.registerEvents(new NoFireSpread(), this);
        if (itemspawn || wool || clearinv) pm.registerEvents(new Commands(), this);
        if (getConfig().getBoolean("world.noCreatures")) pm.registerEvents(new NoMobs(), this);
        if (getConfig().getBoolean("world.noDrops")) pm.registerEvents(new NoDrops(), this);
        pm.registerEvents(new Teleport(), this);
        final String time = getConfig().getString("world.stopTime");
        if (time.equals("day") || time.equals("night")) {
        	getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
        		public void run() {
        			for (World w : getServer().getWorlds()) {
        				if (checkWorld(w.getName())) {
        					w.setTime((time.equals("day"))?6000:18000);
        				}
        			}
        		}
        	}, 0, 600);
        }
	}
	
	public ChunkGenerator getDefaultWorldGenerator(String worldName, String id) {
        return new uCreateGenerator(getConfig().getInt("settings.flatMapHeight"));
    }
	
	public static boolean checkWorld(String world) {
		if (worlds.contains(world))
			return true;
		return false;
	}
}
