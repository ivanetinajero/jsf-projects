package rpt.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import rpt.dto.Dependencia;
import saaf.DbConnection;

public class DependenciaDao {
   private DbConnection cn;

   public DependenciaDao(DbConnection cn) {
      this.cn = cn;
   }
   
   public Dependencia getById(int id) throws SQLException{
      String sql = "select d.ID,d.NOMBRE,d.TIPO," + 
      "if (d.dep_superior=0,d.nombre,(select nombre from dependencias where id=d.dep_superior)) as DEPENDENCIA," + 
      "if (d.dep_superior>0,(select nombre from dependencias where id=d.id),'') as DIRECCION " + 
      "from dependencias d where d.id= ?";       
      PreparedStatement pst = cn.getConnection().prepareStatement(sql);
      pst.setInt(1, id);
      ResultSet rs = pst.executeQuery();
      Dependencia dep= new Dependencia(0);
      while (rs.next()) {
         
         dep.setId(rs.getInt("ID"));
         dep.setNombre(rs.getString("NOMBRE"));
         //dep.setDepSup(rs.getInt("DEP_SUPERIOR"));
         dep.setTipo(rs.getString("TIPO"));
         dep.setDependencia(rs.getString("DEPENDENCIA"));
         dep.setDireccion(rs.getString("DIRECCION"));
                 
      }
      pst.close();
      rs.close();
      return dep;
   }
}
