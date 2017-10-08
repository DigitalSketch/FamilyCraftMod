package com.familycraftmc.familycraftmod.event;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.familycraftmc.familycraftmod.biome.decorate.WorldGenDecorationBase;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.brewing.PotionBrewEvent;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.InitMapGenEvent;
import net.minecraftforge.event.terraingen.InitMapGenEvent.EventType;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import com.familycraftmc.familycraftmod.FCConfig;
import com.familycraftmc.familycraftmod.biome.decorate.WorldGenEpicLeaf;
import com.familycraftmc.familycraftmod.blocks.EpicLeafBlock;
import com.familycraftmc.familycraftmod.blocks.FCBlocks;

public class FCEvents
{
	private static List<WorldGenDecorationBase> decorations;
	private static List<WorldGenDecorationBase> oreDecorations;
	
	static
	{
		decorations = new ArrayList<WorldGenDecorationBase>();
		oreDecorations = new ArrayList<WorldGenDecorationBase>();

		decorations.add(new WorldGenEpicLeaf().setRarity(FCConfig.generation_epic_leaf_block_rarity));
	}
	
	@SubscribeEvent
	public void onMapGenEvent(InitMapGenEvent event)
	{
		if (event.getType() == EventType.SCATTERED_FEATURE)
		{
			;
		}
	}
	
	@SubscribeEvent
	public void BiomeOreGen(OreGenEvent.Pre event)
	{
		World world = event.getWorld();
		BlockPos pos = event.getPos();
		Random rand = event.getRand();
		Biome biome = world.getBiomeForCoordsBody(pos);
		
		for (WorldGenDecorationBase decoration : oreDecorations)
		{
			if (decoration.getAllowedBiomes().contains(biome))
			{
				decoration.generate(world, rand, pos);
			}
		}
	}
	
	@SubscribeEvent
	public void BiomeDecorate(DecorateBiomeEvent.Post event)
	{
		World world = event.getWorld();
		BlockPos pos = event.getPos();
		Random rand = event.getRand();
		Biome biome = world.getBiomeForCoordsBody(pos);
		
		for (WorldGenDecorationBase decoration : decorations)
		{
			if (decoration.getAllowedBiomes().contains(biome))
			{
				decoration.generate(world, rand, pos);
			}
		}
	}
	
	@SubscribeEvent
	public void onBrew(PotionBrewEvent.Pre event)
	{
		;
	}
}
