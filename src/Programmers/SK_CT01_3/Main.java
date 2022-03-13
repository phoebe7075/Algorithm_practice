package Programmers.SK_CT01_3;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution(51,37,new int[][]{{17,19}}));
    }
    static String max = "10000019";
    static public int solution(int width, int height, int[][] diagonals) {
        BigInteger answer = new BigInteger("0");
        int x, y, nx, ny;
        for(int i=0; i<diagonals.length; i++) {
            x = diagonals[i][0]-1;
            y = diagonals[i][1];
            nx = diagonals[i][0];
            ny = diagonals[i][1]-1;
            answer = answer.add(comb(x+y,y).multiply(comb(width+height-nx-ny,width-nx)));
            answer = answer.add(comb(nx+ny,nx).multiply(comb(width+height-x-y,height-y)));
        }
        return answer.mod(new BigInteger(max)).intValue();
    }

    static public BigInteger comb(int x, int y) {
        if(x==y || y == 0) return new BigInteger("1");
        BigInteger den = factorial(new BigInteger(Integer.toString(y))).multiply(factorial(new BigInteger(Integer.toString(x-y))));
        return factorial(new BigInteger(Integer.toString(x))).divide(den);
    }

    static public BigInteger factorial(BigInteger x) {
        if(x.intValue() == 1) {
            return x;
        }else {
            return factorial(x.subtract(new BigInteger("1"))).multiply(x);
        }
    }
}
