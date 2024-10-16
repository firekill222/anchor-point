package net.runelite.client.plugins.underminimap;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.PanelComponent;

public class UnderMinimapOverlay extends Overlay
{
    private final Client client;
    private final PanelComponent panelComponent = new PanelComponent();

    @Inject
    private UnderMinimapOverlay(Client client)
    {
        this.client = client;
        setPosition(OverlayPosition.DYNAMIC);
        setMovable(true);
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        Rectangle minimapBounds = client.getWidget(net.runelite.api.widgets.WidgetInfo.MINIMAP_DRAW_AREA).getBounds();
        int x = minimapBounds.x;
        int y = minimapBounds.y + minimapBounds.height + 5; // 5 pixels below minimap

        panelComponent.setPreferredLocation(new java.awt.Point(x, y));
        panelComponent.setPreferredSize(new Dimension(minimapBounds.width, 30));

        panelComponent.getChildren().clear();
        panelComponent.getChildren().add(net.runelite.client.ui.overlay.components.TitleComponent.builder()
            .text("Under Minimap")
            .build());

        return panelComponent.render(graphics);
    }
}
