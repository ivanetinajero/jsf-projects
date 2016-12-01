package rpt.dto;

public class Activo {
   private int id;
   private Dependencia dependencia;
   private EstadoFisico eFisico;
   private String tipoActivo;
   private String propio;

   public Activo(int id) {
      this.id = id;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public Dependencia getDependencia() {
      return dependencia;
   }

   public void setDependencia(Dependencia dependencia) {
      this.dependencia = dependencia;
   }

   public EstadoFisico geteFisico() {
      return eFisico;
   }

   public void seteFisico(EstadoFisico eFisico) {
      this.eFisico = eFisico;
   }

   public String getTipoActivo() {
      if (tipoActivo.equals("1"))
         return "Mueble";
      else
      return "Inmueble";
   }

   public void setTipoActivo(String tipoActivo) {
      this.tipoActivo = tipoActivo;
   }

   public String getPropio() {
      return propio;
   }

   public void setPropio(String propio) {
      this.propio = propio;
   }
   
   
}
