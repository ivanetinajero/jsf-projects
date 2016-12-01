package net.itinajero;

import java.sql.SQLException;
import net.itinajero.dao.Car;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import net.itinajero.dao.CarsDao;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

public class LazyCarDataModel extends LazyDataModel<Car> {
    
    private String brand;

    public LazyCarDataModel(String filter) {
        try {
            CarsDao dao = new CarsDao();
            this.brand = filter;
            this.setRowCount(dao.getCount(this.brand)); // total of rows                        
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());            
        }
        //System.out.println("Constructor LazyCarDataModel");        
    }
    
    @Override
    public List<Car> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters) {        
        /*
        System.out.println("consulta a la bd");        
        System.out.println("First:" + first);
        System.out.println("PageSize:" + pageSize);        
        System.out.println("Order by " + sortField + " " + sortOrder);
        System.out.println("******************");
        */
        String typeOrder="desc";
        switch (sortOrder){
            case  ASCENDING:
                typeOrder="asc"; break;
            case  DESCENDING:
                typeOrder="desc"; break;
            default:
                typeOrder="asc"; break;                
        }
        CarsDao dao = new CarsDao();        
        List<Car> data = new LinkedList<>();
        try{
            data = dao.getPagination(this.brand,first,pageSize,sortField,typeOrder);
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());            
        }
                
        return data;
    }
        
}