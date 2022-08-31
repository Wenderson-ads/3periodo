/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence;

/**
 *
 * @author aster
 */
public class Buscas {

    public static boolean buscaSequencial(String palavraBusca, String[] listaPalavras) {
        for (String listaPalavra : listaPalavras) {
            if (listaPalavra.equals(palavraBusca)) {
                //    * achou
                return true;
            }
        }
        return false;
    }

    private static boolean binarySearch(String[] vet, String palavraBuscada, int low, int high) {
        if (low > high) {
            return false;
        }

        int mid = (low + high) / 2;

        if (vet[mid].compareTo(palavraBuscada) < 0) {
            return binarySearch(vet, palavraBuscada, mid + 1, high);
        } else if (vet[mid].compareTo(palavraBuscada) > 0) {
            return binarySearch(vet, palavraBuscada, low, mid - 1);
        } else {
            return true;
        }
    }

    private static int binarySearch(String[] vet, int quantidadeDeLetrasDaPalavra, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;

        if (vet[mid].length() - quantidadeDeLetrasDaPalavra < 0) {
            return binarySearch(vet, quantidadeDeLetrasDaPalavra, mid + 1, high);
        } else if (vet[mid].length() - quantidadeDeLetrasDaPalavra > 0) {
            int tamanho = vet[mid].length();
            return binarySearch(vet, quantidadeDeLetrasDaPalavra, low, mid - 1);
        } else {
            return mid;
        }
    }

    public static boolean buscaBinaria(String palavraBusca, String[] listaPalavras) {
        int indice = binarySearch(listaPalavras, palavraBusca.length(), 0, listaPalavras.length);
        int i = indice - 1;
        int j = indice + 1;
        int hashBusca = palavraBusca.hashCode();
        while (i > 0 && listaPalavras[i].length() == palavraBusca.length()) {// * fazendo busca sequencial a partir do indice encontrado
            System.out.println(listaPalavras[i]);
            if (listaPalavras[i].hashCode() == hashBusca) {//   *encontrou
                if (listaPalavras[i].equals(palavraBusca)) {//  * conferindo se encontrou mesmo
                    return true;
                }
            }
            i--;
        }
        while (j < listaPalavras.length && listaPalavras[j].length() == palavraBusca.length()) {// * fazendo busca sequencial a partir do indice encontrado
            if (listaPalavras[j].hashCode() == hashBusca) {//   *encontrou
                if (listaPalavras[j].equals(palavraBusca)) {//  * conferindo se encontrou mesmo
                    return true;
                }
            }
            j++;
        }
        return false;
    }
//    public static boolean buscaBinaria(String palavraBusca, String[] listaPalavras, boolean jaOrdenado) {
//        if (jaOrdenado) {
//            return binarySearch(listaPalavras, palavraBusca, 0, listaPalavras.length);
//        } else {//  * lista não ordenada
//            List<String> lista = new ArrayList<>();
//            lista.addAll(Arrays.asList(listaPalavras));
//            lista = lista.stream().filter(x -> x.length() == palavraBusca.length()).sorted((o1, o2) -> o1.compareTo(o2)).toList();
//            listaPalavras = lista.toArray(listaPalavras);
//            return buscaBinaria(palavraBusca, listaPalavras, true);
//        }
//    }

}
