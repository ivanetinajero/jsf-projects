package controller.dao;

import controller.dto.ChartData;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ChartDao {

   public ChartDao() {
      System.out.println("DAO CHART");
   }
   
   public Map<String,List<ChartData>> getVentas(){
      Map <String,List<ChartData>> map = new HashMap();
      List<ChartData> lista = new LinkedList<>();
      ChartData data= new ChartData(1);      
      data.setLabel("Enero");
      data.setValue(1500);
      lista.add(data);      
      data= new ChartData(2);      
      data.setLabel("Febrero");
      data.setValue(1800);
      lista.add(data);      
      data= new ChartData(3);     
      data.setLabel("Marzo");
      data.setValue(1600);
      lista.add(data);      
      data= new ChartData(4);     
      data.setLabel("Abril");
      data.setValue(1400);
      lista.add(data);      
      data= new ChartData(5);      
      data.setLabel("Mayo");
      data.setValue(2100);
      lista.add(data);
      map.put("2015", lista); // Serie de 2015
      
      lista = new LinkedList<>();
      data= new ChartData(1);      
      data.setLabel("Enero");
      data.setValue(1600);
      lista.add(data);      
      data= new ChartData(2);      
      data.setLabel("Febrero");
      data.setValue(1700);
      lista.add(data);      
      data= new ChartData(3);     
      data.setLabel("Marzo");
      data.setValue(2400);
      lista.add(data);      
      data= new ChartData(4);     
      data.setLabel("Abril");
      data.setValue(1050);
      lista.add(data);      
      data= new ChartData(5);      
      data.setLabel("Mayo");
      data.setValue(800);
      lista.add(data);
      map.put("2016", lista); // Serie de 2016
      
      return map;
   }
}
