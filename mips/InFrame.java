package mips;
import Frame.*;

public class InFrame extends Access {
    int offset;
    InFrame(int o) {
	offset = o;
    }

    public Tree.Exp1 exp(Tree.Exp1 fp) {
        return new Tree.MEM
	    (new Tree.BINOP(Tree.BINOP.PLUS, fp, new Tree.CONST(offset)));
    }

    public String toString() {
        Integer offset = new Integer(this.offset);
	return offset.toString();
    }
}
