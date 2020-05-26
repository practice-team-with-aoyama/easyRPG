import java.util.*;

public interface Human {
    public void attackSelect(Monster[] monsters);
    public void attackTrigger(Monster monster);
    public void normalAttack(Monster monster);
    public void critAttack(Monster monster);
    public int getMhp();
    public void setMhp(int hp);
    public String getMname();
    public void setMname(String name);
    public void judgeMhp();
    public boolean getLiveFlag();
}
