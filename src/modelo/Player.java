package modelo;

import game.Deck;

import utils.NoManaException;

import vista.IWindow;

public abstract class Player {
    protected int hp=0;
    protected int mana=0;
    protected int maxMana=0;
    protected Deck deck = new Deck();
    protected Card[] hand=new Card[3];
    protected IWindow vis;
    
    public abstract void defeat();
    
    public Player(int hp,int mana,int maxMana) {
        this.hp = hp;
        this.mana=mana;
        this.maxMana=maxMana;
        for(int i=0;i<3;i++){
            hand[i]=null;
        }
    }

    public void setVis(IWindow vis) {
        this.vis = vis;
    }

    public void getDMG(int dmg){
        if ((this.hp-dmg)>0){
            hp-=dmg;
        }
        else{
            hp=0;
            defeat();
        }
    }
    
    public void consumeMana(int cons) throws NoManaException {
        if ((this.getMana()-cons) < 0){
            throw new NoManaException();
        }
        else
            this.mana-=cons;
    }
    
    public void llenaMana() {
        this.mana=this.maxMana++;
    }

    public int getHp() {
        return hp;
    }

    public int getMana() {
        return mana;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public int getDeckCount(){
        return this.deck.getSize();
    }
    
    public boolean canPutCard(){
        if (hand[0]==null||hand[1]==null||hand[2]==null)
            return true;
        return false;
    }
    public int putCard(Card card){
        int i=0;
        boolean enc=false;
        while (i<=2 && (!enc)){
            if (hand[i]==null){
                hand[i]=card;
                
                enc=true;
            }
            i++;
        }
        return i;
    }
    public Card draw(){
        Card aux;
        if (canPutCard()){
            aux = this.deck.draw();
            //System.out.println(hand[0]+" "+hand[1]+" "+hand[2]+" ");
            putCard(aux);
            return aux;
        }
        else
            return null;
        
    }
    
    public Card removeCard(int i){
        Card aux = this.hand[i-1];
        this.hand[i-1]=null;
        return aux; 
    }
    public Card showCard(int i){
        return this.hand[i-1]; 
    }
    
}
