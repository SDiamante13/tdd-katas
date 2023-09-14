package chartsmart;

import java.awt.*;

public interface Chart {

    int BAR_CHART_TYPE = 406;
    String SINGLE_MODE = "rpfll";

    static Chart create(int chartType) {
        return chartType == BAR_CHART_TYPE ? new BarChart() : new PieChart();
    }

    void renderBackground(Graphics g, String reportType, Dimensions dimensions);

    Data initializeData(String reportType);

    void render(Graphics g, Data data, String reportType);

    String title(String reportType);
}
