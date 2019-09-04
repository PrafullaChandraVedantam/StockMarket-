package com.example.SpringBoot.Controller;

import java.awt.Color;  
import javax.swing.JFrame;  
import javax.swing.SwingUtilities;  
import javax.swing.WindowConstants;  
import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;  
import org.jfree.chart.plot.XYPlot;  
import org.jfree.data.time.Day;  
import org.jfree.data.time.TimeSeries;  
import org.jfree.data.time.TimeSeriesCollection;  
import org.jfree.data.xy.XYDataset;  
  
public class ChartController extends JFrame {  
  
  private static final long serialVersionUID = 1L;  
  
  public ChartController(String title) {  
    super(title);  
    // Create dataset  
    XYDataset dataset = createDataset();  
    // Create chart  
    JFreeChart chart = ChartFactory.createTimeSeriesChart(  
        "StockPrice Comparison", // Chart  
        "Month-Year", // X-Axis Label  
        "Price", // Y-Axis Label  
        dataset, rootPaneCheckingEnabled, rootPaneCheckingEnabled, rootPaneCheckingEnabled);  
  
    //Changes background color  
    XYPlot plot = (XYPlot)chart.getPlot();  
    plot.setBackgroundPaint(new Color(244, 245, 237));  
      
    ChartPanel panel = new ChartPanel(chart);  
    setContentPane(panel);  
  }  
  
  private XYDataset createDataset() {  
    TimeSeriesCollection dataset = new TimeSeriesCollection();  
  
    TimeSeries series1 = new TimeSeries("Stock Price Comparison");  
    series1.add(new Day(1, 1, 2019), 1900);  
    series1.add(new Day(2, 2, 2019), 9876);  
    series1.add(new Day(17, 3, 2019), 10500);  
    series1.add(new Day(12, 4, 2019), 18000);  
    series1.add(new Day(24, 5, 2019), 20000);  
    series1.add(new Day(12, 6, 2019), 30000);  
    series1.add(new Day(19, 7, 2019), 50000);  
    series1.add(new Day(21, 8, 2019), 65000);  
    series1.add(new Day(27, 9, 2019), 75000);  
    series1.add(new Day(22, 10, 2019), 90000);   
    dataset.addSeries(series1);  
  
   
      
  
    return dataset;  
  }  
  
  public static void main(String[] args) {  
    SwingUtilities.invokeLater(() -> {  
     ChartController example = new ChartController("Stock Chart");  
      example.setSize(800, 400);  
      example.setLocationRelativeTo(null);  
      example.setVisible(true);  
      example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
    });  
  }  
}  
