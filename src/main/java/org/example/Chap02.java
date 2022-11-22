package org.example;

public class Chap02 {



    public void primeNum3(){
        int counter = 0;
        int ptr = 0;
        int[] prime = new int[500];

        prime[ptr++] = 2;
        prime[ptr++] = 3;

        for (int n = 5; n < 1000 ; n+=2) {
            boolean flag = false;
            for (int i = 1; prime[i]* prime[i] <= i  ; i++) {
                counter += 2;
                if (n % prime[i] == 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag){
                prime[ptr++] = n;
                counter++;
            }
        }
        for (int i = 0; i < ptr; i++)
            System.out.println("찾은 ptr 갯수 :::: "+prime[i]);

            System.out.println("counter ::: " + counter);
    }

    public void primeNum2(){
        int counter = 0 ;
        int ptr = 0;
        int[] prime = new int[500];

        prime[ptr++] = 2;

        for (int n = 3; n < 1000 ; n+=2) {
            int i ;
            for (i = 0; i < ptr ; i++) {
                counter++;
                if (n % prime[i] == 0) break;
            }

            if (ptr == i) prime[ptr++] = n;
        }

        for (int i = 0; i < ptr; i++) {
            System.out.println(prime[i]);
        }

        System.out.println("counter ::::::: "+ counter);
    }

    public void primeNumber(){
        int counter =0;
        for (int n = 2; n <= 1000 ; n++) {
            int i;
            for (i = 2; i < n; i++) {
                counter++;
                if (n%i == 0) break;
            }
            if (n == i) System.out.println(n);
        }

        System.out.println("count :: " + counter);
    }

    public void cloneMultiArr(){
        int[][]a = {{1,2,3,4,},{5,6,7}};
        int[][]b = a.clone();
        b[0][0] = 2;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {

                System.out.print(a[i][j]);
            }

            System.out.println();
        }
        System.out.println("a ===");

        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {

                System.out.print(b[i][j]);
            }

            System.out.println();
        }
        System.out.println("===");
    }
    public void cloneArr(){
        int[] a = {1,2,3,4,5};
        int[] b = a.clone();
        b[3] = 0 ;
        System.out.print("a ::: ");
        for (int aa :a) {
            System.out.print(aa);
        }
        System.out.println();
        System.out.print("b ::: ");
        for (int bb :b) {
            System.out.print(bb);
        }

        int[] c = b;
        c[3] = 7;
        System.out.println();
        System.out.println("||||||||||||||||||||");
        System.out.print("b ::: ");

        for (int bb :b) {
            System.out.print(bb);
        }

        System.out.println();
        System.out.print("c ::: ");

        for (int cc :c) {
            System.out.print(cc);
        }
    }


    public int factorial(int n) {
        if (n > 0) return n* factorial(n-1);
        return 1;
    }

    public int gcd(int x, int y){
        if(y == 0 ){
            return x;
        } else return gcd(y, x%y);

    }
    public int greatestCommonDivider(int horizontal, int vertical){
        int answer = 0;

        int smaller = horizontal > vertical? vertical: horizontal;
        int bigger = horizontal > vertical? horizontal: vertical;

        while (bigger > 2 ){

            answer += bigger / smaller;
            int remainder = bigger % smaller;
            bigger = smaller;
            smaller = remainder;

        }

        return answer;
    }


}
