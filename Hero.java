import java.util.*;

public class Hero extends SuperHuman {
    private static int mHp = 100;
    private static final int mAtk = 30;
    private static final String roleName = "勇者";
    private static String mName; 
    private static boolean liveFlag;
    private static int critPer = 15;

    Hero() {
    super(mHp, mAtk, roleName, mName, liveFlag, critPer);    
    }
}