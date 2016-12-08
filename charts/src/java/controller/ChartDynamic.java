package controller;

import controller.dao.ChartDao;
import controller.dto.ChartData;
import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.chart.*;

@ManagedBean(name = "dynamic")
@ViewScoped
public class ChartDynamic implements Serializable {

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
      barModel.setTitle("Grafica de Ventas mensuales");
      barModel.setLegendPosition("ne");
      barModel.setAnimate(true);
      barModel.setDatatipFormat("$%2$d"); // Formato del tooltip de cada barra
      //barModel.setShowPointLabels(true);
      Axis yAxis = barModel.getAxis(AxisType.Y);
      yAxis.setLabel("Monto");  
   }

   /**
    * Metodo para llenar la grafica de datos
    *
    * @return
    */
   BarChartModel initBarModel() {
      BarChartModel model = new BarChartModel();
      ChartDao dao = new ChartDao();
      Map<String, List<ChartData>> mapa = dao.getVentas();
      List<ChartData> lista;
      for (String year : mapa.keySet()) {
         lista = mapa.get(year);
         ChartSeries serie = new ChartSeries();
         serie.setLabel(year);// Nombre de la Serie
         for (ChartData data : lista) {
            serie.set(data.getLabel(), data.getValue());
         }
         model.addSeries(serie);
      }

      return model;
   }

   void createLineModels() {

      lineModel = initCategoryModel();
      lineModel.setTitle("Grafica de Ventas mensuales");
      lineModel.setLegendPosition("e");
      //lineModel.setShowPointLabels(true);
      lineModel.setDatatipFormat("$%2$d"); // Formato del tooltip de cada barra
      Axis yAxis = lineModel.getAxis(AxisType.Y);
      lineModel.getAxes().put(AxisType.X, new CategoryAxis(""));
      yAxis = lineModel.getAxis(AxisType.Y);
      yAxis.setLabel("Monto");      
   }

   LineChartModel initCategoryModel() {
      LineChartModel model = new LineChartModel();

      ChartDao dao = new ChartDao();
      Map<String, List<ChartData>> mapa = dao.getVentas();
      List<ChartData> lista;
      for (String year : mapa.keySet()) {       
         lista = mapa.get(year);
         ChartSeries serie = new ChartSeries();
         serie.setLabel(year);// Nombre de la Serie
         for (ChartData data : lista) {            
            serie.set(data.getLabel(), data.getValue());
         }
         model.addSeries(serie);
      }

      return model;
   }

   public BarChartModel getBarModel() {
      return barModel;
   }

   public LineChartModel getLineModel() {
      return lineModel;
   }
   
}
