package com.familycraftmc.familycraftmod.biome.decorate;

import com.familycraftmc.familycraftmod.blocks.FCBlocks;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockPlanks;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WorldGenEpicLeaf extends WorldGenDecorationBase  {

    @Override
    public List<Biome> getAllowedBiomes()
    {
        List<Biome> biomes = new ArrayList<Biome>();

        biomes.add(Biomes.JUNGLE);
        biomes.add(Biomes.JUNGLE_EDGE);
        biomes.add(Biomes.JUNGLE_HILLS);
        biomes.add(Biomes.MUTATED_JUNGLE);
        biomes.add(Biomes.MUTATED_JUNGLE_EDGE);

        return biomes;
    }

    @Override
    protected boolean doGenerate(World world, Random rand, BlockPos pos)
    {
        if (!(rand.nextInt(rarity) == 0))
            return false;

        BlockPos logPos = this.findBlockInArea(
                world,
                pos,
                3 + rand.nextInt(6),
                3 + rand.nextInt(6),
                Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.JUNGLE),
                true);

        if (logPos == null)
            return false;

        this.setBlockInWorld(world, logPos, FCBlocks.EPIC_LEAF.getDefaultState());

        return true;
    }

}
