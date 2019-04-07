package com.dobau.hackerRank.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class MatrixLayerRotation {

    // Complete the matrixRotation function below.
    static void matrixRotation(List<List<Integer>> matrix, int r) {
        for (int i = 0; i < matrix.size();i++) {
            for (int j = 0; j < matrix.get(i).size();j++) {
                System.out.printf("%d ", matrix.get(i).get(j));
            }

            System.out.println();
        }

        System.out.println();
        System.out.println();
        System.out.println();


        List<List<Integer>> rows = new ArrayList<>(matrix.size() / 2);

        // primeira linha
        rows.add(new ArrayList<>());
        rows.get(i).addAll(matrix.get(i).subList(deep, matrix.get(i).size() - deep));

        // coluna direita
        int deep = 0;
        for (int i = 0; i < matrix.size() / 2; i++) {
            if (rows.size() <= i) {
                rows.add(new ArrayList<>());
            }

            rows.get(i).addAll(matrix.get(i).subList(deep, matrix.get(i).size() - deep));
        }

        // ultima linha
        int middle = (int) Math.ceil(matrix.size() / 2);
        for (int i = matrix.size() - 1; i >= middle ; i--) {
            List<Integer> subList = matrix.get(i).subList(deep, matrix.get(i).size() - deep);
            subList.sort(Comparator.reverseOrder());
            rows.get(matrix.size() - i - middle).addAll(subList);
        }

        // coluna esquerda
        int deep = 0;
        for (int i = 0; i < matrix.size() / 2; i++) {
            if (rows.size() <= i) {
                rows.add(new ArrayList<>());
            }

            rows.get(i).addAll(matrix.get(i).subList(deep, matrix.get(i).size() - deep));
        }

//            for (int b = 0; b < deep;b++) {
//                rows.get(b).add(matrix.get(i).get(matrix.get(i).size() - b));
//            }
//
//            rows.get(i).addAll(matrix.get(i).subList(deep, matrix.get(i).size() - deep));
//
//            for (int b = 0; b < deep;b++) {
//                rows.get(b).add(matrix.get(i).get(b));
//            }

//            deep++;
//            if (i + 1 < Math.ceil(matrix.get(i).size() / 2)) {
//
//            } else if (i + 1 > Math.ceil(matrix.get(i).size() / 2)) {
//                deep--;
//            }
//        }

        System.out.println(rows);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] mnr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(mnr[0]);

        int n = Integer.parseInt(mnr[1]);

        int r = Integer.parseInt(mnr[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                matrix.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        matrixRotation(matrix, r);

        bufferedReader.close();
    }

}
