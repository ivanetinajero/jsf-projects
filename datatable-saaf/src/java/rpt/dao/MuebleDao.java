package rpt.dao;

import saaf.DbConnection;
import rpt.dto.Mueble;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import util.Condicion;
import util.Consulta;

public class MuebleDao {

   private DbConnection cn;

   public MuebleDao(DbConnection cn) {
      this.cn = cn;
   }

   public Map<String, Double> getCount(Map<String, Condicion> filters) throws SQLException {

      // Formamos los ANDs del where, dependiendo de los filtros que selecciono el usuario
      String ANDs = Consulta.getCondition(filters, false);
      //System.out.println("ANDs: " + ANDs);       
      String sql = "select count(1) as COUNT from muebles "                            
              + "WHERE TIPO_MUEBLE=1 " + ANDs;

      PreparedStatement pst = cn.getConnection().prepareStatement(sql);

      // Search by date (mandatory)
      //pst.setString(1, filters.get("fecha1").getValue().toString());
      //pst.setString(2, filters.get("fecha2").getValue().toString());
      // Filtros dinamicos
      int paramNumber = 3; // continuamos la numeracion de los parametros
      for (String paramName : filters.keySet()) {
         Condicion condicion = filters.get(paramName);
         if (!condicion.isMandatory()) {
            if (condicion.getValue() instanceof Double) {
               pst.setDouble(paramNumber, (Double) condicion.getValue());
            } else if (condicion.getValue() instanceof Integer) {
               pst.setInt(paramNumber, (Integer) condicion.getValue());
               //more types here...
            } else // el operador que aplica para el campo es like
             if (condicion.getOperator().equals("like")) {
                  pst.setString(paramNumber, "%" + condicion.getValue().toString() + "%");
               } else {
                  pst.setString(paramNumber, condicion.getValue().toString());
               }
            paramNumber++;
         }
      }

      ResultSet rs = pst.executeQuery();
      Map<String, Double> totales = new HashMap<>();
      while (rs.next()) {
         totales.put("total", rs.getDouble("COUNT"));
         //totales.put("costoCompSinImpuesto",rs.getDouble("COSTOCOMPSINIMPUESTO"));
         //totales.put("impuestoCostoCompra",rs.getDouble("IMPUESTOCOSTOCOMPRA"));
         //totales.put("costoCompMasImpuesto",rs.getDouble("COSTOCOMPMASIMPUESTO"));
      }
      pst.close();
      rs.close();
      //System.out.println("Getting total of records: " + total);
      return totales;
   }

   public List<Mueble> getPagination(Map<String, Condicion> filters, int first, int pageSize, String sortField, String sortOrder) throws SQLException {

      // Get the correct sort field
      String sort = this.getSortField(sortField);
      
      // Formamos los ANDs del where, dependiendo de los filtros que selecciono el usuario
      String ANDs = Consulta.getCondition(filters, false);

      String sql = "select muebles.ID_MUEBLE, muebles.DESCRIPCION, muebles.FACTURA, muebles.SERIE, muebles.FECHA_REGISTRO," +
         "muebles.FECHA_COMPRA, muebles.FECHA_ENTREGA, muebles.RFC_PROVEEDOR, muebles.COSTO,muebles.TIPO_ENTRADA," +
         "muebles.CUENTA_FINANZAS,muebles.IVA,muebles.ID_FACTURA,muebles.VIDA_UTIL, muebles.GARANTIA, " +
         "muebles.ESTADO_FISICO,muebles.ID_CLASIFICACION, muebles.ID_ESTATUS,"+
         "muebles.ID_OFICINA,muebles.OBSERVACIONES,muebles.TIPO_MUEBLE,muebles.ID_DEPENDENCIA,muebles.NUMERO," +
         "muebles.ID_ACTIVO from muebles "+
         "inner join activos a on a.id_activo = muebles.id_activo " +        
         "WHERE TIPO_MUEBLE=1 " + ANDs + "order by "+ sort +  " " + sortOrder + " limit " + first+ " , " + pageSize ;
      
      PreparedStatement pst = cn.getConnection().prepareStatement(sql);
      // Search by date (mandatory)
      //pst.setString(1, filters.get("fecha1").getValue().toString());
      //pst.setString(2, filters.get("fecha2").getValue().toString());

      // Filtros dinamicos
      int paramNumber = 3; // continuamos la numeracion de los parametros
      for (String paramName : filters.keySet()) {
         Condicion condicion = filters.get(paramName);
         if (!condicion.isMandatory()) {
            if (condicion.getValue() instanceof Double) {
               pst.setDouble(paramNumber, (Double) condicion.getValue());
            } else if (condicion.getValue() instanceof Integer) {
               pst.setInt(paramNumber, (Integer) condicion.getValue());
               //more types here...
            } else // el operador que aplica para el campo es like
            {
               if (condicion.getOperator().equals("like")) {
                  pst.setString(paramNumber, "%" + condicion.getValue().toString() + "%");
               } else {
                  pst.setString(paramNumber, condicion.getValue().toString());
               }
            }
            paramNumber++;
         }
      }

      ResultSet rs = pst.executeQuery();
      List<Mueble> lista = new LinkedList<>();
      Mueble mueble;
      OficinaDao ofDao = new OficinaDao(cn);
      ClasificacionDao clasDao = new ClasificacionDao(cn);
      EstatusDao estDao = new EstatusDao(cn);
      ActivoDao actDao = new ActivoDao(cn);
      DetalleResguardoDao drDao = new DetalleResguardoDao(cn);
      while (rs.next()) {
         mueble = new Mueble(rs.getInt("ID_MUEBLE"));
         mueble.setDescripcion(rs.getString("DESCRIPCION"));
         mueble.setFactura(rs.getString("FACTURA"));
         mueble.setEtiqueta(rs.getString("NUMERO"));
         mueble.setEstatus(estDao.getById(rs.getInt("ID_ESTATUS")));
         mueble.setOficina(ofDao.getById(rs.getInt("ID_OFICINA")));
         mueble.setClasificacion(clasDao.getById(rs.getInt("ID_CLASIFICACION")));
         mueble.setActivo(actDao.getById(rs.getInt("ID_ACTIVO")));
         // solo buscamos los datos del resguardo para los que tienen estatus de resguardo
         if (mueble.getEstatus().getId()==1)
            mueble.setDetResg((drDao.getByIdActivo(mueble.getActivo())));         
         lista.add(mueble);
      }
      // Quitamos de memoria los Daos
      ofDao=null;
      clasDao=null;
      estDao=null;
      actDao=null;
      drDao=null;
      //System.out.println("Fetching only " + lista.size() + " records");
      pst.close();
      rs.close();
      return lista;
   }

   private String getSortField(String name) {     
      switch (name) {
         case "idMueble":
            return "muebles.ID_MUEBLE";
         case "dependencia":
            return "muebles.ID_DEPENDENCIA";
         case "fechaCompra":
            return "partcomp.UsuFecha";
         case "proveedor":
            return "proveed.NOMBRE";
         default:
            return "prods.descrip";
      }
   }

}
