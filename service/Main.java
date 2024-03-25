package service;

import entity.Ingrediente;
import entity.InvalidIngredientException;
import entity.NotEnoughStockException;
import entity.Despensa;

public class Main {
    public static void main (String[] args) {
        System.out.print("\u001B[31m");
        System.out.println("Punto1:\n");
        System.out.print("\u001B[0m");
        String[] ingredientesNames = {"papa", "harina", "queso", "leche", "huevo"};
        Ingrediente[] ingredientes = new Ingrediente[5];
        for (int counter = 0; counter < 5; counter++) {
            Ingrediente ingrediente = new Ingrediente(ingredientesNames[counter], counter);
            ingredientes[counter] = ingrediente;
            System.out.println(ingrediente);
        }
        System.out.print("\u001B[31m");
        System.out.println("\nPunto2:\n");
        System.out.print("\u001B[0m");
        System.out.println("Sacar unidades de un ingrediente:");
        System.out.println(ingredientes[4]);
        try {
            System.out.println("Sacar 2 huevos");
            String rrt = ingredientes[4].sacar(2);
            System.out.println(rrt);
            System.out.println(ingredientes[4]);
            System.out.println("Sacar 3 huevos");
            ingredientes[4].sacar(3);
        } catch (NotEnoughStockException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\nCrear despensa e incluir los ingredientes:");
        Despensa despensa = new Despensa();
        for (Ingrediente ingrediente: ingredientes) {
            despensa.addIngrediente(ingrediente);
        }
        System.out.println(despensa);
        System.out.println("\nSacar una unidad de leche:");
        try {
            System.out.println(despensa.getIngrediente(" Leche", 1));
            System.out.println(despensa);
            System.out.println("\nSacar dos unidades de pescado:");
            despensa.getIngrediente(" pescado", 1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}