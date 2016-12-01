package rpt.jsf;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import rpt.dto.Mueble;
import rpt.dao.MuebleDao;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import util.Condicion;

public class LazyMuebles extends LazyDataModel<Mueble> {

   private Map<String, Condicion> filter;
   private MuebleDao dao;

   public LazyMuebles(Map<String, Condicion> filter, MuebleDao dao, int count) throws SQLException {      
      this.filter = filter;
      this.dao = dao;
      this.setRowCount(count); // total of rows                              
   }

   @Override
   public List<Mueble> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {

      /*
      System.out.println("Consulta a la bd");
      System.out.println("First:" + first);
      System.out.println("PageSize:" + pageSize);
      System.out.println("Order by " + sortField + " " + sortOrder);
      System.out.println("******************");
       */
      String typeOrder = "desc";
      switch (sortOrder) {
         case ASCENDING:
            typeOrder = "asc";
            break;
         case DESCENDING:
            typeOrder = "desc";
            break;
         default:
            typeOrder = "asc";
            break;
      }

      List<Mueble> data = null;

      try {
         data = dao.getPagination(this.filter, first, pageSize, sortField, typeOrder);
      } catch (SQLException ex) {
         System.out.println("Error: LazyMuebles.load: " + ex.getMessage());
         return null;
      }
      return data;
   }
   
}
