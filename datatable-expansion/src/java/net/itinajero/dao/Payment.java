package net.itinajero.dao;

public class Payment {

   private int id;
   private int idCar;
   private String concept;
   private double total;
   private String date;

   public Payment(int id) {
      this.id = id;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public int getIdCar() {
      return idCar;
   }

   public void setIdCar(int idCar) {
      this.idCar = idCar;
   }

   public String getConcept() {
      return concept;
   }

   public void setConcept(String concept) {
      this.concept = concept;
   }

   public double getTotal() {
      return total;
   }

   public void setTotal(double total) {
      this.total = total;
   }

   public String getDate() {
      return date;
   }

   public void setDate(String date) {
      this.date = date;
   }

   @Override
   public String toString() {
      return "Payment{" + "id=" + id + ", idCar=" + idCar + ", concept=" + concept + ", total=" + total + ", date=" + date + '}';
   }

   
}
