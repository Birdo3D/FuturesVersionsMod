package fr.uracraft.futuresversionsmod.proxy;

import net.minecraft.nbt.NBTTagCompound;
import java.util.HashMap;
import java.util.Map;

public class CommonProxy
{
    private static final Map <String, NBTTagCompound> extendedEntityData = new HashMap<String, NBTTagCompound>();

    public void registerRender()
    {
        System.out.println("méthode côté serveur");
    }

    public static void storeEntityData(String name, NBTTagCompound compound) {
        extendedEntityData.put(name, compound);
    }

    public static NBTTagCompound getEntityData(String name) {
        return extendedEntityData.remove(name);
    }
}