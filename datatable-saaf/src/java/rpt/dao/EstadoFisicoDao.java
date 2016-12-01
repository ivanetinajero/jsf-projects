package rpt.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import rpt.dto.EstadoFisico;
import saaf.DbConnection;

public class EstadoFisicoDao {
   
   private DbConnection cn;

   public EstadoFisicoDao(DbConnection cn) {
      this.cn = cn;
   }
   
   public EstadoFisico getById(int idEstadoF) throws SQLException{
      String sql = "select * from estado_fisico where id_estadof = ?";      
      PreparedStatement pst = cn.getConnection().prepareStatement(sql);
      pst.setInt(1, idEstadoF);
      ResultSet rs = pst.executeQuery();
      EstadoFisico ef= new EstadoFisico(0);
      while (rs.next()) {
         ef.setId(rs.getInt("ID_ESTADOF"));
         ef.setNombre(rs.getString("NOMBRE"));
      }
      pst.close();
      rs.close();
      return ef;
   }
}
