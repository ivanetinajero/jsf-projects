package net.itinajero;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

@ManagedBean
@ViewScoped
public class MenuView {

   private MenuModel model;

   public MenuView() {

      model = new DefaultMenuModel();

      //First submenu
      DefaultSubMenu firstSubmenu = new DefaultSubMenu("Sistema");

      DefaultMenuItem salir = new DefaultMenuItem("Salir");
      salir.setUrl("/logout"); // relativa a ROOT
      salir.setIcon("ui-icon-home");
      firstSubmenu.addElement(salir);

      model.addElement(firstSubmenu); // agregamos el submenu al Menu

      //Second submenu
      DefaultSubMenu secondSubmenu = new DefaultSubMenu("Catalogos");
      DefaultMenuItem clientes = new DefaultMenuItem("Clientes");
      clientes.setUrl("/view/someoption.xhtml"); // con URL        
      clientes.setIcon("ui-icon-home");
      secondSubmenu.addElement(clientes);

      DefaultMenuItem save = new DefaultMenuItem("Save");     
      
      //int num=11;
      //String url="#{menuView.saveInt("+num+")}";
      
      String someData = "cadena";
      String url="#{menuView.saveString(\" " + someData + "\")}";
           
      System.out.println("URL dinamica: " + url);
      save.setCommand(url);
      save.setAjax(true);
      save.setUpdate("messages");
      save.setIcon("ui-icon-home");
      secondSubmenu.addElement(save);

      model.addElement(secondSubmenu); // agregamos el submenu al Menu
   }

   public MenuModel getModel() {
      return model;
   }

   public void saveInt(int num) {
      System.out.println("Clic en save menu");
      addMessage("Success", "Data saved : " + num);
   }
   
   public void saveString(String data) {
      System.out.println("Clic en save menu");
      addMessage("Success", "Data saved : " + data);
   }
   
   public void addMessage(String summary, String detail) {
      FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
      FacesContext.getCurrentInstance().addMessage(null, message);
   }

}
