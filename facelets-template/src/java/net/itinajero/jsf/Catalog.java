package net.itinajero.jsf;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class Catalog {

    private List products;
    
    public Catalog() {
        System.out.println("Constructor..");
        products = new ArrayList<>();
        Product p1 = new Product(1,"Tv",300,5);
        Product p2 = new Product(2,"iPhone",400,2);
        Product p3 = new Product(3,"USB Memory",100,15);
        Product p4 = new Product(4,"Keyboard",50,4);
        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
    }

    public List getProducts() {
        return products;
    }
       
}
