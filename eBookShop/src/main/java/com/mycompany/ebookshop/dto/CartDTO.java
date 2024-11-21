/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ebookshop.dto;

/**
 *
 * @author hoang
 */
public class CartDTO {
    int id;
    String title;
    String author;
    float price;
    int orderQuantity;

    public String getAuthor() {
        return author;
    }

    public int getId() {
        return id;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public float getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setTitle(String title) {
        this.title = title;
    } 
}
