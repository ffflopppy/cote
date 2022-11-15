package org.example;

public class Recursive {

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
