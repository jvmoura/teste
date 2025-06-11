package syntaxtree;

import visitor.Visitor;
import visitor.TypeVisitor;

public class Div extends Exp {
    public Exp e1, e2;
    public Div(Exp e1, Exp e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public Type accept(TypeVisitor v) {
        return v.visit(this);
    }
}