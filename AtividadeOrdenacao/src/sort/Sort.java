package sort;

public class Sort {

// Neste método a classificação é efetivada por seleção sucessiva do menor valor
// de chave contido no vetor "A".
// A cada passo é feita uma varredura do segmento do vetor com os elementos
// ainda não selecionados e determinado aquele elemento de menor valor, o qual é
// colocado, por troca, em sua posição definitiva no vetor classificado e o processo
// repetido para o segmento que contém os elementos ainda não selecionados.
public static void SelectionSort(String[] vet) {
        for (int i = 0; i < vet.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < vet.length; j++) {
                //se o próximo for menor que o atual
                if (vet[j].length() < vet[index].length()) {
                    index = j;
                }
            }
             //se o próximo for menor que o atual index recebe o próximo e vai pro valor atual
             // e o atual recebe o valor do próximo
            String smallerNumber = vet[index];
            vet[index] = vet[i];
            vet[i] = smallerNumber;
    
        }
    }

    // O BubbleSort troca repetidamente elementos adjacentes que não estão em ordem até que toda lista de itens
    // esteja em sequência. Dessa maneira, os itens flutuam na lista conforme os seus valores, indo do maior (no caso 
    // de ordenação crescente) pro final ao fim de cada iteração.
    public static void BubbleSort(String[] B) {

        String aux = "";

        for (int i = 0; i < B.length; i++) {

            for (int j = 0; j < B.length - 1; j++) {
                // se o atual for maior que o próximo atual recebe o valor do próximo
                if (B[j].length() > B[j + 1].length()) {
                    
                    aux = B[j];
                    // atual pega o valor do próximo
                    B[j] = B[j + 1];
                    // próximo recebe o valor do atual
                    B[j + 1] = aux;

                }

            }

        }

    }
    
    // O InsertionSort varre a lista repetidamente e, a cada vez, insere um item da sequência desordenada na posição correta.
    // lembra o BubbleSort só que em vez de olhar o da frente olha o de trás
    public static void InsertionSort(String[] C) {

        String aux;

        for (int i = 0; i < C.length; ++i) {

            int j = i;
            // lembra o BubbleSort só que em vez de olhar o da frente olha o de trás e troca
            while (j > 0 && C[j - 1].length() > C[j].length()) {

                aux = C[j];
                C[j] = C[j - 1];
                C[j - 1] = aux;
                j = j - 1;

            }
        }

    }
    
    // O MergeSort realiza a ordenação dividindo uma sequência de elementos em sequencias menores recursivamente,
    // que serão ordenadas e depois serão combinados de forma ordenada.
    public static void mergeSort(String[] a, int from, int to) {
        if (from == to) {

            return;
        }

        int mid = (from + to) / 2;

        // sort the first and the second half
        mergeSort(a, from, mid);
        mergeSort(a, mid + 1, to);
        merge(a, from, mid, to);

    }// end mergeSort
//work

    public static void merge(String[] a, int from, int mid, int to) {
        int n = to - from + 1;       // size of the range to be merged
        String[] b = new String[n];   // merge both halves into a temporary array b
        int i1 = from;               // next element to consider in the first range
        int i2 = mid + 1;            // next element to consider in the second range
        int j = 0;                   // next open position in b

        // as long as neither i1 nor i2 past the end, move the smaller into b
        while (i1 <= mid && i2 <= to) {

            if (a[i1].length() <= a[i2].length()) {

                b[j] = a[i1];
                i1++;

            } else {

                b[j] = a[i2];
                i2++;
            }

            j++;
        }

        // note that only one of the two while loops below is executed
        // copy any remaining entries of the first half
        while (i1 <= mid) {

            b[j] = a[i1];
            i1++;
            j++;

        }

        // copy any remaining entries of the second half
        while (i2 <= to) {

            b[j] = a[i2];
            i2++;
            j++;

        }

        // copy back from the temporary array
        for (j = 0; j < n; j++) {

            a[from + j] = b[j];

        }

    }//end merge

    public static int partition(String a[], int start, int end) {
        String pivot = a[end]; // pivot element  
        int i = (start - 1);

        for (int j = start; j <= end - 1; j++) {
            // If current element is smaller than the pivot  
            if (a[j].length() < pivot.length()) {
                i++; // increment index of smaller element  
                String t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        String t = a[i + 1];
        a[i + 1] = a[end];
        a[end] = t;
        return (i + 1);
    }

    // O QuickSort trabalha com o princípio da divisão-e-conquista. Primeiramente, ela divide a lista de itens em duas 
    // sub-listas com base em um elemento pivô. Todos os elementos na primeira sub-lista são dispostos de maneira que 
    // sejam menores do que o pivô, enquanto que todos os elementos na segunda sub-lista são dispostos para serem 
    // maiores que o pivô. O mesmo processo de particionamento e organização é executado repetidamente nas sub-listas
    // resultantes até que toda a lista seja organizada.
//   public static void quick(String a[], int start, int end) /* a[] = array to be sorted, start = Starting index, end = Ending index */ {

//        if (start < end) { //p is the partitioning index

//            String p = String.valueOf(partition(a, start, end));  //p is the partitioning index  
//            quick(a, start, p.length() - 1);
//            quick(a, p.length() + 1, end);

//        }
//    }

    // O QuickSort trabalha com o princípio da divisão-e-conquista. Primeiramente, ela divide a lista de itens em duas 
    // sub-listas com base em um elemento pivô. Todos os elementos na primeira sub-lista são dispostos de maneira que 
    // sejam menores do que o pivô, enquanto que todos os elementos na segunda sub-lista são dispostos para serem 
    // maiores que o pivô. O mesmo processo de particionamento e organização é executado repetidamente nas sub-listas
    // resultantes até que toda a lista seja organizada.
    public static void quickSort(String v[], int esquerda, int direita) {
        int esq = esquerda; //inicio do vetor 
        int dir = direita; //fim do vetor = tamanho do vetor
        int pivo = v[(esq + dir) / 2].length();
        String troca;

        while (esq <= dir) {
            while (v[esq].length() < pivo) {
                esq = esq + 1;
            }
            while (v[dir].length() > pivo) {
                dir = dir - 1;
            }
            if (esq <= dir) {
                troca = v[esq];
                v[esq] = v[dir];
                v[dir] = troca;
                esq = esq + 1;
                dir = dir - 1;
            }
        }
        if (dir > esquerda) {
            quickSort(v, esquerda, dir);
        }

        if (esq < direita) {
            quickSort(v, esq, direita);
        }

    }
}
