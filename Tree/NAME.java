package Tree;
import Temp.Temp;
import Temp.Label;
public class NAME extends Exp1 {
  public Label label;
  public NAME(Label l) {label=l;}
  public ExpList kids() {return null;}
  public Exp1 build(ExpList kids) {return this;}
}

