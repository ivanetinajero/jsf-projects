package rpt.dto;

public class Dependencia {
   private int id;
   private String nombre;
   private int depSup;
   private String nombreCorto;
   private String tipo;
   private String dependencia;
   private String direccion;

   public Dependencia(int id) {
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

   public int getDepSup() {
      return depSup;
   }

   public void setDepSup(int depSup) {
      this.depSup = depSup;
   }

   public String getNombreCorto() {
      return nombreCorto;
   }

   public void setNombreCorto(String nombreCorto) {
      this.nombreCorto = nombreCorto;
   }

   public String getTipo() {
      return tipo;
   }

   public void setTipo(String tipo) {
      this.tipo = tipo;
   }

   public String getDependencia() {
      return dependencia;
   }

   public void setDependencia(String dependencia) {
      this.dependencia = dependencia;
   }

   public String getDireccion() {
      return direccion;
   }

   public void setDireccion(String direccion) {
      this.direccion = direccion;
   }
  
   
   
}
