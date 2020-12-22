package fr.uracraft.futuresversionsmod.eep;

import fr.uracraft.futuresversionsmod.common.FuturesVersionsMod;
import fr.uracraft.futuresversionsmod.packets.AutoJumpPacket;
import fr.uracraft.futuresversionsmod.proxy.CommonProxy;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class AutoJumpEEP implements IExtendedEntityProperties
{
    public final static String EXT_PROP_NAME = "EEPUraMod";
    private final EntityPlayer player;

    public boolean autoJump;

    public AutoJumpEEP(EntityPlayer player) {
        this.player = player;
        this.autoJump = true;
    }

    public static final void register(EntityPlayer player) {
        player.registerExtendedProperties(EXT_PROP_NAME, new AutoJumpEEP(player));
    }

    public static final AutoJumpEEP get(EntityPlayer player) {
        return (AutoJumpEEP) player.getExtendedProperties(EXT_PROP_NAME);
    }

    @Override
    public void saveNBTData(NBTTagCompound compound)
    {
        NBTTagCompound props = new NBTTagCompound();
        props.setBoolean("autoJump", autoJump);
        compound.setTag(EXT_PROP_NAME, props);
    }

    @Override
    public void loadNBTData(NBTTagCompound compound)
    {
        NBTTagCompound props = (NBTTagCompound) compound.getTag(EXT_PROP_NAME);
        autoJump = props.getBoolean("autoJump");
    }

    public final void sync() {
        AutoJumpPacket packetAutoJump = new AutoJumpPacket(autoJump);
        FuturesVersionsMod.fvmpackethandler.sendToServer(packetAutoJump);
        if(!player.worldObj.isRemote) {
            EntityPlayerMP player1 = (EntityPlayerMP) player;
            FuturesVersionsMod.fvmpackethandler.sendTo(packetAutoJump, player1);
        }
    }

    private static String getSaveKey(EntityPlayer player) {
        return player.getDisplayName()+":"+EXT_PROP_NAME;
    }

    public static void saveProxyData(EntityPlayer player) {
        AutoJumpEEP playerData = AutoJumpEEP.get(player);
        NBTTagCompound savedData = new NBTTagCompound();
        playerData.saveNBTData(savedData);
        CommonProxy.storeEntityData(getSaveKey(player), savedData);
    }

    public static void loadProxyData(EntityPlayer player) {
        AutoJumpEEP playerData = AutoJumpEEP.get(player);
        NBTTagCompound savedData = CommonProxy.getEntityData(getSaveKey(player));
        if(savedData != null) {
            playerData.loadNBTData(savedData);
        }
        playerData.sync();
    }

    public boolean getAutoJump() {
        return autoJump;
    }

    public void setAutoJump(boolean autoJump) {
        this.autoJump = autoJump;
        this.sync();
    }

    public void invertAutoJump() {
        this.autoJump = !this.autoJump;
        this.sync();
    }

    @Override
    public void init(Entity entity, World world)
    {

    }

}