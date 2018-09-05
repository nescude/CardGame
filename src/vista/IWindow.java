package vista;

import game.GameMaster;

import javax.swing.JLabel;

import modelo.IA;
import modelo.Player;
import modelo.User;

public interface IWindow {
    void arranca();
    void updateStats();
    void endSign(String sign);
    void eventSign(String sign);
    void setCard1(String string);
    void setCard2(String string);
    void setCard3(String string);
    void putCard(String string, int index);
    void setUser(Player user);
    void setIa(Player ia);
    void setGm(GameMaster gm);
    void finalizar();
    void setExitButton(boolean bool);
}
