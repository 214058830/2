package test_1;

import java.util.Scanner;

public class Test_4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        char inputChar = in.next().charAt(0);
        int b = in.nextInt();
        int x = 0;
        switch(inputChar) {
            case '+':
                x = add(a, b);
                break;
            case '-':
                x = sub(a, b);
                break;
            case '*':
                x = mul(a, b);
                break;
            case '/':
                x = dev(a, b);
                break;
            default:
                System.out.println("error");
        }
        System.out.println(a+""+inputChar+""+b+"="+x);
        in.close();
    }

    static int add(int a, int b){
        return a+b;
    }

    static int sub(int a, int b){
        return a-b;
    }

    static int mul(int a, int b){
        return a*b;
    }

    static int dev(int a, int b){
        return a/b;
    }

}
