package service;

import entity.Chef;
import entity.Ingrediente;
import entity.customExceptions.NotEnoughStockException;
import entity.Despensa;
import entity.recetas.*;


public class Main {
    public static void main (String[] args) {
        // ################ PUNTO 1 ################
        System.out.print("\u001B[31m");
        System.out.println("Punto1:\n");
        System.out.print("\u001B[0m");
        System.out.println("Ingredientes:");
        String[] ingredientesNames = {"papa", "harina", "queso", "leche", "huevo"};
        Ingrediente[] ingredientes = new Ingrediente[5];
        for (int counter = 0; counter < 5; counter++) {
            Ingrediente ingrediente = new Ingrediente(ingredientesNames[counter], counter);
            ingredientes[counter] = ingrediente;
            System.out.println(ingrediente);
        }
        // ################ PUNTO 2 ################
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
            System.out.println(despensa);
            System.out.println("Añadiendo "+ingrediente+"\n");
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
        // ################ PUNTO 3 ################
        System.out.print("\u001B[31m");
        System.out.println("\nPunto3:\n");
        System.out.print("\u001B[0m");
        System.out.println("Creando las clases Receta: ");
        Receta huevoDuro = new HuevoDuro();
        Receta pizza = new Pizza();
        Receta ensalada = new Ensalada();
        Receta fideos = new Fideos();
        System.out.println(huevoDuro+"\n\n"+pizza+"\n\n"+ensalada+"\n\n"+fideos);
        // ################ PUNTO 4 ################
        System.out.print("\u001B[31m");
        System.out.println("\nPunto4:\n");
        System.out.print("\u001B[0m");
        Chef chef = new Chef("Fernando", 2);
        for (Ingrediente ingrediente: fideos.getIngredientes()) {
            despensa.addIngrediente(new Ingrediente(ingrediente.getNombre(), ingrediente.getCantidad()));
        }
        for (Ingrediente ingrediente: pizza.getIngredientes()) {
            despensa.addIngrediente(new Ingrediente(ingrediente.getNombre(), ingrediente.getCantidad()));
        }
        for (Ingrediente ingrediente: ensalada.getIngredientes()) {
            despensa.addIngrediente(new Ingrediente(ingrediente.getNombre(), ingrediente.getCantidad()));
        }
        CocinaService cocinaService = new CocinaService(despensa, new Receta[]{ensalada, fideos, huevoDuro, pizza});
        System.out.println("El chef "+ chef + " va a preparar tres de las siguientes recetas:");
        System.out.println(cocinaService.showRecetas());
        try {
            Integer[] recetasArray = {2,4,1,4};
            for (Integer receta: recetasArray) {
                System.out.println("\nPreparación receta "+receta+":  ");
                System.out.println(cocinaService.makeReceta(receta));
                System.out.println(cocinaService.getDespensa());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}