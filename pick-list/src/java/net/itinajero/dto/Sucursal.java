package net.itinajero.dto;

public class Sucursal {
   private int id;
   private String nombre;
   private String direccion;

   public Sucursal(int id) {
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

   public String getDireccion() {
      return direccion;
   }

   public void setDireccion(String direccion) {
      this.direccion = direccion;
   }

   @Override
   public String toString() {
      return "Sucursal{" + "id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + '}';
   }
   
    
}
