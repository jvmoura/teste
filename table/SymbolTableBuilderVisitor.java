package table;

import syntaxtree.*;
import visitor.TypeVisitor;

public class SymbolTableBuilderVisitor implements TypeVisitor {
    private SymbolTable symbolTable;
    private ClassDescriptor currentClass;
    private MethodDescriptor currentMethod;

    public SymbolTableBuilderVisitor() {
        symbolTable = SymbolTable.getInstance();
        currentClass = null;
        currentMethod = null;
    }

    @Override
    public Type visit(Program n) {
        n.m.accept(this);
        for (int i = 0; i < n.cl.size(); i++) {
            n.cl.elementAt(i).accept(this);
        }
        return null;
    }

    @Override
    public Type visit(MainClass n) {
        String className = n.i1.toString();
        symbolTable.addClass(className, null);
        currentClass = symbolTable.getClass(className);

        // Adiciona o método main
        currentClass.addMethod("main", null);
        currentMethod = currentClass.getMethod("main");

        // Parâmetro String[] args
        currentMethod.addLocalVar(n.i2.toString(), new syntaxtree.IdentifierType("String[]"));

        // Corpo do main (se quiser processar)
        // n.s.accept(this);

        currentMethod = null;
        currentClass = null;
        return null;
    }

    @Override
    public Type visit(ClassDeclSimple n) {
        String className = n.i.toString();
        symbolTable.addClass(className, null);
        currentClass = symbolTable.getClass(className);

        // Variáveis de instância
        for (int i = 0; i < n.vl.size(); i++) {
            n.vl.elementAt(i).accept(this);
        }
        // Métodos
        for (int i = 0; i < n.ml.size(); i++) {
            n.ml.elementAt(i).accept(this);
        }
        currentClass = null;
        return null;
    }

    @Override
    public Type visit(ClassDeclExtends n) {
        String className = n.i.toString();
        String parentName = n.j.toString();
        symbolTable.addClass(className, parentName);
        currentClass = symbolTable.getClass(className);

        // Variáveis de instância
        for (int i = 0; i < n.vl.size(); i++) {
            n.vl.elementAt(i).accept(this);
        }
        // Métodos
        for (int i = 0; i < n.ml.size(); i++) {
            n.ml.elementAt(i).accept(this);
        }
        currentClass = null;
        return null;
    }

    @Override
    public Type visit(VarDecl n) {
        String varName = n.i.toString();
        Type varType = n.t;
        if (currentMethod != null) {
            currentMethod.addLocalVar(varName, varType);
        } else if (currentClass != null) {
            currentClass.addVar(varName, varType);
        }
        return null;
    }

    @Override
    public Type visit(MethodDecl n) {
        String methodName = n.i.toString();
        Type returnType = n.t;
        currentClass.addMethod(methodName, returnType);
        currentMethod = currentClass.getMethod(methodName);

        // Parâmetros
        for (int i = 0; i < n.fl.size(); i++) {
            n.fl.elementAt(i).accept(this);
        }
        // Variáveis locais
        for (int i = 0; i < n.vl.size(); i++) {
            n.vl.elementAt(i).accept(this);
        }
        currentMethod = null;
        return null;
    }

    @Override
    public Type visit(Formal n) {
        String paramName = n.i.toString();
        Type paramType = n.t;
        if (currentMethod != null) {
            currentMethod.addLocalVar(paramName, paramType);
        }
        return null;
    }

    @Override
    public Type visit(Div n) {
    n.e1.accept(this);
    n.e2.accept(this);
    return null;
    }

    // Os demais métodos podem retornar null
    @Override public Type visit(IntArrayType n) { return null; }
    @Override public Type visit(BooleanType n) { return null; }
    @Override public Type visit(IntegerType n) { return null; }
    @Override public Type visit(IdentifierType n) { return null; }
    @Override public Type visit(Block n) { return null; }
    @Override public Type visit(If n) { return null; }
    @Override public Type visit(While n) { return null; }
    @Override public Type visit(Print n) { return null; }
    @Override public Type visit(Assign n) { return null; }
    @Override public Type visit(ArrayAssign n) { return null; }
    @Override public Type visit(And n) { return null; }
    @Override public Type visit(LessThan n) { return null; }
    @Override public Type visit(Plus n) { return null; }
    @Override public Type visit(Minus n) { return null; }
    @Override public Type visit(Times n) { return null; }
    @Override public Type visit(ArrayLookup n) { return null; }
    @Override public Type visit(ArrayLength n) { return null; }
    @Override public Type visit(Call n) { return null; }
    @Override public Type visit(IntegerLiteral n) { return null; }
    @Override public Type visit(True n) { return null; }
    @Override public Type visit(False n) { return null; }
    @Override public Type visit(This n) { return null; }
    @Override public Type visit(NewArray n) { return null; }
    @Override public Type visit(NewObject n) { return null; }
    @Override public Type visit(Not n) { return null; }
    @Override public Type visit(Identifier n) { return null; }

    @Override
    public Type visit(IdentifierExp n) {
        return null;
    }
}