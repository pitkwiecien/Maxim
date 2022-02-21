package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[][] b = {{24, 14, 54}, {57, 90}, {18, 35, 65}};
        System.out.println(arrayToString(b));

        int[] a = {64, 42, 73, 41, 32, 53, 16, 24, 57, 42, 74, 55, 36};
        System.out.println(arrayToString(a));

        int [] linSearchAlgArray = new int[] {64, 42, 73, 41, 32, 53, 16, 24, 57, 42, 74, 55, 36};
        System.out.println(searchLinear(linSearchAlgArray, 42));

        int [] minAlgArray = new int[] {64, 42, 73, 41, 32, 53, 16, 24, 57, 42, 74, 55, 36};
        System.out.println(min(minAlgArray, 0, minAlgArray.length));

        int[] selectionSortAlgArray = new int[] {64, 42, 73, 41, 32, 53, 16, 24, 57, 42, 74, 55, 36};
        selectionSort(selectionSortAlgArray);
        System.out.println(arrayToString(selectionSortAlgArray));

        int[] bubbleSortAlgArray = new int[] {64, 42, 73, 41, 32, 53, 16, 24, 57, 42, 74, 55, 36};
        bubbleSort(bubbleSortAlgArray);
        System.out.println(arrayToString(bubbleSortAlgArray));

        ArrayList<File> fileList = new ArrayList<>();
        getFiles(new File("S:\\JavaScript"), fileList, "zip ");
        printFiles(fileList);
    }

    private static String arrayToString(int[][] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        for (int[] elem: array){
            sb.append("\t").append(arrayToString(elem)).append("\n");
        }
        sb.append("]");
        return sb.toString();
    }

    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int elem: array) {
            sb.append(elem).append(", ");
        }
        sb.replace(sb.length()-2, sb.length(), "");
        sb.append("]");
        System.out.println(sb);
        return sb.toString();
    }

    public static int searchLinear(int[] array, int elementToFind) {
        for (int i = 0; i < array.length; i++){
            if(array[i] == elementToFind){
                return i;
            }
        }
        return -1;
    }

    private static int min(int[] array, int start, int end) {
        int smallest = start;
        for (int i = start + 1; i < end; i++){
            if (array[i] < array[smallest]){
                smallest = i;
            }
        }
        return smallest;
    }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++){
            int minimal = min(array, i, array.length);
            swap(array, minimal, i);
        }
    }

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if(array[i] > array[j]){
                    swap(array, i, j);
                }
            }
        }
    }

    private static void swap(int[] array, int firstIndex, int secondIndex){
        final int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    private static void getFiles(File rootFile, List<File> fileList, String extension) {
        if (rootFile.isDirectory()) {
            File[] directoryFiles = rootFile.listFiles();
            if (directoryFiles != null) {
                for (File file: directoryFiles) {
                    if (file.isDirectory()) {
                        getFiles(file, fileList, extension);
                    } else {
                        if (file.getName().toLowerCase().endsWith(extension)) {
                            fileList.add(file);
                        }
                    }
                }
            }
        } else {
            fileList.add(rootFile);
        }
    }

    private static void printFiles(List<File> fileList){
        for (File i: fileList){
            System.out.println("-" + i);
        }
    }

    public static int searchBinaryRecursive(int[] array, int startIndex, int endIndex, int elementToFind) {
        if (endIndex >= startIndex) {
            int middleIndex = startIndex + (endIndex - startIndex) / 2;

            if (array[middleIndex] == elementToFind) {
                return middleIndex;
            }

            if (array[middleIndex] > elementToFind) {
                return searchBinaryRecursive(array, startIndex, middleIndex - 1, elementToFind);
            } else {
                return searchBinaryRecursive(array, middleIndex + 1, endIndex, elementToFind);
            }
        }

        return -1;
    }

}