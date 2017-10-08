package com.familycraftmc.familycraftmod.blocks;

import com.familycraftmc.familycraftmod.FamilyCraftMod;
import com.familycraftmc.familycraftmod.client.Colorizers;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class FCBlocks {

    public static final Block EPIC_LEAF;

    static
    {
        EPIC_LEAF = new EpicLeafBlock().setRegistryName(FamilyCraftMod.MODID, "epic_leaf").setUnlocalizedName("epic_leaf");
    }

    public static void register()
    {
        FamilyCraftMod.proxy.registerBlock(EPIC_LEAF, "epic_leaf_block",true);
    }

    @SideOnly(Side.CLIENT)
    public static void initClient()
    {
        BlockColors blockColors = Minecraft.getMinecraft().getBlockColors();
        ItemColors itemColors = Minecraft.getMinecraft().getItemColors();

        registerColors(blockColors, itemColors, Colorizers.BLOCK_LEAVES, new Block[] { FCBlocks.EPIC_LEAF });
    }

    private static void registerColors(BlockColors blockColors, ItemColors itemColors, IBlockColor color, Block... blocks)
    {
        blockColors.registerBlockColorHandler(color, blocks);
        itemColors.registerItemColorHandler((s, t) -> color.colorMultiplier(Block.getBlockFromItem(s.getItem()).getDefaultState(), null, null, t), blocks);
    }
}
