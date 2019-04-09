package com.dobau.hackerRank.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Collections.rotate;
import static java.util.stream.Collectors.toList;

public class MatrixLayerRotation {

    // Complete the matrixRotation function below.
    static void matrixRotation(List<List<Integer>> matrix, int r) {
        List<List<Integer>> rows = new ArrayList<>();
        matrixToRows(matrix, rows);

        rows.forEach(row -> rotate(row, r));

        System.out.println(rows);
    }

    private static void matrixToRows(List<List<Integer>> matrix, List<List<Integer>> rows) {

        List<Integer> row = new ArrayList<>();
        List<Integer> firstLine = new ArrayList<>();
        List<Integer> lastLine = new ArrayList<>();
        List<Integer> rightLine = new ArrayList<>();
        List<Integer> leftLine = new ArrayList<>();

        List<List<Integer>> restMatrix = new ArrayList<>();

        for (int i = 0; i < matrix.size(); i++) {
            if (i == 0) {
                List<Integer> r1 = matrix.get(i).subList(0, matrix.get(0).size());
                firstLine.addAll(r1);
            } else if (i == matrix.size() - 1) {
                List<Integer> r2 = matrix.get(i).subList(0, matrix.get(0).size());
                lastLine.addAll(r2);
            } else {
                rightLine.add(matrix.get(i).get(matrix.get(i).size() - 1));

                if (matrix.get(i).size() > 1) {
                    leftLine.add(matrix.get(i).get(0));
                }

                if (matrix.get(i).size() > 2) {
                    restMatrix.add(matrix.get(i).subList(1, matrix.get(i).size() - 1));
                }
            }
        }

        row.addAll(firstLine);
        row.addAll(rightLine);

        Collections.reverse(lastLine);
        row.addAll(lastLine);

        Collections.reverse(leftLine);
        row.addAll(leftLine);

        rows.add(row);

        if (restMatrix.size() > 0) {
            matrixToRows(restMatrix, rows);
        }
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
