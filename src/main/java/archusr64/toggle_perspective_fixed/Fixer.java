package archusr64.toggle_perspective_fixed;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.client.event.MouseEvent;

@Mod(modid = "toggle_perspective_fixed", version = "1.0.0", clientSideOnly = true)
public class Fixer {
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        // some example code
        System.out.println("DIRT BLOCK >> " + Blocks.dirt.getUnlocalizedName());
    }
}
