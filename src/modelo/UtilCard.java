package modelo;

import utils.NoManaException;

public class UtilCard extends Card {
    protected String tipe="Util";
    private int heal;

    public UtilCard(int consume, String nombre,int curacion) {
        super(consume, nombre);
        this.heal = curacion;
    }

    @Override
    public void pick(Player org,Player obj) throws NoManaException {
        org.getDMG(-heal);
        org.consumeMana(super.cost);
    }
}
