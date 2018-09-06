package modelo;

public class Condition {
    private String condName;
    private String condID;
    private int appli;
    private int turns;


    public Condition(String condName, int appli, int turns) {
        this.condName = condName;
        this.appli = appli;
        this.turns = turns;
    }
}
