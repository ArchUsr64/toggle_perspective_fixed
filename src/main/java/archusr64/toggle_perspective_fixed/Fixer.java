package archusr64.toggle_perspective_fixed;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.MouseInputEvent;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;

@Mod(modid = "toggle_perspective_fixed", version = "1.0.0", clientSideOnly = true)
public class Fixer {
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onInput(MouseInputEvent event) {
        Minecraft game = Minecraft.getMinecraft();
        GameSettings settings = game.gameSettings;
        if (settings.keyBindTogglePerspective.isPressed()) {
            ++settings.thirdPersonView;

            if (settings.thirdPersonView > 2) {
                settings.thirdPersonView = 0;
            }

            if (settings.thirdPersonView == 0) {
                game.entityRenderer.loadEntityShader(game.getRenderViewEntity());
            } else if (settings.thirdPersonView == 1) {
                game.entityRenderer.loadEntityShader((Entity) null);
            }

            game.renderGlobal.setDisplayListEntitiesDirty();
        }
    }
}
