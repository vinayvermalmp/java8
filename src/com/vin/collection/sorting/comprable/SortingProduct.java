package com.vin.collection.sorting.comprable;

import com.vin.collection.sorting.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingProduct {
    public static void main(String[] args) {
        comparable();
    }
    public static void comparable(){
        List<Product> products = new ArrayList<>();
        products.add(new Product(99));
        products.add(new Product(9));
        products.add(new Product(19));
        Collections.sort(products);
        System.out.println(products);// [Product{id=9}, Product{id=19}, Product{id=99}]
    }
}
