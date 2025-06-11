package Tree;

public class TEMP extends Exp1 {
  public Temp.Temp temp;
  public TEMP(Temp.Temp t) {temp=t;}
  public ExpList kids() {return null;}
  public Exp1 build(ExpList kids) {return this;}
}

