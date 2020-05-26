import java.util.*;

public interface Monster {

    public void attackTrigger(Human human);
    public void normalAttack(Human human);
    public void critAttack(Human human);
    public int getMhp();
    public void setMhp(int hp);
    public String getMname();
    public void setMname(String name);
    public void judgeMhp();
    public boolean getLiveFlag();
}