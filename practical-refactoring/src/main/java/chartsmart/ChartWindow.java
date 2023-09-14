package chartsmart;

import javax.swing.*;
import java.awt.*;

public class ChartWindow extends JPanel {

    private String reportType;
    private String title;
    private int chartType;

    public static final int BAR_CHART_TYPE = 406;

    public String getTitle() {
        return title;
    }

    public void showChart(int chartType, String reportType, boolean shouldShowChart) {
        this.chartType = chartType;
        this.reportType = reportType;

        if (shouldShowChart) {
            initializeDrawArea();
        }
    }

    private void initializeDrawArea() {
        this.setPreferredSize(new Dimension(600, 600));

        deriveTitle();
    }

    private void deriveTitle() {
        if (chartType == BAR_CHART_TYPE) {
            title = barChartTitle();
        } else {
            title = pieChartTitle();
        }
    }

    private String pieChartTitle() {
        if (reportType.equals("rpfll")) {
            return "Pie Chart - Single Mode";
        } else {
            return "Pie Chart - Compare Mode";
        }
    }

    private String barChartTitle() {
        if (reportType.equals("rpfll")) {
            return "Bar Chart - Single Mode";
        } else {
            return "Bar Chart - Compare Mode";
        }
    }

    @Override
    public void paint(Graphics g) {
        drawChart(g);
    }

    private void drawChart(Graphics g) {
        Chart chart = chartType == BAR_CHART_TYPE ? new BarChart() : new PieChart();
        chart.renderBackground(g, reportType, new Dimensions(getWidth(), getHeight()));

        Data data;
        if (chartType == BAR_CHART_TYPE) {
            data = chart.initializeData(reportType);
            chart.render(g, data, reportType);
        } else {
            data = chart.initializeData(reportType);
            chart.render(g, data, reportType);
        }

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
                getTitle().contains("daily");
    }
}
