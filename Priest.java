import java.util.*;

public class Priest extends SuperHuman {
    private static int mHp = 80;
    private static final int mAtk = 20;
    private static final int healPt = 50; 
    private static final String roleName = "僧侶";
    private static String mName; 
    private static boolean liveFlag;
    private static int critPer = 30;

    Priest() {
       super(mHp, mAtk, roleName, mName, liveFlag, critPer);  
    }

    public void healHuman(Human human) {
        System.out.println(mName + "は回復呪文を唱えた！");
        System.out.println(human.getMname() + "のHpを" + this.healPt + "回復！");
        human.setMhp(human.getMhp() + this.healPt);
    }
}