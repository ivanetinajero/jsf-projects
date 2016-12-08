package controller;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;

@ManagedBean
@ViewScoped
public class ChartView implements Serializable {

   private BarChartModel barModel;
   private LineChartModel lineModel;
   private int size = 50;

   @PostConstruct
   public void init() {
      // La primera vez que se carga la Vista, creamos la gráficas
      createCharts();
   }

   /**
    * Este metodo se ejecuta cada X Segundos para hacer las consultas a la BD y
    * crear nuevamente las graficas.
    * <p:poll interval="3" listener="#{chartView.refresh}" update="votes"/>
    */
   public void refresh() {
      System.out.println("Refreshing charts");
      size += 10; // Simular algun cambio 

      createCharts();
      FacesContext context = FacesContext.getCurrentInstance();
      context.addMessage(null, new FacesMessage("Successful", "Graficas Actualizadas"));
   }

   /**
    * Este metodo crear instancias nuevas de las graficas con nuevos datos.
    */
   public void createCharts() {
      createBarModel();
      createLineModels();
   }

   void createBarModel() {
      barModel = initBarModel(); // Llenamos de datos la grafica

      // Despues que tiene datos, hacemos la configuracion general
      barModel.setTitle("Bar Chart");
      barModel.setLegendPosition("ne");
      barModel.setAnimate(true);
      barModel.setDatatipFormat("$%2$d");
      Axis xAxis = barModel.getAxis(AxisType.X);
      xAxis.setLabel("Gender");

      Axis yAxis = barModel.getAxis(AxisType.Y);
      yAxis.setLabel("Births");
      yAxis.setMin(0);
      yAxis.setMax(200);
   }

   /**
    * Metodo para llenar la grafica de datos
    *
    * @return
    */
   BarChartModel initBarModel() {
      BarChartModel model = new BarChartModel();

      ChartSeries boys = new ChartSeries();
      boys.setLabel("Boys");
      boys.set("Enero", 120);
      boys.set("Febrero", 100);
      boys.set("Marzo", 44);
      boys.set("Abril", 150);
      boys.set("Mayo", size);

      ChartSeries girls = new ChartSeries();
      girls.setLabel("Girls");
      girls.set("Enero", 52);
      girls.set("Febrero", 60);
      girls.set("Marzo", 110);
      girls.set("Abril", 135);
      girls.set("Mayo", 120);

      model.addSeries(boys);
      model.addSeries(girls);

      return model;
   }

   void createLineModels() {

      lineModel = initCategoryModel();
      lineModel.setTitle("Category Chart");
      lineModel.setLegendPosition("e");
      lineModel.setShowPointLabels(true);
      Axis yAxis = lineModel.getAxis(AxisType.Y);
      lineModel.getAxes().put(AxisType.X, new CategoryAxis("Years"));
      yAxis = lineModel.getAxis(AxisType.Y);
      yAxis.setLabel("Births");
      yAxis.setMin(0);
      yAxis.setMax(200);
   }

   LineChartModel initCategoryModel() {
      LineChartModel model = new LineChartModel();

      ChartSeries boys = new ChartSeries();
      boys.setLabel("Boys");
      boys.set("2004", 120);
      boys.set("2005", 100);
      boys.set("2006", 44);
      boys.set("2007", 150);
      boys.set("2008", 25);

      ChartSeries girls = new ChartSeries();
      girls.setLabel("Girls");
      girls.set("2004", 52);
      girls.set("2005", 60);
      girls.set("2006", 110);
      girls.set("2007", 90);
      girls.set("2008", 120);

      model.addSeries(boys);
      model.addSeries(girls);

      return model;
   }

   public LineChartModel getLineModel() {
      return lineModel;
   }

   public BarChartModel getBarModel() {
      return barModel;
   }

}
