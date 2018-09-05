package modelo;

import utils.NoManaException;

public class AttackCard extends Card{
    protected int dmg;
    protected String tipe="Attack";


    public AttackCard(int consume, String nombre,int dmg) {
        super(consume, nombre);
        this.dmg = dmg;
    }

    @Override
    public void pick(Player org,Player obj) throws NoManaException {
        org.consumeMana(super.cost);
        obj.getDMG(dmg);
    }

    public int getDmg() {
        return dmg;
    }

    @Override
    public int getFactor() {
        return dmg;
    }
}
