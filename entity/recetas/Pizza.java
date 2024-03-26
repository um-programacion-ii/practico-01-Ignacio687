package entity.recetas;

import entity.Ingrediente;

public class Pizza extends Receta{

    public Pizza() {
        this.tiempoCoccion = 30;
        Object[][] ingredientes = {{"harina", 1}, {"agua", 1}, {"aceite", 1}, {"queso", 2}, {"tomate", 3}};
        this.setDefaultIngredients(ingredientes);
        this.preparacion = "Extender la masa, agregar salsa y queso, añadir ingredientes, hornear por 30 minutos o hasta dorar.";
    }

    public Pizza(Integer tiempoCoccion, Ingrediente[] ingredientes, String preparacion) {
        this.tiempoCoccion = tiempoCoccion;
        this.ingredientes = ingredientes;
        this.preparacion = preparacion;
    }

}
