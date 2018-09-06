package utils;

import modelo.AttackCard;
import modelo.Card;
import modelo.HealCard;

public class CardFactory {
    public static Card newCard(String tipo,String name,int cost,int dmg) throws IncorrectCardException {
        Card aux = null;
        if (tipo.equals("attack")){
            aux = new AttackCard(cost,name,dmg);
        }
        else{
            if (tipo.equals("util")){
                aux = new HealCard(cost,name,dmg);
            }
            else
            throw new IncorrectCardException("Error formato de Carta Incorrecto");
        }
     return aux;   
    }
}
