import java.io.IOException;
import java.util.*;

public class Lotomania {

    public static Map<Integer, Integer[]> sorteados = new HashMap<>();
    public static Integer[] jogo_su_2112_2119 = {5,7,10,12,13,14,15,17,18,26,30,31,32,34,39,40,42,43,44,46,48,49,53,54,56,57,59,60,61,66,67,68,69,72,73,74,75,77,78,80,84,88,89,93,94,96,97,98,99,0};
    public static Integer[] jogo_es_2112_2119 = {1,2,3,4,6,8,9,11,16,19,20,21,22,23,24,25,27,28,29,33,35,36,37,38,41,45,47,50,51,52,55,58,62,63,64,65,70,71,76,79,81,82,83,85,86,87,90,91,92,95};

    public static void main(String[] args) throws IOException {

        //sorteados por concurso : acessar https://www.xloterias.com.br/lotomania/
        Integer[] sorteio2119 = {1, 4, 7, 9, 12, 13, 19, 23, 32, 33, 43, 44, 48, 64, 78, 79, 82, 88, 89, 91};
        Integer[] sorteio2118 = {2, 10, 12, 16, 19, 46, 51, 52, 57, 64, 71, 72, 75, 80, 81, 82, 84, 88, 99, 0};
        Integer[] sorteio2117 = {5, 22, 30, 34, 35, 39, 44, 49, 55, 58, 68, 75, 76, 78, 84, 85, 88, 94, 95, 96};
        Integer[] sorteio2116 = {2, 5 ,7, 14, 20, 23, 39, 44, 48, 50, 63, 64, 78, 80, 81, 82, 83, 90, 94, 0};
        Integer[] sorteio2115 = {4, 7, 8, 11, 15, 17, 19, 20, 24, 32, 36, 41, 43, 44, 46, 48, 60, 76, 78, 86};
        Integer[] sorteio2114 = {4, 5, 10, 13,23, 24, 25, 29, 37, 40, 43, 44, 46, 49, 54, 56, 65, 93, 98, 99};
        Integer[] sorteio2113 = {9, 14, 20, 25, 26, 33, 35, 36, 49, 50, 55, 58, 59, 66, 71, 75, 76, 87, 94, 99};
        Integer[] sorteio2112 = {4, 17, 23, 25, 31, 36, 38, 40, 42, 52, 56, 59, 71, 78, 82, 83, 84, 92, 97, 98};

        addSorteados(2119 , sorteio2119);
        addSorteados(2118 , sorteio2118);
        addSorteados(2117 , sorteio2117);
        addSorteados(2116 , sorteio2116);
        addSorteados(2115 , sorteio2115);
        addSorteados(2114 , sorteio2114);
        addSorteados(2113 , sorteio2113);
        addSorteados(2112 , sorteio2112);

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
        int nuConcurso = 2112;
        StringBuilder resultado = new StringBuilder();
        String mensagem = "Concurso %s - %d teve %d acertos - %s\n";

        while (nuConcurso <= 2119) {
            Integer[] sorteado = pegaNumerosSorteadosPorConcurso(nuConcurso);

            if (sorteado != null){
                totalResultado = getTotalAcertos(jogo_su_2112_2119, sorteado);
                resultado.append(String.format(mensagem ,"su", nuConcurso, totalResultado, getApuracao(totalResultado)));
                totalResultado = getTotalAcertos(jogo_es_2112_2119, sorteado);
                resultado.append(String.format(mensagem ,"es", nuConcurso, totalResultado, getApuracao(totalResultado)));
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
