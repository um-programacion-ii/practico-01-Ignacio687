package entity.recetas;

import entity.Ingrediente;

public class Fideos extends Receta{

    public Fideos() {
        this.tiempoCoccion = 10;
        Object[][] ingredientes = {{"fideos", 1}, {"agua", 1}, {"sal", 1}};
        this.setDefaultIngredients(ingredientes);
        this.preparacion = "Hervir agua en una olla. Agregar sal al agua hirviendo. Añadir los fideos y cocinar durante 10 minutos. Escurrir y servir caliente.";
    }

    public Fideos(Integer tiempoCoccion, Ingrediente[] ingredientes, String preparacion) {
        this.tiempoCoccion = tiempoCoccion;
        this.ingredientes = ingredientes;
        this.preparacion = preparacion;
    }

}
