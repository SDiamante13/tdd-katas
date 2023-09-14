package chartsmart;

import java.awt.*;

class BarChart implements Chart {

    public static final int BAR_CHART_TYPE = 406;

    public String title(String reportType) {
        if (reportType.equals("rpfll")) {
            return "Bar Chart - Single Mode";
        } else {
            return "Bar Chart - Compare Mode";
        }
    }

    public Data initializeData(String reportType) {
        Data data = new Data();
        if (reportType.equals("rpfll")) {
            data.data = new String[1];
            data.data[0] = "Bar Chart";
        } else {
            data.data = new String[2];
            int i = 0;
            data.data[i++] = "Bar Chart";
            data.data[i++] = "Small";
        }
        return data;
    }

    public void render(Graphics g, Data data, String reportType) {
        Font font;
        if (reportType.equals("shareddisplay")) {
            if (data.data != null) {
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
    }

    @Override
    public void renderBackground(Graphics g, String reportType, Dimensions dimensions) {
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
