package rpt.dto;

public class Clasificacion {
   private int id;
   private String nombre;
   //private Partida partida // inyeccion

   public Clasificacion(int id) {
      this.id = id;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getNombre() {
      return nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }
   
}
