package net.runelite.client.plugins.underminimap;

import com.google.inject.Provides;
import javax.inject.Inject;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
    name = "Under Minimap Anchor",
    description = "Adds a new anchor point under the minimap",
    tags = {"anchor", "overlay", "minimap"}
)
public class UnderMinimapPlugin extends Plugin
{
    @Inject
    private OverlayManager overlayManager;

    @Inject
    private UnderMinimapOverlay underMinimapOverlay;

    @Override
    protected void startUp()
    {
        overlayManager.add(underMinimapOverlay);
    }

    @Override
    protected void shutDown()
    {
        overlayManager.remove(underMinimapOverlay);
    }

    @Provides
    UnderMinimapConfig provideConfig(ConfigManager configManager)
    {
        return configManager.getConfig(UnderMinimapConfig.class);
    }
}
