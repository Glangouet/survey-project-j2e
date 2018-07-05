package org.primefaces.examples.view;
 
import javax.annotation.PostConstruct;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
 
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.ChartSeries;
 
@ManagedBean
public class ChartView implements Serializable {
 
    public HorizontalBarChartModel horizontalBarModel;
    
 
    @PostConstruct
    public void init() {
        
        createBarModels();
    }
     
    public HorizontalBarChartModel getHorizontalBarModel() {
        return horizontalBarModel;
    }
    
     
    public void createBarModels() {
        createHorizontalBarModel();
    }
     
     
    public void createHorizontalBarModel() {
        horizontalBarModel = new HorizontalBarChartModel();


        
        ChartSeries boys = new ChartSeries();
        boys.setLabel("Boys");
        boys.set("Answer 1", 45);
        boys.set("Answer 2", 30);
        boys.set("Answer 3", 25);

        horizontalBarModel.addSeries(boys);

        horizontalBarModel.setTitle("Survey answers");
        horizontalBarModel.setLegendPosition("e");
        horizontalBarModel.setStacked(true);
         
        Axis xAxis = horizontalBarModel.getAxis(AxisType.X);
        xAxis.setMin(0);
        xAxis.setMax(100);
         
        Axis yAxis = horizontalBarModel.getAxis(AxisType.Y);   
        horizontalBarModel.setSeriesColors("5DAD3E,01A2BE,983A84,EF7F33,FEE318,DF2F43");
        horizontalBarModel.setExtender("chartExtender");
    }
 
}