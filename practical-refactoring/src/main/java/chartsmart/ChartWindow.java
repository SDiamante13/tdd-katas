package chartsmart;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

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
            if (reportType.equals("rpfll")) {
                title = "Bar Chart - Single Mode";
            } else {
                title = "Bar Chart - Compare Mode";
            }
        } else {
            if (reportType.equals("rpfll")) {
                title = "Pie Chart - Single Mode";
            } else {
                title = "Pie Chart - Compare Mode";
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        drawChart(g);
    }

    private void drawChart(Graphics g) {
        renderChartBackground(g);

        Data data = new Data();

        if (chartType == BAR_CHART_TYPE) {
            if (reportType.equals("rpfll")) {
                data.data = new String[1];
                data.data[0] = "Bar Chart";
            } else {
                data.data = new String[2];
                int i = 0;
                data.data[i++] = "Bar Chart";
                data.data[i++] = "Small";
            }
        } else {
            if (reportType.equals("rpfll")) {
                data.specialData.add("Pie Chart");
            } else {
                data.data3point14 = new String[2];
                data.data3point14[1] = "Small";
                data.data3point14[0] = "Pie" + " Chart";
            }
        }

        Font font;

        if (chartType == BAR_CHART_TYPE) {
            if (reportType.equals("shareddisplay")) {
                if (data.data != null) {
                    if (data.data == null) {
                        data.data = new String[5];
                        data.data[0] = "Sally";
                        data.data[1] = System.getProperty("osname");
                        data.data[2] = new Date().toString();
                    }
                    font = new Font("Arial Black", Font.BOLD, 25);
                    g.setColor(Color.CYAN);
                    int bottomY = 300;
                    g.fillRect(100, bottomY - 100, 40, 100);
                    g.fillRect(140, bottomY - 200, 40, 200);
                    g.fillRect(180, bottomY - 150, 40, 150);
                    g.fillRect(220, bottomY - 125, 40, 125);
                    g.fillRect(260, bottomY - 170, 40, 170);

                    g.setColor(Color.RED);
                    g.setFont(font);
                    g.drawString(data.data[0], 130, 250);
                    g.drawString(data.data[1], 130, 270);
                }
            } else {
                int bottomY = 500;
                g.setColor(Color.CYAN);
                g.fillRect(112, bottomY - 200, 75, 200);
                g.fillRect(187, bottomY - 400, 75, 400);
                g.fillRect(262, bottomY - 300, 75, 300);
                g.fillRect(337, bottomY - 250, 75, 250);
                g.fillRect(412, bottomY - 340, 75, 340);
                font = new Font("Arial Black",
                        Font.BOLD, 55);
                g.setColor(Color.BLACK);
                g.setFont(font);
                g.drawString(
                        data.data[0], 130,
                        400);
            }
        } else {
            if (reportType.equals("rpfll")) {
                font = new Font("Bookman Old Style", Font.BOLD, 55);
                g.setColor(Color.WHITE);
                g.setFont(font);
                g.drawString(data.specialData.get(0), 200, 340);
            } else {
                font = new Font("Bookman Old Style", Font.BOLD, 30);
                g.setFont(font);
                g.setColor(Color.WHITE);

                g.drawString(data.data3point14[0], 145, 205);
                g.drawString(data.data3point14[1], 170, 235);
            }


        }

        if ((data.data != null && (data.data.length ^ 0x54) == 50) ||
                (data.specialData != null && data.specialData.contains("Monthly")) ||
                getTitle().contains("daily")) {
            try {
                repaint(200);
            } catch (Throwable e) {
                repaint();
            }
        }
    }

    private void renderChartBackground(Graphics g) {
        if (chartType == BAR_CHART_TYPE) {
            renderBarChartBackground(g);
        } else {
            renderPieChartBackground(g);
        }
    }

    private void renderPieChartBackground(Graphics g) {
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

    private void renderBarChartBackground(Graphics g) {
        if (reportType.equals("rpfll")) {
            Color bgc = Color.RED;
            g.setColor(bgc);
            g.fillRect(100, 90, getWidth() - 200, 420);
        } else {
            g.setColor(Color.BLACK);
            g.fillRect(95, 95, 210, 210);
        }
    }
}
