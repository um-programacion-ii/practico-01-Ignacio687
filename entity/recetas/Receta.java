package entity.recetas;

import entity.Ingrediente;

public abstract class Receta {
    protected Integer tiempoCoccion;
    protected Ingrediente[] ingredientes;
    protected String preparacion;

    public Integer getTiempoCoccion() {
        return tiempoCoccion;
    }

    public void setTiempoCoccion(Integer tiempoCoccion) {
        this.tiempoCoccion = tiempoCoccion;
    }

    public Ingrediente[] getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(Ingrediente[] ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getPreparacion() {
        return preparacion;
    }

    public void setPreparacion(String preparacion) {
        this.preparacion = preparacion;
    }

    @Override
    public String toString() {
        StringBuilder ingredientes = new StringBuilder();
        for (int counter = 0; counter < this.ingredientes.length; counter++) {
            if (counter < this.ingredientes.length-1) {
                ingredientes.append("\n").append(this.ingredientes[counter]).append(", ");
            } else {
                ingredientes.append("\n").append(this.ingredientes[counter]);
            }
        }
        return this.getClass().getSimpleName()+", tiempoCoccion: " + tiempoCoccion +" m"+
                ", ingredientes:" + ingredientes +
                ", \npreparacion: " + preparacion;
    }
    protected void setDefaultIngredients(Object[][] ingredientes) {
        this.ingredientes = new Ingrediente[ingredientes.length];
        for (int counter = 0; counter < this.ingredientes.length; counter++) {
            this.ingredientes[counter] = new Ingrediente((String) ingredientes[counter][0], (Integer) ingredientes[counter][1]);
        }
    }
}
