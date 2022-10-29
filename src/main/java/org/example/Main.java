package org.example;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();


        System.out.println(solution.makeBinary(8));

        int[] sol1 = solution.solution1("0000");
        for (int sol:sol1) {
            System.out.print(sol);
        }
    }
}