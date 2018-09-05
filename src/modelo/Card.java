package modelo;

import utils.NoManaException;

public abstract class Card {
    protected int cost;
    protected String name;
    protected String tipe="Card";


    public Card(int cost, String name) {
        this.cost = cost;
        this.name = name;
    }

    public abstract void pick(Player org,Player obj) throws NoManaException;


    @Override
    public String toString() {
        return this.name + "  ["+this.cost+"]";
    }

    public String getName() {
        return name;
    }


    public int getCost() {
        return cost;
    }
}
