package fr.uracraft.futuresversionsmod.events;

import fr.uracraft.futuresversionsmod.eep.AutoJumpEEP;
import fr.uracraft.futuresversionsmod.proxy.ClientProxy;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ChatComponentText;

public class FuturesVersionsClientEvents {

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void onKeyInput(KeyInputEvent event) {
        if(ClientProxy.autoJumpKey.isPressed()) {
            AutoJumpEEP props = AutoJumpEEP.get(Minecraft.getMinecraft().thePlayer);
            props.invertAutoJump();
            props.sync();
            if(props.getAutoJump())
                Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText(I18n.format("autoJump.active")));
            else
                Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText(I18n.format("autoJump.notactive")));
        }
    }
}
