import java.util.*;

public class Goblin implements Monster {
    private int mHp = 100;
    private final int mAtk = 50;
    private final String species = "ゴブリン";
    private String mName;
    public static char count = 'A';
    private boolean liveFlag;
    private int critPer = 30;

    Goblin() {
        this.mName = species + count;
        count++;
        System.out.println(mName + "が現れた！");
        this.liveFlag = true;
    }

    public void attackTrigger(Human human) {
        if(this.liveFlag == true) {
            if(human.getLiveFlag() == true) {
                int n = new Random().nextInt(100);
                if(n < this.critPer) {
                    critAttack(human);
                } else {
                    normalAttack(human);
                }
            }
        }
    }   

    public void normalAttack(Human human) {
        human.setMhp(human.getMhp() - mAtk);
        System.out.println( mName + "の攻撃" );
        System.out.println(human.getMname() + "に" + mAtk + "ダメージ！");
        human.judgeMhp();
    }
    public void critAttack(Human human) {
        human.setMhp(human.getMhp() - mAtk * 3 / 2);
        System.out.println( mName + "の会心の攻撃" );
        System.out.println(human.getMname() + "に" + mAtk * 3 / 2 + "ダメージ！！！");
        human.judgeMhp();
    }
    public int getMhp() {
        return this.mHp;
    }
    public void setMhp(int hp) {
        this.mHp = hp;
    }
    public String getMname() {
        return this.mName;
    }
    public void setMname(String name) {
        this.mName = name;
        count++;
    }
    public void judgeMhp() {
        if(this.mHp <= 0){
            System.out.println(mName + "は息絶えた…");
            this.liveFlag = false;
        }
    }
    public boolean getLiveFlag() {
        return this.liveFlag;
    }
}