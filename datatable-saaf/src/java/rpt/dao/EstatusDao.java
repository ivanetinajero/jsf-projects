package rpt.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import rpt.dto.Estatus;
import saaf.DbConnection;

public class EstatusDao {
   private DbConnection cn;

   public EstatusDao(DbConnection cn) {
      this.cn = cn;
   }
   
   public Estatus getById(int idEstatus) throws SQLException{
      String sql = "select * from estatus where id_estatus= ?";      
      PreparedStatement pst = cn.getConnection().prepareStatement(sql);
      pst.setInt(1, idEstatus);
      ResultSet rs = pst.executeQuery();
      Estatus es= new Estatus(0);
      while (rs.next()) {
         es.setId(rs.getInt("ID_ESTATUS"));
         es.setNombre(rs.getString("NOMBRE"));
      }
      pst.close();
      rs.close();
      return es;
   }
}
