package net.itinajero;

import net.itinajero.dao.Car;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import net.itinajero.dao.Payment;
import org.primefaces.event.ToggleEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.Visibility;

@ManagedBean(name = "dtLazyView")
@ViewScoped
public class LazyView implements Serializable {

   private LazyDataModel<Car> lazyModel;
   private String brand;
   private List<Payment> payments;

   public LazyView() {
      System.out.println("Constructor ManagedBean");
   }

   @PostConstruct
   public void init() {
      System.out.println("INIT ManagedBean");
   }

   public LazyDataModel<Car> getLazyModel() {
      return lazyModel;
   }

   public String getBrand() {
      return brand;
   }

   public void setBrand(String brand) {
      this.brand = brand;
   }

   public void search() {
      lazyModel = new LazyCarDataModel(this.brand);
   }

   public void onRowToggle(ToggleEvent event) {
      try {
         // Only query when clic en expansion, not when hidden
         if (event.getVisibility()== Visibility.VISIBLE ){         
            Car carSelected = (Car) event.getData();
            System.out.println("Getting payments for car id: " + carSelected.getId());
            
            List<Payment> temp = new LinkedList<>();
            Payment pay1 = new Payment(1);
            pay1.setConcept("insurance 2015");
            pay1.setIdCar(1);
            pay1.setTotal(1500.50);
            pay1.setDate("2015-01-15");
            
            Payment pay2 = new Payment(2);
            pay2.setConcept("insurance 2016");
            pay2.setIdCar(1);
            pay2.setTotal(1800.90);
            pay2.setDate("2016-02-15");
            
            temp.add(pay1);
            temp.add(pay2);
            //payments = daoPayments.getAllByCar(carSelected.getId()); // get data from db
            payments = temp;
         }
      } catch (Exception ex) {
         System.out.println("Error in onRowToggle: " + ex);
      }
   }

   public List<Payment> getPayments() {
      return payments;
   }   
   
}
