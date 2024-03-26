package service;

import entity.Despensa;
import entity.Ingrediente;
import entity.customExceptions.InvalidIngredientException;
import entity.customExceptions.NotEnoughStockException;
import entity.recetas.Receta;

public class CocinaService {
    private Despensa despensa;
    private Receta[] recetas;

    public CocinaService() {
    }

    public CocinaService(Despensa despensa, Receta[] recetas) {
        this.despensa = despensa;
        this.recetas = recetas;
    }

    public Despensa getDespensa() {
        return despensa;
    }

    public void setDespensa(Despensa despensa) {
        this.despensa = despensa;
    }

    public Receta[] getRecetas() {
        return recetas;
    }

    public void setRecetas(Receta[] recetas) {
        this.recetas = recetas;
    }

    @Override
    public String toString() {
        return "CocinaService: \n" + despensa +
                ", recetas: " + this.showRecetas();
    }

    public String showRecetas() {
        StringBuilder recetas = new StringBuilder();
        for (int counter = 0; counter < this.recetas.length; counter++) {
            if (counter < this.recetas.length-1) {
                recetas.append(String.format("\n\n%d- %s, ", counter+1, this.recetas[counter]));
            } else {
                recetas.append(String.format("\n\n%d- %s", counter+1, this.recetas[counter]));
            }
        }
        return "recetas: " + recetas;
    }

    public String makeReceta(Integer recetaNumber) throws NotEnoughStockException{
        Despensa ingredientesFaltantes = this.verifyAvaReceta(recetaNumber);
        if (ingredientesFaltantes.getIngredientes().length > 0) {
            throw new NotEnoughStockException("Faltan los siguientes ingredientes:  "+ingredientesFaltantes.showIngredientes());
        }
        for (Ingrediente ingrediente: this.recetas[recetaNumber-1].getIngredientes()) {
            try {
                this.despensa.getIngrediente(ingrediente.getNombre(), ingrediente.getCantidad());
            } catch (Exception e) {
                throw new NotEnoughStockException(e.getMessage());
            }
        }
        return this.recetas[recetaNumber-1].getPreparacion();
    }

    private Despensa verifyAvaReceta(Integer recetaNumber) {
        Receta receta = this.recetas[recetaNumber-1];
        Despensa ingredientesFaltantes = new Despensa();
        for (Ingrediente ingrediente: receta.getIngredientes()) {
            try {
                Ingrediente ingredienteDisp = this.despensa.inspectIngrediente(ingrediente.getNombre());
                if (ingredienteDisp.getCantidad() < ingrediente.getCantidad()) {
                    ingrediente.setCantidad(ingrediente.getCantidad()-ingredienteDisp.getCantidad());
                    ingredientesFaltantes.addIngrediente(ingrediente);
                }
            } catch (InvalidIngredientException e) {
                ingredientesFaltantes.addIngrediente(ingrediente);
            }
        }
        return ingredientesFaltantes;
    }
}
