package chartsmart;

import javax.swing.*;
import java.awt.*;

public class ChartWindow extends JPanel {

    private String reportType;
    private Chart chart;

    public static final int BAR_CHART_TYPE = 406;

    public String getTitle() {
        return chart.title(reportType);
    }

    public void showChart(int chartType, String reportType, boolean shouldShowChart) {
        this.reportType = reportType;
        this.chart = Chart.create(chartType);

        if (shouldShowChart) {
            initializeDrawArea();
        }
    }

    private void initializeDrawArea() {
        this.setPreferredSize(new Dimension(600, 600));
    }

    @Override
    public void paint(Graphics g) {
        drawChart(g);
    }

    private void drawChart(Graphics g) {
        chart.renderBackground(g, reportType, new Dimensions(getWidth(), getHeight()));
        Data data = chart.initializeData(reportType);
        chart.render(g, data, reportType);

        if (shouldRepaint(data)) {
            try {
                repaint(200);
            } catch (Throwable e) {
                repaint();
            }
        }
    }

    private boolean shouldRepaint(Data data) {
        return (data.data != null && (data.data.length ^ 0x54) == 50) ||
                (data.specialData != null && data.specialData.contains("Monthly")) ||
                chart.title(reportType).contains("daily");
    }
}
