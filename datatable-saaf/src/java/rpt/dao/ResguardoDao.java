package rpt.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import rpt.dto.Resguardo;
import saaf.DbConnection;

public class ResguardoDao {
   private DbConnection cn;

   public ResguardoDao(DbConnection cn) {
      this.cn = cn;
   }
   
   public Resguardo getById(int idResguardo) throws SQLException{
   
      Resguardo resguardo = resguardoExterno(idResguardo);      
      // no es externo. lo buscamos como resguardo normal
      if (resguardo.getId()==0)
      {         
         String sql = "select r.ID_RESGUARDO,concat(p.c01_nombre,' ', p.c01_apater,' ',p.c01_amater) as RESGUARDANTE from resguardos r " +
         "inner join personas p on p.c01_curp = r.CURP_RESPONSABLE " +
         "where r.ID_RESGUARDO = ?";    
         PreparedStatement pst = cn.getConnection().prepareStatement(sql);

         pst.setInt(1, idResguardo);
         ResultSet rs = pst.executeQuery();               
         if (rs.next()){
            resguardo.setId(idResguardo);
            resguardo.setResguardante(rs.getString("RESGUARDANTE"));
            resguardo.setTipo("RESGUARDO");         
         }
         pst.close();
         rs.close();
      }        
      return resguardo;   
   }
   
   
   /**
    * Metodo que nos regresa los datos de un resguardo externo
    */
   private Resguardo resguardoExterno(int idResguardo) throws SQLException{
   
      String sql = "select sre.ID_RESGUARDO, concat(dre.NOMBRE,' ',dre.AP_PATERNO,' ',dre.AP_MATERNO) as RESGUARDANTE " +
      "from  solicitud_resguardo_externo sre " +
      "inner join datos_resguardante_externo dre on dre.ID_SOLICITUD_RESGUARDO_EXTERNO=sre.ID_SOLICITUD_RESGUARDO_EXTERNO " +
      "where sre.ID_RESGUARDO = ?";    
      
      PreparedStatement pst = cn.getConnection().prepareStatement(sql);
      pst.setInt(1, idResguardo);
      ResultSet rs = pst.executeQuery();      
      Resguardo r = new Resguardo(0);
      if (rs.next()){
         r.setId(idResguardo);
         r.setResguardante(rs.getString("RESGUARDANTE"));
         r.setTipo("RESGUARDO EXTERNO");         
      }
      pst.close();
      rs.close();
      return r;   
   }
   
}
