package Tree;
import Temp.Temp;
import Temp.Label;
public class MEM extends Exp1 {
  public Exp1 exp;
  public MEM(Exp1 e) {exp=e;}
  public ExpList kids() {return new ExpList(exp,null);}
  public Exp1 build(ExpList kids) {
    return new MEM(kids.head);
  }
}

