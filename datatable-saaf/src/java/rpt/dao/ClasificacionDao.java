package rpt.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import rpt.dto.Clasificacion;
import saaf.DbConnection;

public class ClasificacionDao {
   private DbConnection cn;

   public ClasificacionDao(DbConnection cn) {
      this.cn = cn;
   }
   
   public Clasificacion getById(int idClas) throws SQLException{
      String sql = "select * from clasificaciones where id_clasificacion= ?";      
      PreparedStatement pst = cn.getConnection().prepareStatement(sql);
      pst.setInt(1, idClas);
      ResultSet rs = pst.executeQuery();
      Clasificacion c= new Clasificacion(0);
      while (rs.next()) {
         c.setId(rs.getInt("ID_CLASIFICACION"));
         c.setNombre(rs.getString("NOMBRE"));
      }
      pst.close();
      rs.close();
      return c;
   }
}
