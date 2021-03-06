
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Luca
 */

public class Estado {

    private String nome;
    private String[] transicoes;
    private boolean boolInicial = false;
    private boolean boolFinal = false;
    private boolean boolAlcancavel = false;

    public Estado(String nome, int y) {
        this.nome = nome;
        this.transicoes = new String[y];
    }
    public String getNome() {
        return nome;
    }
    public String[] getTransicoes() {
        return transicoes;
    }
    /*Adiciona transicao ao estado, Argumentos(String com de qual estado a tal separado por virgula
        Exemplo "q0,q1" de q0 a q1, int de qual posição da linguagem é feita a transição, exemplo 
        linguagem L=(a,b) transoção de q0 para q1 por b. ("q0,q1",1)*/
    public void addTransicoes(String transicao, int l) {
        int i = l - 1;

        if (transicoes[i] == null) { //se nao houver a transicao por aquele simbolo l do alfabeto
            transicoes[i] = ordena(transicao); //a transicao por o simbolo l recebe a entrada
        } else {
            transicoes[i] = unirTransicoes(transicoes[i], transicao);  
        }
    }
    public boolean isInicial() {
        return boolInicial;
    }
    public boolean isFinal() {
        return boolFinal;
    }
    public boolean isAlc() {
	    return boolAlcancavel;
	}
	public void setNome(String nome) {
        this.nome = nome;
    }
    public void setInicial() {
        this.boolInicial = true;
    }
    public void setFinal() {
        this.boolFinal = true;
    }
    public void setAlc() {
	    boolAlcancavel = true;
	}
    /*Retorna string de nome de Estado ordenada, Argumentos(String transição a ser ordenada), Exemplo:
    Entra "q3q1q2" retorna "q1q2q3"*/
	public static String ordena(String transicao) {
        String[] lista = transicao.split(",");
        Arrays.sort(lista);
        String ordenada = lista[0];
        for (int i = 1; i < lista.length; i++) {
            ordenada = ordenada + "," + lista[i];
        }
        return ordenada;
    }
    public static String unirTransicoes(String a, String b) {
        String[] A;
        String[] B;
        String[] C;

        if (a != null) {
            A = a.split(",");
        } else {
            A = new String[0];
        }

        if (b != null) {
            B = b.split(",");
        } else {
            B = new String[0];
        }

        C = new String[A.length + B.length];

        int k = 0;

        for (int i = 0; i < A.length; i++, k++) {
            C[k] = A[i];
        }
        for (int i = 0; i < B.length; i++, k++) {
            C[k] = B[i];
        }

        Arrays.sort(C);
        String ret = C[0];

        for (int i = 1; i < C.length; i++) {
            if (!C[i].equals(C[i - 1])) {
                ret = ret + "," + C[i];
            }

        }
        return ret;

    }

}//
