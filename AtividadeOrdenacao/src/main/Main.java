package main;

import java.awt.BorderLayout;
import java.util.Random;
import persistence.Buscas;
import persistence.DataBaseManipulate;
import sort.Sort;

public class Main {

    public static void main(String[] args) throws Exception {

        DataBaseManipulate teste = new DataBaseManipulate();

        String[] vetorDicEnglish = teste.ObterDicEnglish();//pega os dicionários como vetor
        String[] vetorDicEnglishCanadian = teste.ObterDicEnglishCanadian();
        String[] vetorDicportuges = teste.ObterDicPortugues();

        long timeInicioOrdenacao = System.nanoTime();//pega o inicio do tempo com vetor desordenado

        //String[] vetMerge = vetorDicEnglish.clone(); //fazendo clone do dicionário sem ordenaçaõ
        String[] vetMerge = vetorDicportuges.clone(); //fazendo clone do dicionário sem ordenaçaõ
        //String[] vetQuick = vetorDicEnglish.clone();//fazendo clone do dicionário sem ordenaçaõ
        //String[] vetQuick = vetorDicportuges.clone();//fazendo clone do dicionário sem ordenaçaõ
        String[] vetBubble = vetorDicportuges.clone();//fazendo clone do dicionário sem ordenaçaõ
        //String[] vetBubble = vetorDicEnglish.clone();//fazendo clone do dicionário sem ordenaçaõ
        //String[] Insertion = vetorDicEnglish.clone();//fazendo clone do dicionário sem ordenaçaõ
        String[] Insertion = vetorDicportuges.clone();//fazendo clone do dicionário sem ordenaçaõ
        //String[] vetSelectionSort = vetorDicEnglish.clone();//fazendo clone do dicionário sem ordenaçaõ
        String[] vetSelectionSort = vetorDicportuges.clone();//fazendo clone do dicionário sem ordenaçaõ
        
       //Sort.mergeSort(vetMerge, 0, vetMerge.length - 1);//ordenando vetor pelo mergeSort
       //Sort.quick(vetQuick, 0, vetQuick.length - 1);// ordenando vetor pelo quickSort
       Sort.BubbleSort(vetBubble);//ordenando vetor pelo bubble
       //Sort.InsertionSort(Insertion);//ordenando vetor pelo InsertionSort
       //Sort.quickSort(vetQuick, 0, vetQuick.length - 1);
       //Sort.SelectionSort(vetSelectionSort);
       
        long timeFimOrdenacao = System.nanoTime();//pega o final do tempo com vetor ordenado

        //for (int i = 0; i < vetBubble.length; i++) {

            //System.out.println(vetBubble[i]);
       // }

        System.out.println("");

        //System.out.println("Tempo de execução MergeSort!" + "\t" + (timeFimOrdenacao - timeInicioOrdenacao));
        //System.out.println("Tempo de execução QuickSort!" + "\t" +(timeFimOrdenacao - timeInicioOrdenacao));
        System.out.println("Tempo de execução BubbleSort!" + "\t" + (timeFimOrdenacao - timeInicioOrdenacao));
        //System.out.println("Tempo de execução InsertionSort!"+ "\t" + (timeFimOrdenacao - timeInicioOrdenacao));

        /// Busca Binaria
        System.out.println("Busca Binária!");
        long timeInicoBuscaBinaria = System.nanoTime();
        System.out.println("" + Buscas.buscaBinaria("q", Insertion));
        long timeFimBuscaBinaria = System.nanoTime();
        System.out.println("Tempo de execução Busca Binária!" + "\t" + (timeFimBuscaBinaria - timeInicoBuscaBinaria));

        //// Busca Sequencial
        System.out.println("Busca Sequencial!");
        long timeInicoBuscaSequencial = System.nanoTime();
        System.out.println("" + Buscas.buscaSequencial("q", Insertion));
        long timeFimBuscaSequencial = System.nanoTime();
        System.out.println("Tempo de execução Busca Sequancial!" + "\t" + (timeFimBuscaSequencial - timeInicoBuscaSequencial));
    }

}
