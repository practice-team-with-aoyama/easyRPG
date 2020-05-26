import java.util.*;

public class Main {
    static Hero hero;
    static SuperHero superHero;
    static Priest priest;
    static Slime slime;
    static Goblin goblin;
    static Dragon dragon;
    static Human[] humen;
    static Monster[] monsters;

    public static void main(String[] args) {
        hero = new Hero();
        superHero = new SuperHero();
        priest = new Priest();
        slime = new Slime();
        goblin = new Goblin();
        dragon = new Dragon();
        humen = new Human[]{hero, superHero, priest};
        monsters = new Monster[]{slime, goblin, dragon};
        while(true) {
            for (int l = 0; l < humen.length; l++) {
                if(allDeth(monsters)) {
                    System.out.println("人類の勝利だ！");
                    break;
                }
                humen[l].attackSelect(monsters);
            }
            for (int i = 0; i < monsters.length; i++) {
                int n = new Random().nextInt(3);
                do {
                    if(allDeth(humen)) {
                        System.out.println("その日、人類は絶滅した。。。");
                        break;
                    }
                    n = new Random().nextInt(3);
                } while (!humen[n].getLiveFlag());
                monsters[i].attackTrigger(humen[n]);
            }
            if(allDeth(monsters)) {
                System.out.println("人類の勝利だ！");
                break;
            } else if(allDeth(humen)) {
                System.out.println("その日、人類は絶滅した。。。");
                break;
            }
        }
    }
    public static boolean allDeth(Human[] humen) {
        boolean allDeth = true;
        for(int i = 0; i < humen.length; i++) {
            if(humen[i].getLiveFlag()) {
                allDeth = false;
            }
        }
        return allDeth;
    }
    public static boolean allDeth(Monster[] monsters) {
        boolean allDeth = true;
        for(int i = 0; i < monsters.length; i++) {
            if(monsters[i].getLiveFlag()) {
                allDeth = false;
            }
        }
        return allDeth;
    }
}