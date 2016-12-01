package rpt.dto;

public class DetalleResguardo {
   private int id;
   private Activo activo;
   private Resguardo resguardo;

   public DetalleResguardo(int id) {
      this.id = id;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public Activo getActivo() {
      return activo;
   }

   public void setActivo(Activo activo) {
      this.activo = activo;
   }

   public Resguardo getResguardo() {
      return resguardo;
   }

   public void setResguardo(Resguardo resguardo) {
      this.resguardo = resguardo;
   }
      
}
