/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.neu.Controller;

import java.util.ArrayList;
import java.util.List;
import me.neu.model.Product;

/**
 *
 * @author Alex
 */
public class ProductDB {

    public static List<Product> getAvailableProduct() {
        List<Product> productList = new ArrayList<>();

        Product book1 = new Product();
        book1.setName("Java");
        book1.setPrice(20.22);
        book1.setCategory("book");
        productList.add(book1);

        Product book2 = new Product();
        book2.setName("C Language");
        book2.setPrice(30.23);
        book2.setCategory("book");
        productList.add(book2);

        Product book3 = new Product();
        book3.setName("C++ Language");
        book3.setPrice(32.23);
        book3.setCategory("book");
        productList.add(book3);

        Product book4 = new Product();
        book4.setName("HTML");
        book4.setPrice(10.98);
        book4.setCategory("book");
        productList.add(book4);

        Product book5 = new Product();
        book5.setName("JAVASCRIPT");
        book5.setPrice(23.23);
        book5.setCategory("book");
        productList.add(book5);

        Product music1 = new Product();
        music1.setName("Love you as a love song");
        music1.setPrice(10.22);
        music1.setCategory("music");
        productList.add(music1);

        Product music2 = new Product();
        music2.setName("immortal");
        music2.setPrice(30.12);
        music2.setCategory("music");
        productList.add(music2);

        Product music3 = new Product();
        music3.setName("Low");
        music3.setPrice(12.23);
        music3.setCategory("music");
        productList.add(music3);

        Product music4 = new Product();
        music4.setName("No Problem");
        music4.setPrice(22.98);
        music4.setCategory("music");
        productList.add(music4);

        Product music5 = new Product();
        music5.setName("Nothing in the World");
        music5.setPrice(23.67);
        music5.setCategory("music");
        productList.add(music5);

        Product computer1 = new Product();
        computer1.setName("DEll");
        computer1.setPrice(1000);
        computer1.setCategory("computer");
        productList.add(computer1);

        Product computer2 = new Product();
        computer2.setName("Mac");
        computer2.setPrice(1299);
        computer2.setCategory("computer");
        productList.add(computer2);

        Product computer3 = new Product();
        computer3.setName("ASUS");
        computer3.setPrice(799);
        computer3.setCategory("computer");
        productList.add(computer3);

        Product computer4 = new Product();
        computer4.setName("Lenovo");
        computer4.setPrice(899);
        computer4.setCategory("computer");
        productList.add(computer4);

        Product computer5 = new Product();
        computer5.setName("HP");
        computer5.setPrice(1100);
        computer5.setCategory("computer");
        productList.add(computer5);

        return productList;

    }
}
