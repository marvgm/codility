import java.util.HashMap;
import java.util.Map;

public class RearangeDigits {

    /* Criar uma função que recebe um numero inteiro e retorna o numero de permutações que pode ser
    realizada com ele. Entretando resultados de permutações com zeros a esquerda devem ser descartados.
    Ex:
    N é o numero inteiro entre [0...10 elevado a 9]
    Para N=432 pode ter 6 permutações
    N=120 tem 4 pois dois resultados tem zereos a esquerda
    * */

    public static void main (String [] args){
        System.out.println(solution(432));
    }

    public static int solution(int n) {
        Map<Integer, Integer> permutacoes = new HashMap<>();

        Integer total = separarDigitos(n, permutacoes);

        Integer resultado;
        Integer[] valores;

        valores = permutacoes.values().toArray(new Integer[permutacoes.size()]);
        resultado = calcularPermutacaoComElementosRepetidos(total, valores);

        // Desconsiderar os zeros a esquerda
        if (permutacoes.containsKey(0)) {
            Double quantidadeDeZeros = Double.valueOf(permutacoes.get(0));
            Double quantidadeDeDigitos = Double.valueOf(total);
            Double provisorio = Double.valueOf(resultado);

            provisorio = provisorio - (provisorio / (quantidadeDeDigitos / quantidadeDeZeros));
            resultado = provisorio.intValue();
        }

        return resultado;
    }

    public static Integer calcularPermutacaoComElementosRepetidos(Integer total, Integer... combinacoes) {
        Long denominador = 1L;
        Long numerador;
        Long resultado;

        for (Integer combinacao : combinacoes) {
            if (combinacao > 1) {
                denominador = denominador * calculoDofatorial(combinacao);
            }
        }

        numerador = calculoDofatorial(total);
        resultado = numerador / denominador;

        return resultado.intValue();
    }

    private static Integer separarDigitos(int numero, Map<Integer, Integer> permutacoes) {
        Integer total = 0;

        while (numero != 0) {
            int digito = numero % 10;

            numero = numero / 10;

            if (permutacoes.containsKey(digito)) {
                permutacoes.put(digito, permutacoes.get(digito) + 1);
            } else {
                permutacoes.put(digito, 1);
            }

            total++;
        }

        return total;
    }

    private static Long calculoDofatorial(Integer numero) {
        Long resultado = 1L;

        for (int fator = 2; fator <= numero; fator++) {
            resultado = resultado * fator;
        }

        return resultado;
    }
}