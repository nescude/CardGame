package modelo;

import game.GameMaster;

public class User extends Player {
    public User(int i,int j,int k) {
        super(i,j,k);
    }

    @Override
    public void defeat() {
       super.vis.endSign("Derrota");
       GameMaster.setEndFlag(1);
       vis.setExitButton(true);
    }

    @Override
    public Card draw() {
        Card aux;
        if (canPutCard()){
            aux = super.deck.draw();
            int ist = putCard(aux);
            //System.out.println(hand[0]+" "+hand[1]+" "+hand[2]+" ");
            vis.putCard(aux.toString(), ist);
            return aux;
        }
        else
            return null;
    }
}
