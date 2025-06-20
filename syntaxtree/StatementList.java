package syntaxtree;

import java.util.Vector;

public class StatementList {
   private Vector list;

   public StatementList() {
      list = new Vector();
   }

   public void addElement(Statement n) {
      list.addElement(n);
   }

   public Statement elementAt(int i)  { 
      return (Statement)list.elementAt(i); 
   }

   public int size() { 
      return list.size(); 
   }
}
