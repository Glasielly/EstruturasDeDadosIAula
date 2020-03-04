/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturasdedadosiaula.Pilha;

/**
 *
 * @author Glasielly
 */
public class ValidaExpressoesAlgebricas {

    public static String validaParenteses(String expressao) {
        if (expressao.isEmpty()) {
            return null;
        }
        PilhaGenericaComVetor<String> pg;
        pg = new PilhaGenericaComVetor<>();
        for (int i = 0; i < expressao.length(); i++) {
            switch (expressao.charAt(i)) {
                case '(':
                    pg.empilha("(");
                    break;
                case ')':
                    if (pg.desempilha() == null) {
                        return "Faltou abertura";
                    }
                    break;
                default:
                    break;
            }
        }
        if (!pg.estaVazia()) {
            return "Faltou fechamento";
        }
        return "Expressão " + expressao + " válida!";
    }

    public static Integer validaExpressaoPosFixa(String expressao) {
        if (!expressao.isEmpty()) {
            PilhaGenericaComVetor<Integer> pg;
            pg = new PilhaGenericaComVetor<>();
            for (int i = 0; i < expressao.length(); i++) {
                char caracter = expressao.charAt(i);
                switch (caracter) {
                    case '+':
                        operacao(pg, caracter);
                        break;
                    case '-':
                        operacao(pg, caracter);
                        break;
                    case '/':
                        operacao(pg, caracter);
                        break;
                    case '*':
                        operacao(pg, caracter);
                        break;
                    case '^':
                        operacao(pg, caracter);
                        break;
                    default:
                        pg.empilha(Character.getNumericValue(caracter));
                        break;

                }
            }
            return pg.getTopo();
        }
        return null;
    }

    private static void operacao(PilhaGenericaComVetor<Integer> pg, char operacao) {
        Integer op1, op2;
        op1 = pg.desempilha();
        op2 = pg.desempilha();
        if (op1 != null && op2 != null) {
            switch (operacao) {
                case '+':
                    pg.empilha(op2+op1);
                    break;
                case '-':
                    pg.empilha(op2-op1);
                    break;
                case '/':
                    pg.empilha(op2/op1);
                    break;
                case '*':
                    pg.empilha(op2*op1);
                    break;
                case '^':
                    int potencia = 1;
                    for(int i=1; i<=op1; i++){
                        potencia*= op2;
                    }
                    pg.empilha(potencia);
                    break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(ValidaExpressoesAlgebricas.validaExpressaoPosFixa("35+42-/"));
    }

}
