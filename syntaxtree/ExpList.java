package syntaxtree;

import java.util.Vector;

public class ExpList {
   private Vector list;

   public ExpList() {
      list = new Vector();
   }

   public void addElement(Exp n) {
      list.addElement(n);
   }

   public Exp elementAt(int i)  { 
      return (Exp)list.elementAt(i); 
   }

   public int size() { 
      return list.size(); 
   }
}
