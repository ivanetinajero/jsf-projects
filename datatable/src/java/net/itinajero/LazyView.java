package net.itinajero;

import net.itinajero.dao.Car;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.LazyDataModel;
 
@ManagedBean(name="dtLazyView")
@ViewScoped
public class LazyView implements Serializable {
     
    private LazyDataModel<Car> lazyModel;
    private String brand;
   
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

    public void search(){
        lazyModel = new LazyCarDataModel(this.brand);
    }
    
}