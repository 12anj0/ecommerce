package com.ranjansingh.ecommerce.global;

import com.ranjansingh.ecommerce.model.Product;

import java.util.ArrayList;
import java.util.List;

public class GlobalData {
    public static List<Product> cart;

    static {
        cart = new ArrayList<>();
    }
}
