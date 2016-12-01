package rpt.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import rpt.dto.Activo;
import rpt.dto.DetalleResguardo;
import rpt.dto.Oficina;
import saaf.DbConnection;

public class DetalleResguardoDao {
   private DbConnection cn;

   public DetalleResguardoDao(DbConnection cn) {
      this.cn = cn;
   }
   
   public DetalleResguardo getByIdActivo(Activo activo) throws SQLException{
      String sql = "select * from detalles_resguardos where id_activo = ?";        
      PreparedStatement pst = cn.getConnection().prepareStatement(sql);
      pst.setInt(1, activo.getId());
      ResultSet rs = pst.executeQuery();
      DetalleResguardo detRes= new DetalleResguardo(0);
      ResguardoDao resDao = new ResguardoDao(cn);
      while (rs.next()) {
         detRes.setId(rs.getInt("ID_DETALLE_RESGUARDO"));
         detRes.setActivo(activo);
         detRes.setResguardo(resDao.getById(rs.getInt("ID_RESGUARDO")));
      }
      
      resDao=null;
      pst.close();
      rs.close();
      return detRes;
   }
}
