package chartsmart;

import java.awt.*;

class PieChart implements Chart {

    @Override
    public String title(String reportType) {
        if (reportType.equals("rpfll")) {
            return "Pie Chart - Single Mode";
        } else {
            return "Pie Chart - Compare Mode";
        }
    }

    @Override
    public Data initializeData(String reportType) {
        Data data = new Data();
        if (reportType.equals("rpfll")) {
            data.specialData.add("Pie Chart");
        } else {
            data.data3point14 = new String[2];
            data.data3point14[1] = "Small";
            data.data3point14[0] = "Pie" + " Chart";
        }
        return data;
    }

     public void render(Graphics g, Data data, String reportType) {
        Font font;
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

    @Override
    public void renderBackground(Graphics g, String reportType, Dimensions dimensions) {
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
