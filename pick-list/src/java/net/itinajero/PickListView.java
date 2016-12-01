package net.itinajero;

import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import net.itinajero.dto.Sucursal;
import org.primefaces.model.DualListModel;

@ManagedBean
public class PickListView {

   private DualListModel<Sucursal> sucursales;

   @PostConstruct
   public void init() {
      // Sucursales
      List<Sucursal> source = new LinkedList<>();
      List<Sucursal> target = new LinkedList<>();

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

      sucursales = new DualListModel<>(source, target);

   }

   public DualListModel<Sucursal> getSucursales() {
      return sucursales;
   }

   public void setSucursales(DualListModel<Sucursal> sucursales) {
      this.sucursales = sucursales;
   }

   public String save() {
      System.out.println("Saving: " + sucursales.getTarget());
      FacesContext context = FacesContext.getCurrentInstance();
      FacesMessage msg1 = new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO", "THE DATA WAS SAVED.");
      context.addMessage(null, msg1);      
      return null;
   }
}
