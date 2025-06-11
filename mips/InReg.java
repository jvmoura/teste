package mips;
import Frame.*;
import Temp.Temp;

public class InReg extends Access {
    Temp temp;
    InReg(Temp t) {
	temp = t;
    }

    public Tree.Exp1 exp(Tree.Exp1 fp) {
        return new Tree.TEMP(temp);
    }

    public String toString() {
        return temp.toString();
    }
}
