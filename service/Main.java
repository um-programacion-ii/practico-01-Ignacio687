package service;

import entity.Ingrediente;

public class Main {
    public static void main (String[] args) {
        String[] ingredientes = {"papa", "harina", "queso", "leche", "huevo"};
        for (int counter = 0; counter < 5; counter++) {
            Ingrediente ingrediente = new Ingrediente(ingredientes[counter], counter);
            System.out.println(ingrediente);
        }
    }
}