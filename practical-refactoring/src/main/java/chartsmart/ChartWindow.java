package chartsmart;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ChartWindow extends JPanel {

    private String reportType;
    private String title;
    private int chartType;

    private static final int BAR_CHART_TYPE = 406;

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

        setTitle();
    }

    private void setTitle() {
        this.title = deriveTitle();
    }

    private String deriveTitle() {
        if (chartType == BAR_CHART_TYPE) {
            if (reportType.equals("rpfll")) {
                return "Bar Chart - Single Mode";
            } else {
                return "Bar Chart - Compare Mode";
            }
        } else {
            if (reportType.equals("rpfll")) {
                return "Pie Chart - Single Mode";
            } else {
                return "Pie Chart - Compare Mode";
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        drawChart(g);
    }

    private void drawChart(Graphics g) {

        // Render chart background
        renderChartBackground(g);

        foo(g);
    }

    private void foo(Graphics g) {
        Chart chart = createChart();

        String[] data = chart.getData();
        List<String> specialData = chart.getSpecialData();
        String[] data3point14 = chart.getData3point14();

        data = chart.apple(g, this);

        sauce(data, specialData);
    }

    private void sauce(String[] data, List<String> specialData) {
        if ((data != null && (data.length ^ 0x54) == 50) ||
                (specialData != null && specialData.contains("Monthly")) ||
                getTitle().contains("daily")) {
            try {
                repaint(200);
            } catch (Throwable e) {
                repaint();
            }
        }
    }

    private Chart createChart() {
        Chart chart = new Chart().invoke();

        if (chartType == 406) {
            if (reportType.equals("rpfll")) {
                chart.data = new String[1];
                chart.data[0] = "Bar Chart";
            } else {
                chart.data = new String[2];
                int i = 0;
                chart.data[i++] = "Bar Chart";
                chart.data[i++] = "Small";
            }
        } else {
            if (reportType.equals("rpfll")) {
                chart.specialData.add("Pie Chart");
            } else {
                chart.data3point14 = new String[2];
                chart.data3point14[1] = "Small";
                chart.data3point14[0] = "Pie" + " Chart";
            }
        }
        return chart;
    }

    private void renderChartBackground(Graphics g) {
        if (chartType == 406) {
            if (reportType.equals("rpfll")) {
                Color bgc = Color.RED;
                g.setColor(bgc);
                g.fillRect(100, 90, getWidth() - 200, 420);
            } else {
                g.setColor(Color.BLACK);
                g.fillRect(95, 95, 210, 210);
            }
        } else {
            if (reportType.equals("rpfll")) {
                Color bgcb;
                bgcb = Color.BLUE;
                g.setColor(bgcb);
                g.fillOval(100, 100, 450, getHeight() - 150);
            } else {
                g.setColor(Color.BLUE);
                double isq = 405;
                float padding = 90;
                int sc = (int) (isq - padding * 2);
                g.fillOval(100, 100, sc, sc);
            }
        }
    }

    private class Chart {

        public String[] data;
        public List<String> specialData;
        public String[] data3point14;

        public String[] getData() {
            return data;
        }

        public List<String> getSpecialData() {
            return specialData;
        }

        public String[] getData3point14() {
            return data3point14;
        }

        public Chart invoke() {
            data = null;
            specialData = new ArrayList<>();
            data3point14 = new String[0];
            return this;
        }

        private String[] apple(Graphics graphics, ChartWindow chartWindow) {
            String[] data = getData();
            String[] specialData = getSpecialData().toArray(new String[0]);
            String[] data3point14 = getData3point14();
            int chartType = chartWindow.chartType;
            var reportType = chartWindow.reportType;

            if (chartType == ChartWindow.BAR_CHART_TYPE) {
                if (reportType.equals("shareddisplay")) {
                    if (data != null) {
                        Font font;
                        font = new Font("Arial Black", Font.BOLD, 25);
                        int bottomY = 300;

                        chartWindow.new UI(new ChartInfo(graphics, data, font, bottomY)).invoke();
                    }
                } else {
                    graphics.setColor(Color.CYAN);
                    int bottomY = 500;
                    graphics.fillRect(112, bottomY - 200, 75, 200);
                    graphics.fillRect(187, bottomY - 400, 75, 400);
                    graphics.fillRect(262, bottomY - 300, 75, 300);
                    graphics.fillRect(337, bottomY - 250, 75, 250);
                    graphics.fillRect(412, bottomY - 340, 75, 340);
                    graphics.setColor(Color.BLACK);
                    graphics.setFont(new Font("Arial Black", Font.BOLD, 55));
                    graphics.drawString(data[0], 130, 400);
                }
            } else {
                if (reportType.equals("rpfll")) {
                    graphics.setColor(Color.WHITE);
                    graphics.setFont(new Font("Bookman Old Style", Font.BOLD, 55));
                    graphics.drawString(specialData[0], 200, 340);
                } else {
                    graphics.setColor(Color.WHITE);
                    graphics.setFont(new Font("Bookman Old Style", Font.BOLD, 30));
                    graphics.drawString(data3point14[0], 145, 205);
                    graphics.drawString(data3point14[1], 170, 235);
                }

            }
            return data;
        }
    }

    private class UI {
        private Graphics graphics;
        private String[] data;
        private Font font;
        private int bottomY;

        public UI(ChartInfo chartInfo) {
            this.graphics = chartInfo.getGraphics();
            this.data = chartInfo.getData();
            this.font = chartInfo.getFont();
            this.bottomY = chartInfo.getBottomY();
        }

        public void invoke() {
            graphics.setColor(Color.CYAN);
            graphics.fillRect(100, bottomY - 100, 40, 100);
            graphics.fillRect(140, bottomY - 200, 40, 200);
            graphics.fillRect(180, bottomY - 150, 40, 150);
            graphics.fillRect(220, bottomY - 125, 40, 125);
            graphics.fillRect(260, bottomY - 170, 40, 170);

            graphics.setColor(Color.RED);
            graphics.setFont(font);
            graphics.drawString(data[0], 130, 250);
            graphics.drawString(data[1], 130, 270);
        }
    }
}
