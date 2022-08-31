package sort;

public class Sort {

    public static void BubbleSort(String[] B) {

        String aux = "";

        for (int i = 0; i < B.length; i++) {

            for (int j = 0; j < B.length - 1; j++) {

                if (B[j].length() > B[j + 1].length()) {

                    aux = B[j];
                    B[j] = B[j + 1];
                    B[j + 1] = aux;

                }

            }

        }

    }

    public static void InsertionSort(String[] C) {

        String aux;

        for (int i = 0; i < C.length; ++i) {

            int j = i;

            while (j > 0 && C[j - 1].length() > C[j].length()) {

                aux = C[j];
                C[j] = C[j - 1];
                C[j - 1] = aux;
                j = j - 1;

            }
        }

    }

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

    /* function to implement quick sort */
    public static void quick(String a[], int start, int end) /* a[] = array to be sorted, start = Starting index, end = Ending index */ {

        if (start < end) { //p is the partitioning index

            String p = String.valueOf(partition(a, start, end));  //p is the partitioning index  
            quick(a, start, p.length() - 1);
            quick(a, p.length() + 1, end);

        }
    }

}
