package game;

import modelo.Card;
import modelo.IA;
import modelo.Player;
import modelo.User;

import utils.NoManaException;

import utils.TimeUtil;

import vista.IWindow;
import vista.Window;


/**Class that manage the game flow.
 */
public class GameMaster {
    private IA ia;
    private User user;
    private IWindow vis;
    private int turno=0;
    private int turn=0;
    public static int endFlag=0;

    public static int getEndFlag() {
        return endFlag;
    }

    public static void setEndFlag(int endFlag) {
        GameMaster.endFlag = endFlag;
    }

    public void setIa(Player ia) {
        this.ia = (IA)ia;
    }

    public void setUser(Player user) {
        this.user = (User)user;
    }
    public int getTurn(){
        return turn;
    }

    /**Class that init the window values.
     */
    public void empezar(){
        for (int i=0;i<3;i++){
            user.draw();
            ia.draw();
        }
        vis.putCard(user.showCard(1).toString(),1);
        vis.putCard(user.showCard(2).toString(),2);
        vis.putCard(user.showCard(3).toString(),3);
        
        vis.updateStats();
        vis.waitSign();
        vis.endSign("");
        vis.setExitButton(false);
        iniciaTurno(user);
    }

    /**Class that perform the card action.
     * @param i - Index in player's hand.
     * @throws NoManaException - Exception if a player is running out of mana.
     */
    public void pickCard(int i) throws NoManaException {
        String sign;
        
        if (turn ==0){
            Card aux = user.showCard(i);
            aux.pick(user,ia);
            if (aux.getFactor()>0)
                sign = "-";
            else
                sign = "+";
            user.removeCard(i);
            vis.eventSign(">>Usuario usó "+aux.getName()+" ["+sign+Math.abs(aux.getFactor())+"]<<");
            vis.updateStats();
        }
        else{
            //System.out.println(turn);
            Card aux = ia.showCard(i);
            aux.pick(ia,user);
            if (aux.getFactor()>0)
                sign = "-";
            else
                sign = "+";
            ia.removeCard(i);
            vis.eventSign(">>Enemigo usó "+aux.getName()+" ["+sign+Math.abs(aux.getFactor())+"]<<");
            vis.updateStats();
        }
        TimeUtil t = new TimeUtil();
        t.setGm(this);
        t.start();
    }
    
    public void hideEventSign(){
        vis.eventSign("");
        vis.waitSign();
    }

    /**Class that draw a card and manage the ai.
     * @param player
     */
    public void iniciaTurno(Player player) {
        if (player.canPutCard()){
            Card aux = player.draw();            
        }
        player.llenaMana();
        vis.updateStats();
        Card aux=null;
        if (turn !=0){
            int i=0;
            while(aux==null && i<3){
                aux=ia.showCard(i+1);
                i++;
                if (ia.getMana()-aux.getCost()<0)
                    aux=null;
            }
            try {
                if (aux!=null)
                    pickCard(i);
            } catch (NoManaException e) {
            }
            changeTurn();
            iniciaTurno(user);
        }
    }

    void serVis(IWindow vis) {
        this.vis=vis;
    }

    /**Class that change turn value 0<=>1.
     */
    public void changeTurn(){
        if (turn == 0)
            turn = 1;
        else
            turn = 0;
    }
}
