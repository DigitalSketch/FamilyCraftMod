package com.familycraftmc.familycraftmod;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class FCConfig
{

    public static int generation_epic_leaf_block_rarity = 60;

    public static boolean output_generation_log = true;
    public static Configuration configuration;

    public static void init(File cFile)
    {
        configuration = new Configuration(cFile);
        configuration.load();

        configuration.addCustomCategoryComment("WORLD_GENERATION_RARITY", "The higher the number, the more rare generation is.");

        generation_epic_leaf_block_rarity = configuration.getInt("generation_epic_leaf_block_rarity", "WORLD_GENERATION_RARITY", generation_epic_leaf_block_rarity, 0, Integer.MAX_VALUE, "");

        configuration.save();
    }
}
