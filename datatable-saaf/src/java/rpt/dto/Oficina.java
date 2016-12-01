package rpt.dto;

public class Oficina {
   private int id;
   private int idDependencia; // inyeccion
   private int idInmueble; // inyeccion
   private String nombre;
   private String noInterior;
   private String piso;
   private String referencia;
   private int idBlame;

   public Oficina(int id) {
      this.id = id;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public int getIdDependencia() {
      return idDependencia;
   }

   public void setIdDependencia(int idDependencia) {
      this.idDependencia = idDependencia;
   }

   public int getIdInmueble() {
      return idInmueble;
   }

   public void setIdInmueble(int idInmueble) {
      this.idInmueble = idInmueble;
   }

   public String getNombre() {
      return nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public String getNoInterior() {
      return noInterior;
   }

   public void setNoInterior(String noInterior) {
      this.noInterior = noInterior;
   }

   public String getPiso() {
      return piso;
   }

   public void setPiso(String piso) {
      this.piso = piso;
   }

   public String getReferencia() {
      return referencia;
   }

   public void setReferencia(String referencia) {
      this.referencia = referencia;
   }

   public int getIdBlame() {
      return idBlame;
   }

   public void setIdBlame(int idBlame) {
      this.idBlame = idBlame;
   }
   
   
}
