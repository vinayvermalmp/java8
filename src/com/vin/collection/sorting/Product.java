package com.vin.collection.sorting;

public class Product implements Comparable<Product>{
    private Integer id;

    public Product(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return "Product{" + "id=" + id + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Product){
            Product otherProduct = (Product)obj;
            if(id == otherProduct.id)
                return true;
        }
        return false;
    }

    @Override
    public int compareTo(Product product) {
        return id.compareTo(product.id);
    }
}
