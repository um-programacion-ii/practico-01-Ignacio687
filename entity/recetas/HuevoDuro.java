package entity.recetas;

import entity.Ingrediente;

public class HuevoDuro extends Receta{

    public HuevoDuro() {
        this.tiempoCoccion = 10;
        Object[][] ingredientes = {{"huevo", 1}, {"agua", 1}};
        this.setDefaultIngredients(ingredientes);
        this.preparacion = "Poner un huevo en agua hirviendo durante 10 minutos.";
    }

    public HuevoDuro(Integer tiempoCoccion, Ingrediente[] ingredientes, String preparacion) {
        this.tiempoCoccion = tiempoCoccion;
        this.ingredientes = ingredientes;
        this.preparacion = preparacion;
    }

}
