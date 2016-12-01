package rpt.dto;

public class Resguardo {
   
   private int id; 
   private String tipo;
   private String resguardante;

   public Resguardo(int id) {
      this.id = id;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getTipo() {
      return tipo;
   }

   public void setTipo(String tipo) {
      this.tipo = tipo;
   }

   public String getResguardante() {
      return resguardante;
   }

   public void setResguardante(String resguardante) {
      this.resguardante = resguardante;
   }

   @Override
   public String toString() {
      return "Resguardo{" + "id=" + id + ", tipo=" + tipo + ", resguardante=" + resguardante + '}';
   }
   
}
