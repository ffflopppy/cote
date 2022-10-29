package org.example;

import java.util.Arrays;

public class Solution {

    public int solution2(int[] priorities, int location) {
        int answer = 0;
        return answer;
    }
    public int[] solution1(String s) {

        int[] answer = {0,0};
        String binary = s;
        Boolean keepGo = Arrays.stream(binary.split("")).count() > 1;

        while (keepGo){
            // count one
            Long countOne = Arrays.stream(binary.split("")).filter(x -> x.equals("1")).count();
            answer[0] = answer[0]+1;
            answer[1] += Arrays.stream(binary.split("")).filter(x -> x.equals("0")).count();
            binary = "";

            // make num to binary
            while (countOne > 1){

                Long remainder = countOne%2; //remainder
                countOne = countOne/2; // quotient
                binary = remainder + binary;
                if (countOne == 1 | countOne == 0) {
                    binary = countOne + binary;
                }
            }

            keepGo = Arrays.stream(binary.split("")).count() > 1;
        }
        return answer;
    }

    public String makeNum2Binary(int num) {
        String binary = "";
        while (num > 1){
            int remainder = num%2; //remainder
            num = num/2; // quotient
            binary = remainder + binary;

            if (num == 1 | num == 0) binary = num + binary;
        }
        return binary;
    }
}
