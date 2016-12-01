package rpt.dto;

public class Mueble {
   
   private int id;
   private String descripcion;
   private String factura;
   private String serie;
   private String fechaRegistro;
   private String fechaCompra;
   private String fechaEntrega;
   private String rfc;
   private double costo;
   private int vidaUtil;
   private int garantia;
   private EstadoFisico estadoFisico; // inyeccion
   private Clasificacion clasificacion; // inyeccion
   private Estatus estatus; // inyeccion
   private String propio;
   private Oficina oficina; // inyeccion
   private String observaciones;
   private int tipoMueble;   
   private String etiqueta;
   private Activo activo; // inyeccion
   private String tipoEntrada;
   private String cuentaFinanzas;
   private double iva;
   private int idFactura; // inyeccion
   private DetalleResguardo detResg;

   public Mueble(int id) {
      this.id = id;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getDescripcion() {
      return descripcion;
   }

   public void setDescripcion(String descripcion) {
      this.descripcion = descripcion;
   }

   public String getFactura() {
      return factura;
   }

   public void setFactura(String factura) {
      this.factura = factura;
   }

   public String getSerie() {
      return serie;
   }

   public void setSerie(String serie) {
      this.serie = serie;
   }

   public String getFechaRegistro() {
      return fechaRegistro;
   }

   public void setFechaRegistro(String fechaRegistro) {
      this.fechaRegistro = fechaRegistro;
   }

   public String getFechaCompra() {
      return fechaCompra;
   }

   public void setFechaCompra(String fechaCompra) {
      this.fechaCompra = fechaCompra;
   }

   public String getFechaEntrega() {
      return fechaEntrega;
   }

   public void setFechaEntrega(String fechaEntrega) {
      this.fechaEntrega = fechaEntrega;
   }

   public String getRfc() {
      return rfc;
   }

   public void setRfc(String rfc) {
      this.rfc = rfc;
   }

   public double getCosto() {
      return costo;
   }

   public void setCosto(double costo) {
      this.costo = costo;
   }

   public int getVidaUtil() {
      return vidaUtil;
   }

   public void setVidaUtil(int vidaUtil) {
      this.vidaUtil = vidaUtil;
   }

   public int getGarantia() {
      return garantia;
   }

   public void setGarantia(int garantia) {
      this.garantia = garantia;
   }

   public EstadoFisico getEstadoFisico() {
      return estadoFisico;
   }

   public void setEstadoFisico(EstadoFisico estadoFisico) {
      this.estadoFisico = estadoFisico;
   }

   public Clasificacion getClasificacion() {
      return clasificacion;
   }

   public void setClasificacion(Clasificacion clasificacion) {
      this.clasificacion = clasificacion;
   }

   public String getPropio() {
      return propio;
   }

   public void setPropio(String propio) {
      this.propio = propio;
   }

   public Oficina getOficina() {
      return oficina;
   }

   public void setOficina(Oficina oficina) {
      this.oficina = oficina;
   }
   
   public String getObservaciones() {
      return observaciones;
   }

   public void setObservaciones(String observaciones) {
      this.observaciones = observaciones;
   }

   public int getTipoMueble() {
      return tipoMueble;
   }

   public void setTipoMueble(int tipoMueble) {
      this.tipoMueble = tipoMueble;
   }

   public String getEtiqueta() {
      return etiqueta;
   }

   public void setEtiqueta(String etiqueta) {
      this.etiqueta = etiqueta;
   }

   public Activo getActivo() {
      return activo;
   }

   public void setActivo(Activo activo) {
      this.activo = activo;
   }

   public String getTipoEntrada() {
      return tipoEntrada;
   }

   public void setTipoEntrada(String tipoEntrada) {
      this.tipoEntrada = tipoEntrada;
   }

   public String getCuentaFinanzas() {
      return cuentaFinanzas;
   }

   public void setCuentaFinanzas(String cuentaFinanzas) {
      this.cuentaFinanzas = cuentaFinanzas;
   }

   public double getIva() {
      return iva;
   }

   public void setIva(double iva) {
      this.iva = iva;
   }

   public int getIdFactura() {
      return idFactura;
   }

   public void setIdFactura(int idFactura) {
      this.idFactura = idFactura;
   }

   public Estatus getEstatus() {
      return estatus;
   }

   public void setEstatus(Estatus estatus) {
      this.estatus = estatus;
   }

   public DetalleResguardo getDetResg() {
      return detResg;
   }

   public void setDetResg(DetalleResguardo detResg) {
      this.detResg = detResg;
   }
   
}
