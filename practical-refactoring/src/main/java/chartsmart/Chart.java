package chartsmart;

import java.awt.*;

public interface Chart {

    static Chart create(int chartType) {
        return chartType == ChartWindow.BAR_CHART_TYPE ? new BarChart() : new PieChart();
    }

    void renderBackground(Graphics g, String reportType, Dimensions dimensions);

    Data initializeData(String reportType);

    void render(Graphics g, Data data, String reportType);

    String title(String reportType);
}
