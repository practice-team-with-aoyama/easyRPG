import java.util.*;

public class SuperHero extends SuperHuman{
    private static int mHp = 150;
    private static final int mAtk = 40;
    private static final String roleName = "ハイパー勇者";
    private static String mName; 
    private static boolean liveFlag;
    private static int critPer = 10;

    SuperHero() {
       super(mHp, mAtk, roleName, mName, liveFlag, critPer); 
    }
}