package Tree;
import Temp.Temp;
import Temp.Label;
public class CONST extends Exp1 {
  public int value;
  public CONST(int v) {value=v;}
  public ExpList kids() {return null;}
  public Exp1 build(ExpList kids) {return this;}
}

