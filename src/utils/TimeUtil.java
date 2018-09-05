package utils;

import game.GameMaster;

import java.util.concurrent.TimeUnit;

public class TimeUtil extends Thread{
    GameMaster gm;

    public void setGm(GameMaster gm) {
        this.gm = gm;
    }

    @Override
    public void run() {
        try {
            this.sleep(2500);
            gm.hideEventSign();
        } catch (InterruptedException e) {
        }
    }
}
