package net.itinajero.jsf;

public class Product {
    private int id;
    private String description;
    private double cost;
    private int stock;

    public Product(int id, String description, double cost, int stock) {
        this.id = id;
        this.description = description;
        this.cost = cost;
        this.stock = stock;
    }

    public Product() {
    
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", description=" + description + ", cost=" + cost + ", stock=" + stock + '}';
    }
        
}
