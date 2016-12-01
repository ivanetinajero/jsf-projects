package rpt.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import rpt.dto.Activo;
import saaf.DbConnection;

public class ActivoDao {
   private DbConnection cn;

   public ActivoDao(DbConnection cn) {
      this.cn = cn;
   }
   
public Activo getById(int idActivo) throws SQLException{
      String sql = "select * from activos where id_activo = ?";      
      PreparedStatement pst = cn.getConnection().prepareStatement(sql);
      pst.setInt(1, idActivo);
      ResultSet rs = pst.executeQuery();
      Activo activo= new Activo(0);
      DependenciaDao daoDep = new DependenciaDao(cn);
      while (rs.next()) {
         activo.setId(rs.getInt("ID_ACTIVO"));
         activo.setDependencia(daoDep.getById(rs.getInt("ID_DEPENDENCIA")));
         activo.setTipoActivo(rs.getString("TIPO_ACTIVO"));
         activo.setPropio(rs.getString("PROPIO"));
      }
      daoDep=null;
      pst.close();
      rs.close();
      return activo;
   }   
}
