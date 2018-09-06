package game;

import modelo.IA;
import modelo.Player;

import modelo.User;

import vista.IWindow;
import vista.Window;

public class MainRun {


    
    public static void main(String[] args) {
        /**
         * INIT VARIABLES
         */
        GameMaster gm = new GameMaster();
        IWindow vis = new Window();
        vis.arranca();
        Player user = new User(200,3,3);
        Player ia = new IA(200,3,3);
        /**
         * REFERENCES SET'S
         */
        user.setVis(vis);
        ia.setVis(vis);
        gm.setIa(ia);
        gm.setUser(user);
        gm.setVis(vis);
        vis.setIa(ia);
        vis.setUser(user);
        vis.setGm(gm);
        /**
         * START
         */
        gm.empezar();
    }
}
