package org.example;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class Solution {


    public int solution16(int k, int m, int[] score) {
        int answer = 0;
        int boxSize= score.length/m;
        int[] sortedArr = Arrays.stream(score).sorted().toArray();

        for (int i = sortedArr.length-m ; i >= 0; i=i-m) {

            System.out.println(":::::" +i);
            answer += sortedArr[i] * m;
            boxSize --;
            if (boxSize == 0) return answer;

        }
        return answer;
    }

     public boolean solution15(int[] A, int K) {
         int n = A.length;
         for (int i = 0; i < n - 1; i++) {
             if (A[i] + 1 < A[i + 1])
                 return false;
         }
         if (A[0] != 1 || A[n - 1] != K)
             return false;
         else
             return true;
     }

     public int recursive_14_2(int n,int number) {
         String s = Integer.valueOf(number).toString();
         int[] arr = Arrays.stream(s.split("")).mapToInt(Integer::parseInt).toArray();
         if( Arrays.stream(arr).sum() == n ){
             return number;
         } else
             return recursive_14_2(n, number+1);

     }
    public int solution14_2(int N) {
    // write your code in Java SE 8
        int n = Arrays.stream(String.valueOf(N).split("")).mapToInt(i -> Integer.parseInt(i)).sum();
        return recursive_14_2(n,N);
//        while (true){
//            N ++;
//            int[] arr = Arrays.stream(String.valueOf(N).split("")).mapToInt(x->Integer.parseInt(x)).toArray();
//            // loop till same number with n.
//            if(n == Arrays.stream(arr).sum()){
//                String s = "";
//                for (int a : arr) {
//                    s = s + a;
//                }
//                return Integer.valueOf(s);
//            }
//        }

    }

    public int solution14(int N) {
        // write your code in Java SE 8

        String[] arr = String.valueOf(N).split("");
        int n = Arrays.stream(arr).mapToInt(i -> Integer.parseInt(i)).sum();
        List<Integer> list = Arrays.stream(arr).map(i -> Integer.valueOf(i)).collect(Collectors.toList());

        int idx = list.size() - 1;
        int i = list.get(idx);

        while (true){
            list.set(idx, i);
            int count = list.stream().mapToInt(Integer::intValue).sum();

            if (count == n) {
//                if (Integer.valueOf(list.toString()) == N) continue;
                if (list.stream().map(String::valueOf)
                        .collect(Collectors.joining()).equals(Integer.valueOf(N).toString()) ) continue;
                return Integer.valueOf(list.toString());
            }

            if (i == 9) {
                idx= idx-1;
                i = list.get(idx);
            }
            if (idx < 1) return 0;

        }
    }


    // ["119", "97674223", "1195524421"]
    public boolean solution13(String[] phone_book) {

        List<String> digit = Arrays.stream(phone_book).sorted().collect(Collectors.toList());

        for (int i = 1; i < digit.size(); i++) {
            if (digit.get(i).startsWith(digit.get(i-1))) return false;
        }

        return true;
    }

    public int[] solution12(int[] answers) {
        int[] a = {1, 2, 3};
        int[] b = {2, 1, 2};
        int[] c = {3, 3, 1};

        List<Integer> answer = new ArrayList<>();
        int[] buff = {0,0,0};

        for (int i = 0; i < answers.length; i++) {


            if (answers[i] == a[(i%a.length)]) buff[0]++;
            if (answers[i] == b[(i%b.length)]) buff[1]++;
            if (answers[i] == c[(i%c.length)]) buff[2]++;
        }

        int max = Collections.max(Arrays.stream(buff).boxed().collect(Collectors.toList()));

        if (max == 0 ) return null;

        for (int i = 0; i < buff.length; i++) {
            if (max == buff[i]) answer.add(i+1);

        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    public int[] solution11_2(int[] array, int[][] commands) {

        int[] answer = new int[commands.length];
        int[] result = {};
        int i=0, j=0, k=0;


//        for(int i=0; i<commands.length; i++){
//            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
//            Arrays.sort(temp);
//            answer[i] = temp[commands[i][2]-1];
//        }


        for(int a=0; a< commands.length ; a++){

            i= commands[a][0];
            j= commands[a][1];
            k= commands[a][2];
            int c=0;

            result = new int[j-i+1];

            for(int b=i-1; b <=j-1 ; b++){

                result[c] = array[b];
                c++;

            }

            Arrays.sort(result);

            answer[a] = result[k-1];
        }

        return answer;

    }

    public int[] solution11(int[] array, int[][] commands) {

        int[] answer = new int[commands[0].length];
        for (int i = 0; i < commands.length; i++) {
            // 배열 만들기
            List<Integer> list = new ArrayList<>();
            for (int j = commands[i][0]-1; j < commands[i][1] ; j++) {
                list.add(Integer.valueOf(array[j]));
            }

            // 배열 소팅
            list = list.stream().sorted().collect(Collectors.toList());

            // 정답 추가
            list.stream().sorted().map(x -> x.toString()).collect(Collectors.joining());
            answer[i] =list.get(commands[i][2]-1);
        }
        return answer;
        
    }

    private Comparator<String> comparator2 = new Comparator<String>() {
        @Override
        public int compare(String x, String y) {
            return Integer.compare( Integer.valueOf(y+x), Integer.valueOf(x+y) );
        }
    };
   private Comparator<String> comparator = new Comparator<String>() {
        @Override
        public int compare(String x, String y) {
            // String 길이 비교
            int aa = (x.length() < y.length()) ? -1 : ((x.length() == y.length()) ? 0 : 1);
            switch(aa) {
                case -1 : // x 뒤에 문자 추가
                    for (int i = x.length(); i < y.length(); i++) {
                        x = x + x.charAt(x.length()-1);
                    } break;
                case 1 : // y 뒤에 문자 추가
                    for (int i = y.length(); i < x.length(); i++) {
                        y = y + y.charAt(y.length()-1);
                    }break;
                default: break;
            }

            return Integer.compare( Integer.valueOf(y), Integer.valueOf(x) );
        }
    };




    public String solution10(int[] arr) {

        // 배열 비교 갯수가 부족한 숫자뒤에 마지막 숫자를 붙여 자릿수를 같게한후 비교한다.
        // todo :: comparable 이해하기
        List<String> list = Arrays.stream(arr).boxed().map(it -> it.toString()).collect(Collectors.toList());

        return list.stream().sorted(comparator2).collect(Collectors.joining());
    }
   public boolean solution9(String s) {
        boolean answer = true;
       Stack<Character> st = new Stack<>();

       for(int i=0; i<s.length(); i++){
           char c =s.charAt(i);
           if (st.size() == 0 && c ==')') return false;
           if (c =='(') {
               st.push(c);
           }
           else {
               st.pop();
           }
       }
       if (st.size() > 0) return false;

        return answer;
    }

    // q -1
    public int[] solution8(int []arr) {

        ArrayList<Integer> answer = new ArrayList<>();
        for (int num :arr) {
            if (answer.size() == 0 || answer.get(answer.size()-1) != num) {
                answer.add(num);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    // 해시 레벨1- 포켓몬
    public int solution7(int[] nums) {
        int answer = nums.length/2;

        Set set = new HashSet<>();
        for (int num :nums) {
            set.add(num);
        }

        if(set.size() < answer){
            answer = set.size();
        }
        return answer;
    }

    public String solution6(int N, int K) {

        StringBuilder sb = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();

        // K 갯수의 문자로 램덤하게 맵으로
        Map<Integer, String> charMap = new HashMap<>();
        for (int i = 0; i < K; i++) {
            charMap.put(i, Character.toString('a'+i));
        }
        // N/2의 숫자만큼 맵에서 꺼내서 배열로 만들고
        // 나머지가 있으면 하나더 붙이고
        Integer remainder = N%2;
        int half = N/2;
        int j = 0;

        while (true){
            if(j == K ) j= 0;
            list.add(charMap.get(j));
            sb.append(charMap.get(j));
            if(list.size() == remainder + half) break;
            j++;
        }

        int k = list.size()-remainder -1;
        while (true){
            sb.append(list.get(k));
            if(k == 0) break;
            k--;
        }

        return sb.toString();
    }
//    public int solution5(String[] R) {
//        // write your code in Java SE 8
//    }


    // todo :: 전선 끊기 이해 못함.
    public int solution4(int n, int[][] wires){
        int answer = Integer.MAX_VALUE;
        List<List<Integer>> map = new ArrayList<>();

        for(int i = 0; i<=n;i++){
            map.add(new ArrayList<>());
        }

        for(int[] wire : wires){
            map.get(wire[0]).add(wire[1]);
            map.get(wire[1]).add(wire[0]);
        }

        for(int[] wire:wires){
            int node = dfs(map,wire[0],wire[0],wire[1],new boolean[n+1]);
            answer = Math.min(Math.abs(n-node-node),answer);
        }

        return answer;
    }

     private int dfs(List<List<Integer>> map, int start, int i1, int i2, boolean[] check){
        if(check[start]) return 0;
        check[start] = true;
        int node = 1;
        List<Integer> integers = map.get(start);
        for (Integer i : integers) {
            if((start==i1 && i ==i2) || (start==i2 && i==i1)) continue;
            node += dfs(map,i,i1,i2,check);
        }
        return node;
    }

    public String solution3(String[] participant, String[] completion) {
        String answer = "";
        // todo :: 동명이인가능
        // 1. 참가자 map 으로 ["aaa":1, "bbb":2]
        Map<String, Integer> playerMap = new HashMap<>();

        for (String player :participant) {
            if (playerMap.containsKey(player)) {
                playerMap.replace(player,playerMap.get(player)+1);
            } else {
                playerMap.put(player, 1);
            }
        }

        System.out.println(playerMap);

        for (String winner : completion) {
            if (playerMap.containsKey(winner)) {
                playerMap.put(winner,playerMap.get(winner)-1);
            }
        }
        System.out.println("after");
        System.out.println(playerMap);

        for(Map.Entry<String, Integer> entry : playerMap.entrySet()){
            if(entry.getValue() > 0) {
                return  entry.getKey();
            }
        }

//        HashMap<String, Integer> hm = new HashMap<>();
//        for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
//        for (String player : completion) hm.put(player, hm.get(player) - 1);
//
//        for (String key : hm.keySet()) {
//            if (hm.get(key) != 0){
//                answer = key;
//            }
//        }

//        Set<String> winnerSet = new HashSet<>(Arrays.asList(completion));
//        for (String player :participant) {
//            if (!winnerSet.contains(player)) return player;
//        }
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
