package fr.uracraft.futuresversionsmod.events;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import fr.uracraft.futuresversionsmod.common.FuturesVersionsBlocks;
import fr.uracraft.futuresversionsmod.eep.AutoJumpEEP;
import fr.uracraft.futuresversionsmod.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

public class FuturesVersionsEvents {

    @SubscribeEvent
    public void grassPath(PlayerInteractEvent event) {
        if (event.entityPlayer != null) {
            World world = event.entityPlayer.worldObj;
            if (event.action == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK) {
                if (world.getBlock(event.x, event.y, event.z) == Blocks.grass) {
                    ItemStack stack = event.entityPlayer.getCurrentEquippedItem();
                    if (stack != null && (stack.getItem() instanceof ItemSpade)) {
                        world.setBlock(event.x, event.y, event.z, FuturesVersionsBlocks.grass_path);
                        event.entityPlayer.swingItem();
                        stack.damageItem(1, event.entityPlayer);
                        world.playSoundEffect(event.x + 0.5F, event.y + 0.5F, event.z + 0.5F, Block.soundTypeGravel.getStepResourcePath(), 1.0F, 0.8F);
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public void onEntityConstructing(EntityEvent.EntityConstructing event) {
        if(event.entity instanceof EntityPlayer && AutoJumpEEP.get((EntityPlayer) event.entity) == null) {
            AutoJumpEEP.register((EntityPlayer) event.entity);
        }
    }

    @SubscribeEvent
    public void onLivingDeathEvent(LivingDeathEvent event) {
        if(!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayer) {
            NBTTagCompound playerData = new NBTTagCompound();
            AutoJumpEEP.get((EntityPlayer) event.entity).saveNBTData(playerData);
            CommonProxy.storeEntityData(((EntityPlayer) event.entity).getDisplayName(), playerData);
            AutoJumpEEP.saveProxyData((EntityPlayer) event.entity);
        }
    }

    @SubscribeEvent
    public void onEntityJoinWorld(EntityJoinWorldEvent event) {

        if (!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayer) {
            NBTTagCompound playerData = CommonProxy.getEntityData(((EntityPlayer) event.entity).getDisplayName());
            if (playerData != null) {
                AutoJumpEEP.get((EntityPlayer) event.entity).loadNBTData(playerData);
            }

            AutoJumpEEP.get((EntityPlayer) event.entity).sync();
        }
    }

    @SubscribeEvent
    public void tickEvent(PlayerTickEvent event)
    {
        if (event.player.isSneaking())
            event.player.stepHeight = 0.6F;
        else if (AutoJumpEEP.get(event.player) != null && AutoJumpEEP.get(event.player).getAutoJump())
            event.player.stepHeight = 1.25F;
        else
            event.player.stepHeight = 0.6F;
    }
}
