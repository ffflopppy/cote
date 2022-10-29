package org.example;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {



    public String solution3(String[] participant, String[] completion) {

        // todo :: 동명이인가능
        String answer = "";
        Set<String> winnerSet = new HashSet<>(Arrays.asList(completion));

        for (String player :participant) {
            if (!winnerSet.contains(player)) return player;
        }
        return answer;
    }
    public int solution2(int[] priorities, int location) {
        int answer = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int p : priorities){
            pq.offer(p);
            System.out.println(pq);
        }

        while (!pq.isEmpty()){
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == location) return answer;
            }
            pq.poll();
            answer++;
        }
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
                countOne = countOne/2; // quotient
                binary = countOne%2 + binary; // remainder
                if (countOne == 1 | countOne == 0) binary = countOne + binary;
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
