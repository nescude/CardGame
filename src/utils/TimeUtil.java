package utils;

import game.GameMaster;

import java.util.concurrent.TimeUnit;

public class TimeUtil extends Thread{
    GameMaster gm;
    protected static int con = 0;
    protected int loc = ++con;

    public void setGm(GameMaster gm) {
        this.gm = gm;
    }

    @Override
    public void run() {
        try {
            this.sleep(2500);
            if (con == loc){
                gm.hideEventSign();
            }
        } catch (InterruptedException e) {
        }
    }
}
