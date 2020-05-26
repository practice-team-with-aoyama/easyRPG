import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Hero hero = new Hero();
        Slime slime = new Slime();
        System.out.println(hero.getMname());
        hero.attackTrigger(slime);
        System.out.println(hero.getMhp());
        System.out.println(hero.getMhp());
        slime.attackTrigger(hero);     
    }
}