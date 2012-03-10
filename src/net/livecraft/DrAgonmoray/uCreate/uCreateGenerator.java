package net.livecraft.DrAgonmoray.uCreate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;

public class uCreateGenerator extends ChunkGenerator {
	int size;
	public uCreateGenerator(int a) {
		if (a < 2) a = 2;
		size = a;
	}
    @Override
    public List<BlockPopulator> getDefaultPopulators(World world) {
        return new ArrayList<BlockPopulator>();
    }
    
    
    @Override
    public boolean canSpawn(World world, int x, int z) {
        return true;
    }
    
    
    public int xyzToByte(int x, int y, int z) {
    	return (x * 16 + z) * 128 + y;
    }

    
    @Override
    public byte[] generate(World world, Random rand, int chunkx, int chunkz) {
    byte[] result = new byte[32768];
    Material mat;
    for (int y = 0; y < size; y++) {
	    for(int x = 0; x < 16; x++){
		    for(int z = 0; z < 16; z++) {
		    	if (y == 0) {
		    		mat = Material.BEDROCK;
		    	} else if (y == size-1) {
		    		mat = Material.GRASS;
		    	} else {
		    		mat = Material.STONE;
		    	}
		    	result[xyzToByte(x,y,z)] = (byte) mat.getId();
		    }
	    }
    }
    return result;
    }

}
