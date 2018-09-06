package modelo;

import utils.NoManaException;

public class VenomCard extends Card {
    public VenomCard(int i, String string) {
        super(i, string);
    }

    @Override
    public void pick(Player org, Player obj) throws NoManaException {
        
    }

    @Override
    public int getFactor() {
        return -2;
    }
}
