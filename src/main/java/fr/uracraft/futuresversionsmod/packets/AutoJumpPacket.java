package fr.uracraft.futuresversionsmod.packets;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import fr.uracraft.futuresversionsmod.eep.AutoJumpEEP;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;

public class AutoJumpPacket implements IMessage
{
    private boolean autoJump;

    public AutoJumpPacket() { }

    public AutoJumpPacket(boolean autoJump) {
        this.autoJump = autoJump;
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        autoJump = buf.readBoolean();
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeBoolean(autoJump);
    }

    public static class Handler implements IMessageHandler<AutoJumpPacket, IMessage> {

        @Override
        public IMessage onMessage(AutoJumpPacket message, MessageContext ctx)
        {
            AutoJumpEEP props;
            if(ctx.side == Side.SERVER)
                props = AutoJumpEEP.get(ctx.getServerHandler().playerEntity);
            else
                props = AutoJumpEEP.get(Minecraft.getMinecraft().thePlayer);
            props.autoJump = message.autoJump;
            return null;
        }

    }

}
