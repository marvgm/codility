import java.io.IOException;
import java.util.*;

public class Lotomania {

    public static final int NU_CONCURSO_INICIAL = 2193;
    public static final int NU_CONCURSO_FINAL = 2196;
    public static Map<Integer, Integer[]> sorteados = new HashMap<>();

    public static Integer[] jogo_sua_2193_2196= {0, 1, 9, 25, 41, 51, 67, 75, 88, 97, 2, 11, 35, 42, 52, 68, 79, 89, 3, 12, 36, 43, 54, 69, 83, 92, 5, 13, 37, 45, 55, 70, 84, 93, 6, 19, 38, 46, 60, 73, 86, 95, 7, 23, 39, 48, 66, 74, 87, 96};
    public static Integer[] jogo_sub_2193_2196= {2, 10, 4, 11, 35, 45, 61, 72, 86, 37, 46, 62, 73, 88, 99, 5, 14, 29, 40, 49, 63, 77, 91, 7, 16, 31, 41, 57, 65, 79, 94, 8, 20, 32, 42, 58, 68, 80, 95, 9, 23, 34, 43, 59, 71, 81, 96, 25, 27};
    public static Integer[] jogo_esa_2193_2196 = {4, 17, 26, 32, 49, 59, 71, 81, 98, 8, 18, 27, 33, 50, 61, 72, 82, 99, 10, 20, 28, 34, 53, 62, 76, 85, 14, 21, 29, 40, 56, 63, 77, 90, 15, 22, 30, 44, 57, 64, 78, 91, 16, 24, 31, 47, 58, 65, 80, 94};
    public static Integer[] jogo_esb_2193_2196 = {1, 17, 26, 39, 52, 64, 75, 85, 98, 3, 18, 28, 44, 53, 66, 76, 87, 99, 6, 19, 30, 47, 54, 67, 78, 89, 12, 21, 33, 48, 55, 69, 82, 90, 13, 22, 36, 50, 56, 70, 83, 92, 15, 24, 38, 51, 60, 74, 84, 93};

    public static void main(String[] args) throws IOException {

        //sorteados por concurso : acessar https://www.xloterias.com.br/lotomania/
        Integer[] sorteio2196 = {9, 13, 16, 22, 23, 31, 37, 38, 42, 51, 57, 60, 62, 63, 67, 70, 85, 90, 92, 93};
        Integer[] sorteio2195 = {6, 18, 19, 23, 31, 40, 51, 53, 54, 64, 69, 74, 79, 84, 88, 92, 95, 96, 97, 99};
        Integer[] sorteio2194 = {7, 10,14, 24, 28, 32, 33, 36, 40, 53, 56, 60, 68, 73, 79, 80, 81, 93, 95, 98};
        Integer[] sorteio2193 = {2, 4, 7, 12, 17, 19, 33, 40, 43, 44, 46, 48, 52, 63, 67, 71, 72, 85, 95, 96};

        addSorteados(2196 , sorteio2196);
        addSorteados(2195 , sorteio2195);
        addSorteados(2194 , sorteio2194);
        addSorteados(2193 , sorteio2193);

        System.out.println(compare());
    }

    public static void addSorteados(int concurso, Integer[] numeros){
        sorteados.put(concurso , numeros);
    }

    public static Integer[] pegaNumerosSorteadosPorConcurso(Integer concurso){
        return sorteados.get(concurso);
    }

    public static String compare(){
        int totalResultado = 0;
        int nuConcurso = NU_CONCURSO_INICIAL;
        StringBuilder resultado = new StringBuilder();
        String mensagem = "Concurso %s - %d teve %d acertos - %s\n";

        while (nuConcurso <= NU_CONCURSO_FINAL) {
            Integer[] sorteado = pegaNumerosSorteadosPorConcurso(nuConcurso);

            if (sorteado != null){
                totalResultado = getTotalAcertos(jogo_sua_2193_2196, sorteado);
                resultado.append(String.format(mensagem ,"su_a", nuConcurso, totalResultado, getApuracao(totalResultado)));
                totalResultado = getTotalAcertos(jogo_sub_2193_2196, sorteado);
                resultado.append(String.format(mensagem ,"su_b", nuConcurso, totalResultado, getApuracao(totalResultado)));
                totalResultado = getTotalAcertos(jogo_esa_2193_2196, sorteado);
                resultado.append(String.format(mensagem ,"es_a", nuConcurso, totalResultado, getApuracao(totalResultado)));
                totalResultado = getTotalAcertos(jogo_esb_2193_2196, sorteado);
                resultado.append(String.format(mensagem ,"es_b", nuConcurso, totalResultado, getApuracao(totalResultado)));
            }

            nuConcurso++;
        }

        return resultado.toString();
    }

    private static int getTotalAcertos(Integer[] jogo , Integer[] sorteado) {
        int totalAcertos = 0;

        for (int i = 0; i < jogo.length; i++) {
            if (Arrays.binarySearch(sorteado, jogo[i]) >= 0) {
                totalAcertos++;
            }
        }
        return totalAcertos;
    }

    private static String getApuracao(int totalAcertos) {
        if (totalAcertos >=15 || totalAcertos == 0){
            return "ganhou!";
        }
        return "Nenhum premio!";
    }

}
