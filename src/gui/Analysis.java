package gui;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

import javax.swing.*;

public class Analysis extends JDialog {
    private JPanel contentPane;
    private JPanel content;

    public Analysis() {
        setContentPane(contentPane);
        setModal(true);

        // This will create the dataset
        PieDataset dataset = createDataset();
        // based on the dataset we create the chart
        JFreeChart chart = createChart(dataset, null);
        // we put the chart into a panel
        ChartPanel chartPanel = new ChartPanel(chart);
        // default size
//        chartPanel.setPreferredSize(new java.awt.Dimension(300, 300));

        // add it to our application


        new DefaultWindow().permitAddView(content);
        content.add(chartPanel);
        content.revalidate();
    }



    private PieDataset createDataset() {
        DefaultPieDataset result = new DefaultPieDataset();
        result.setValue("Linux", 1022);
        result.setValue("Mac", 900);
        result.setValue("Windows1", 767);
        result.setValue("Windows2", 767);
        result.setValue("Windows3", 767);
        return result;
    }

    private JFreeChart createChart(PieDataset dataset, String title) {

        JFreeChart chart = ChartFactory.createPieChart3D(title,          // chart title
                dataset,                // data
                true,                   // include legend
                true,
                false);

        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setStartAngle(290);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.5f);
        return chart;

    }


    public static void main(String[] args) {
        Analysis dialog = new Analysis();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
