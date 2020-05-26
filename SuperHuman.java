import java.util.*;

public class SuperHuman implements Human {
    private int mHp;
    private final int mAtk;
    private final String roleName;
    private String mName; 
    private boolean liveFlag;
    private int critPer;

    SuperHuman(int mHp, int mAtk, String roleName, String mName, boolean liveFlag, int critPer) {
        this.mHp = mHp;
        this.mAtk = mAtk;
        this.roleName = roleName;
        this.mName = mName;
        this.liveFlag = liveFlag;
        this.critPer = critPer;
        System.out.println(roleName + "の名前を入力してください");
        String name = new Scanner(System.in).nextLine();
        setMname(roleName + name);
        System.out.println(getMname() + "出撃します！");
        this.liveFlag = true;
    }

    public void attackSelect(Monster[] monsters) {
        if(this.liveFlag == true) {
            System.out.println(this.mName + "の攻撃！");
            System.out.println("攻撃対象を選ぶのじゃ！");
            for(int i = 0; i < monsters.length; i++) {
                System.out.println( i + 1 +"." + monsters[i].getMname());
            }
            System.out.println("該当の数字を入力せい～");
            int monsterChoice = new Scanner(System.in).nextInt();
            boolean flag1,flag2; 
            while(true) {
                flag1 = false;
                flag2 = false;
                if(monsterChoice > monsters.length || monsterChoice <= 0) {
                    System.out.println("誰を攻撃しようとしてるんじゃ！\r\n対象のモンスターを選択せい～");
                    monsterChoice = new Scanner(System.in).nextInt();
                    continue;
                }else {
                    flag1 = true;
                }
                if(!monsters[monsterChoice - 1].getLiveFlag()) {
                    System.out.println("そいつはもう死んでるぞ・・\r\nもう一度選択せい～"); 
                    monsterChoice = new Scanner(System.in).nextInt();
                    continue;
                } else {
                    flag2 = true;
                }
                if(flag1 && flag2){
                    break;
                }
            }
            monsterChoice--;
            this.attackTrigger(monsters[monsterChoice]);
        }        
    }

    public void attackTrigger(Monster monster) {
        int n = new Random().nextInt(100);
        if(n < this.critPer) {
            critAttack(monster);
        } else {
            normalAttack(monster);
        }
    }

    public void normalAttack(Monster monster) {
        monster.setMhp(monster.getMhp() - mAtk);
        System.out.println(mName + "は攻撃した" );
        System.out.println(monster.getMname() + "に" + mAtk + "ダメージ！");
        monster.judgeMhp();
    }
    public void critAttack(Monster monster) {
        monster.setMhp(monster.getMhp() - mAtk * 3 / 2);
        System.out.println(mName + "は攻撃した" );
        System.out.println( "会心の一撃" );
        System.out.println(monster.getMname() + "に" + mAtk * 3 / 2 + "ダメージ！！！");
        monster.judgeMhp();
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