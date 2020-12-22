package fr.uracraft.futuresversionsmod.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;

public class ClientProxy extends CommonProxy
{
    public static KeyBinding autoJumpKey;

    public ClientProxy() {
        autoJumpKey = new KeyBinding("futuresversionsmod.autoJump", Keyboard.KEY_J, "key.categories.movement");
        ClientRegistry.registerKeyBinding(autoJumpKey);
    }

    @Override
    public void registerRender()
    {
        System.out.println("méthode côté client");
    }
}