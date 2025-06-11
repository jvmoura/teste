package Tree;
import Temp.Temp;
import Temp.Label;

public class EXP extends Stm {
  public Exp1 exp; 
  public EXP(Exp1 e) {exp=e;}
  public ExpList kids() {return new ExpList(exp,null);}
  public Stm build(ExpList kids) {
    return new EXP(kids.head);
  }
}

