package net.itinajero.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class CarsDao {
 
    public int getCount(String brand) throws SQLException {          
        DbConnection cn = new DbConnection();
        String sql = "select count(*) as count from Cars where id>0 and brand=?";
        PreparedStatement pst = cn.getConnection().prepareStatement(sql);
        pst.setString(1, brand);
        ResultSet rs = pst.executeQuery();
        int total=0;
        while (rs.next()) {
            total = rs.getInt("count");
        }
        pst.close();
        rs.close();
        cn.disconnect(); 
        System.out.println("Getting total of records: " + total);
        return total;
    }
    public List<Car> getPagination(String brand,int first, int pageSize, String sortField, String sortOrder) throws SQLException {
        DbConnection cn = new DbConnection();
        String sql = "select * from Cars where id>0 and brand= ? "+
                "order by "+sortField +  " " + sortOrder + " limit ? , ?";
       
        PreparedStatement pst = cn.getConnection().prepareStatement(sql);
        
        pst.setString(1, brand);     
        pst.setInt(2, first);
        pst.setInt(3, pageSize);              
        ResultSet rs = pst.executeQuery();
        
        List<Car> lista = new LinkedList<>();
        Car car;
        while (rs.next()) {
            car = new Car(rs.getInt("id"));
            car.setDescription(rs.getString("description"));
            car.setPrice(rs.getDouble("price"));            
            car.setBrand(rs.getString("brand"));
            car.setYear(rs.getInt("year"));
            car.setColor(rs.getString("color"));
            lista.add(car);
        }
        System.out.println("Fetching only "+lista.size()+" records");
        pst.close();
        rs.close();
        cn.disconnect();
        return lista;
    }
        
}
