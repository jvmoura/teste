package Tree;
import Temp.*;

public class JUMP extends Stm {
  public Exp1 exp;
  public LabelList targets;
  public JUMP(Exp1 e, LabelList t) {exp=e; targets=t;}
  public JUMP(Label target) {
      this(new NAME(target), new LabelList(target,null));
  }
  public ExpList kids() {return new ExpList(exp,null);}
  public Stm build(ExpList kids) {
    return new JUMP(kids.head,targets);
  }
}

