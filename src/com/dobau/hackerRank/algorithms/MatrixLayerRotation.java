package com.dobau.hackerRank.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Collections.rotate;
import static java.util.stream.Collectors.toList;

/**
 * https://www.hackerrank.com/challenges/matrix-rotation-algo/problem
 */
public class MatrixLayerRotation {

    // Complete the matrixRotation function below.
    static void matrixRotation(List<List<Integer>> matrix, int r) {
        List<List<Integer>> rows = new ArrayList<>();
        List<List<Integer>> sizes = new ArrayList<>();
        matrixToRows(matrix, sizes, rows);

        rows.forEach(row -> rotate(row, -r));

        fillAgain(rows, sizes, matrix);

        matrix.forEach(row -> {
            String str = row.stream()
                            .map(v -> v.toString())
                            .collect(Collectors.joining(" "));

            System.out.println(str);
        });
    }

    private static void fillAgain(List<List<Integer>> rows, List<List<Integer>> sizes, List<List<Integer>> newMatrix) {

        int depth = (int) Math.floor(newMatrix.size() / 2) - 1;

        for (int i = rows.size() - 1; i >= 0; i--) {
            int row = depth;
            int col = depth;
            for (int j = 0; j < rows.get(i).size(); j++) {
                newMatrix.get(row).set(col, rows.get(i).get(j));

                int sizeX = sizes.get(i).get(1) - 1;
                int sizeY = sizes.get(i).get(0) - 1;
                if (j < sizeX) {
                    col++;
                } else if (j >= sizeX && j < sizeX + sizeY) {
                    row++;
                } else if  (j >= sizeX + sizeY && j < (2 * sizeX + sizeY)) {
                    col--;
                } else {
                    row--;
                }
            }

            depth--;
        }

    }

    private static void matrixToRows(List<List<Integer>> matrix, List<List<Integer>> sizes, List<List<Integer>> rows) {

        List<Integer> row = new ArrayList<>();
        List<Integer> firstLine = new ArrayList<>();
        List<Integer> lastLine = new ArrayList<>();
        List<Integer> rightLine = new ArrayList<>();
        List<Integer> leftLine = new ArrayList<>();

        List<List<Integer>> restMatrix = new ArrayList<>();

        sizes.add(Arrays.asList(matrix.size(), matrix.get(0).size()));

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
            matrixToRows(restMatrix, sizes, rows);
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
