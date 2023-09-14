package chartsmart;

import java.awt.*;

public interface Chart {

    void renderBackground(Graphics g, String reportType, Dimensions dimensions);

    Data initializeData(String reportType);

    void render(Graphics g, Data data, String reportType);
}
