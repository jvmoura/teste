package Tree;
import java.util.List;

public class CALL extends Exp1 {
    public Exp1 func;
    public ExpList args;

    public CALL(Exp1 f, ExpList a) {
        func = f;
        args = a;
    }

    public CALL(Exp1 f, List<Exp1> a) {
        if (a == null || a.isEmpty())
            return;

        func = f;
        args = new ExpList(a);
    }

    public ExpList kids() {
        return new ExpList(func, args);
    }

    public Exp1 build(ExpList kids) {
        return new CALL(kids.head, kids.tail);
    }

}

