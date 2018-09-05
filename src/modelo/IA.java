package modelo;

import game.GameMaster;

public class IA extends Player {
    public IA(int i,int j,int k) {
        super(i,j,k);
    }

    @Override
    public void defeat() {
        super.vis.endSign("Victoria");
        GameMaster.setEndFlag(1);
        vis.setExitButton(true);
    }
}
