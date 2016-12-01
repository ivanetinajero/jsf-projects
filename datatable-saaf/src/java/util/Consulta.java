package util;

import java.util.Map;

public class Consulta {

   public static String getCondition(Map<String, Condicion> params, boolean first) {
      String where="";
      for (String paramName : params.keySet()) {
         Condicion condicion = params.get(paramName);
         
         if ( ! condicion.isMandatory()) {
            if (first) {
               where += " where " + condicion.getField() + " "+  condicion.getOperator() + " ? ";
               first = false;
            } else {
               where += " and " + condicion.getField() + " " + condicion.getOperator() + " ? ";
            }
         }
      }
      return where;
   }
}
