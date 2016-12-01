package rpt.dao;

import saaf.DbConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import rpt.dto.Oficina;

public class OficinaDao {
   private DbConnection cn;

   public OficinaDao(DbConnection cn) {
      this.cn = cn;
   }
   
   public Oficina getById(int idOficina) throws SQLException{
      String sql = "select * from oficinas where id_oficina = ?";      
      PreparedStatement pst = cn.getConnection().prepareStatement(sql);
      pst.setInt(1, idOficina);
      ResultSet rs = pst.executeQuery();
      Oficina oficina= new Oficina(0);
      while (rs.next()) {
         oficina.setId(rs.getInt("ID_OFICINA"));
         oficina.setNombre(rs.getString("NOMBRE"));
      }
      pst.close();
      rs.close();
      return oficina;
   }
}
