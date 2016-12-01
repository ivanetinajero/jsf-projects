package rpt.jsf;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import saaf.DbConnection;
import rpt.dto.Mueble;
import rpt.dao.MuebleDao;
import org.primefaces.event.ToggleEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.Visibility;
import util.Condicion;

@ManagedBean(name = "muebles")
@ViewScoped
public class ListaMuebles implements Serializable {

   private DbConnection conn;

   // Inicio filtros  
   private String descripcion;
   private String factura;
   private String etiqueta;
   // Fin filtros

   private LazyDataModel<Mueble> listaMuebles;
   private MuebleDao muebleDao;

   // toggle column server-side <http://blog.primefaces.org/?p=3341>
   private List<Boolean> list;

   // Mapa para guardar las sumatorias y el count() de la consulta
   private Map<String, Double> totales;

   @PostConstruct
   public void init() {
      // initial state of columns (visible)
      list = Arrays.asList(
              true,
              true,
              true,
              true
      );

      // Traer el catalogo de lineas
      //catalogoLineas = new LinkedList<>();
      try {
         conn = new DbConnection();
         muebleDao = new MuebleDao(conn);
         //LineasDao daoLinea = new LineasDao(sqlServer);
         //ProveedorDao daoProveedor = new ProveedorDao(sqlServer);
         //catalogoLineas = daoLinea.getAll();
         //catalogoProveedor = daoProveedor.getAll();
      } catch (Exception ex) {
         System.out.println("Error al traer el catalogo de lineas");
      }
      //this.fecha1 = new Date();
      //this.fecha2 = new Date();
   }

   public void search() {
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
      Map<String, Condicion> filter = new HashMap<>(); // En este map almacenaremos los filtros
      // Las fechas son obligatorias. 
      //filter.put("fecha1", new Condicion("partcomp.UsuFecha","between", simpleDateFormat.format(fecha1),true));
      //filter.put("fecha2", new Condicion("partcomp.UsuFecha","between", simpleDateFormat.format(fecha2),true));
      /*
      if (linea.length()>0)
         filter.put("linea", new Condicion("lineas.Linea" ,"=" , linea, false));     
      if (descripcion.length()>0)
         filter.put("descripcion", new Condicion("prods.descrip","like" ,descripcion, false));  
      if (factura.length()>0)
         filter.put("factura", new Condicion("compras.FACTURA" ,"=" , factura, false));     
      if (referencia.length()>0)
         filter.put("referencia", new Condicion("partcomp.NO_REFEREN","=" ,referencia, false));  
      if (proveedor.length()>0)
         filter.put("proveedor", new Condicion("proveed.proveedor","=" ,proveedor, false));  
       */
      System.out.println("FILTERS: " + filter);
      try {

         // nos traemos los totales         
         totales = muebleDao.getCount(filter);
         // nos traemos el listado                         
         listaMuebles = new LazyMuebles(filter, muebleDao, totales.get("total").intValue());
      } catch (Exception ex) {
         System.out.println("Error de conexion a la sucursal: " + ex.getMessage());
      }
   }

   public LazyDataModel<Mueble> getListaMuebles() {
      return listaMuebles;
   }

   public List<Boolean> getList() {
      return list;
   }

   public void onToggle(ToggleEvent e) {
      list.set((Integer) e.getData(), e.getVisibility() == Visibility.VISIBLE);
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

   public String getEtiqueta() {
      return etiqueta;
   }

   public void setEtiqueta(String etiqueta) {
      this.etiqueta = etiqueta;
   }
   
   
}
