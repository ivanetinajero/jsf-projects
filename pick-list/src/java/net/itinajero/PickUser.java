package net.itinajero;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import net.itinajero.dto.Sucursal;
import net.itinajero.dto.Usuario;
import org.primefaces.model.DualListModel;

@ManagedBean(name = "userBean")
// tiene que ser de alcance View. Si lo dejamos como request, el usuario seleccionado se pierde
// cuando guardamos las sucursales seleccionadas en el Dialog, porque ya es una peticion diferente.
@ViewScoped
public class PickUser implements Serializable{

   // Inicio picklist
   private DualListModel<Sucursal> sucursales;
   private List<Sucursal> source;
   private List<Sucursal> target;
   // Fin picklist
   
   private List<Usuario> usuarios;
   private Usuario selectedUser;

   @PostConstruct
   public void init() {

      // some database
      Usuario u1 = new Usuario(1);
      u1.setUsername("itinajero");
      u1.setPerfil("admin");
      Usuario u2 = new Usuario(2);
      u2.setUsername("juan");
      u2.setPerfil("editor");
      Usuario u3 = new Usuario(3);
      u3.setUsername("maria");
      u3.setPerfil("editor");
      usuarios = new LinkedList<>();
      usuarios.add(u1);
      usuarios.add(u2);
      usuarios.add(u3);
      
      // Sucursales
      source = new LinkedList<>();
      target = new LinkedList<>();     
      sucursales = new DualListModel<>(source, target);
       
   }

   public String save() {
      System.out.println("Usuario: " + selectedUser);
      System.out.println("Nuevas Suc: " + sucursales.getTarget());
      FacesContext context = FacesContext.getCurrentInstance();
      FacesMessage msg1 = new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO", "THE DATA WAS SAVED.");
      context.addMessage(null, msg1);
      return null;
   }

   public List<Usuario> getUsuarios() {
      return usuarios;
   }

   public Usuario getSelectedUser() {
      return selectedUser;
   }

   public void setSelectedUser(Usuario selectedUser) {      
      this.selectedUser = selectedUser;
      //System.out.println("Seleccionado: " + selectedUser);
      
      // Sucursales
      source.clear();
      target.clear();

      // the data from some database 
      Sucursal s1 = new Sucursal(1);
      s1.setNombre("Sucursal 1");
      Sucursal s2 = new Sucursal(2);
      s2.setNombre("Sucursal 2");
      Sucursal s3 = new Sucursal(3);
      s3.setNombre("Sucursal 3");
      Sucursal s4 = new Sucursal(4);
      s4.setNombre("Sucursal 4");

      source.add(s1);
      source.add(s2);
      source.add(s3);
      source.add(s4);
      
      // desde bd
      // target = someDao.SucursalesActuales();
      // source = someDao.TodasExceptoActuales();

      sucursales = new DualListModel<>(source, target);
      
   }

   public DualListModel<Sucursal> getSucursales() {
      return sucursales;
   }

   public void setSucursales(DualListModel<Sucursal> sucursales) {
      this.sucursales = sucursales;
   }

}
