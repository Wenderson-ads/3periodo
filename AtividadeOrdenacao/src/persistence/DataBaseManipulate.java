package persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class DataBaseManipulate {

    public String nameFile1 = "English_American_dic.txt";
    public String nameFile2 = "Portuguese_Brazilian_dic.txt";
    public String nameFile3 = "English(Canadian).txt";

    public String[] ObterDicPortugues() throws Exception {

        try (BufferedReader br = new BufferedReader(new FileReader(nameFile2))) {

            String vet = br.readLine();
            int tamanhoVetor = Integer.parseInt(vet) - 1;
            String[] vetor = new String[tamanhoVetor];
            String linha = "";

            while ((linha = br.readLine()) != null) {

                for (int i = 0; i < vetor.length; i++) {

                    vetor[i] = br.readLine();

                }

            }
            return vetor;

        }

    }

    public String[] ObterDicEnglish() throws Exception {

        try (BufferedReader br = new BufferedReader(new FileReader(nameFile1))) {

            String vet = br.readLine();
            int tamanhoVetor = Integer.parseInt(vet) - 1;
            String[] vetor = new String[tamanhoVetor];
            String linha = "";

            while ((linha = br.readLine()) != null) {

                for (int o = 0; o < vetor.length; o++) {

                    vetor[o] = br.readLine();
                   

                }
            }
            return vetor;
        }

    }

    public String[] ObterDicEnglishCanadian() throws Exception {

        try (BufferedReader br = new BufferedReader(new FileReader(nameFile3))) {

            String vet = br.readLine();
            int tamanhovetor = Integer.parseInt(vet) - 1;
            String[] vetor = new String[tamanhovetor];
            String linha = "";

            while ((linha = br.readLine()) != null) {

                for (int t = 0; t < vetor.length; t++) {

                    vetor[t] = br.readLine();

                }

            }

            return vetor;
        }

    }
}
