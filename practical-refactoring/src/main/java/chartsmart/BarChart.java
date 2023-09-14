package chartsmart;

import java.awt.*;

class BarChart {

    void renderBarChartBackground(Graphics g, String reportType, Dimensions dimensions) {
        if (reportType.equals("rpfll")) {
            Color bgc = Color.RED;
            g.setColor(bgc);
            g.fillRect(100, 90, dimensions.width - 200, 420);
        } else {
            g.setColor(Color.BLACK);
            g.fillRect(95, 95, 210, 210);
        }
    }
}
