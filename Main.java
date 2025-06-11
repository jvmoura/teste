import java.util.Arrays;
import java.util.List;

import mips.*;
import syntaxtree.*;
import visitor.*;
import table.*;

public class Main {
   public static void main(String[] args) {
        // Supondo que Symbol e MipsFrame estão acessíveis
        List<Boolean> formals = Arrays.asList(true, false, true, false, true); // true = escapa
        MipsFrame frame = new MipsFrame(Symbol.symbol("foo"), formals);

        // Teste de alocação de variáveis locais
        Frame.Access a1 = frame.allocLocal(true);  // Deve ser InFrame
        Frame.Access a2 = frame.allocLocal(false); // Deve ser InReg

        System.out.println("a1: " + a1.getClass().getSimpleName());
        System.out.println("a2: " + a2.getClass().getSimpleName());
    }
}