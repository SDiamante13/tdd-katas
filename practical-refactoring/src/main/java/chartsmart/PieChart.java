package chartsmart;

import java.awt.*;

class PieChart {

    void renderPieChartBackground(Graphics g, String reportType, Dimensions dimensions) {
        if (reportType.equals("rpfll")) {
            Color bgcb;
            bgcb = Color.BLUE;
            g.setColor(bgcb);
            g.fillOval(100, 100, 450, dimensions.height - 150);
        } else {
            g.setColor(Color.BLUE);
            double isq = 405;
            float padding = 90;
            int sc = (int) (isq - padding * 2);
            g.fillOval(100, 100, sc, sc);
        }
    }
}
