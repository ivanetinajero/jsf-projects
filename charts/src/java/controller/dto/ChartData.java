package controller.dto;

public class ChartData {
   private int id;
   private String serie;
   private String label;
   private double value;

   public ChartData(int id) {
      this.id = id;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getSerie() {
      return serie;
   }

   public void setSerie(String serie) {
      this.serie = serie;
   }

   public String getLabel() {
      return label;
   }

   public void setLabel(String label) {
      this.label = label;
   }

   public double getValue() {
      return value;
   }

   public void setValue(double value) {
      this.value = value;
   }
  
   @Override
   public String toString() {
      return "ChartData{" + "id=" + id + ", serie=" + serie + ", label=" + label + ", value=" + value + '}';
   }

}
