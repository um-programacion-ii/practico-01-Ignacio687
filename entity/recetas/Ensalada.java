package entity.recetas;

import entity.Ingrediente;

public class Ensalada extends Receta{

    public Ensalada() {
        this.tiempoCoccion = 0;
        Object[][] ingredientes = {{"lechuga", 3}, {"tomate", 2}, {"aceite", 1}, {"queso", 2}, {"aceituna", 8}};
        this.setDefaultIngredients(ingredientes);
        this.preparacion = "1. Lavar y cortar la lechuga en trozos. 2. Cortar los tomates en rodajas. 3. Mezclar la lechuga y los tomates en un tazón grande. 4. Agregar aceite de oliva y mezclar bien. 5. Espolvorear queso rallado por encima. 6. Decorar con aceitunas. 7. Servir y disfrutar de una ensalada fresca y deliciosa.";
    }

    public Ensalada(Integer tiempoCoccion, Ingrediente[] ingredientes, String preparacion) {
        this.tiempoCoccion = tiempoCoccion;
        this.ingredientes = ingredientes;
        this.preparacion = preparacion;
    }

}
