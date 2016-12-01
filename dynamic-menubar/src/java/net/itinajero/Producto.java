package net.itinajero;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Producto {
   private String desc;

   public String getDesc() {
      return desc;
   }

   public void setDesc(String desc) {
      this.desc = desc;
      System.out.println("Input : " + desc);
   }    
   
}
