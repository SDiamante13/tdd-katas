package chartsmart;

import java.awt.*;

public class ChartInfo {
    private final Graphics graphics;
    private final String[] data;
    private final Font font;
    private final int bottomY;

    public ChartInfo(Graphics graphics, String[] data, Font font, int bottomY) {
        this.graphics = graphics;
        this.data = data;
        this.font = font;
        this.bottomY = bottomY;
    }

    public Graphics getGraphics() {
        return graphics;
    }

    public String[] getData() {
        return data;
    }

    public Font getFont() {
        return font;
    }

    public int getBottomY() {
        return bottomY;
    }
}
