package test_1;

import java.util.Scanner;

public class Test_1 {
    static void printstr(int number){
        int i;
        for(int j=0; j<number-1; j++){
            i = (2 * (number - 1) + 1) / 2 - j;
            for(;i>0; i--){
                System.out.print(" ");
            }

            System.out.print("*");

            if(j == 0){
                System.out.println();
                continue;
            }
            for(i=0; i<2*(j-1)+1; i++){
                System.out.print(" ");
            }

            System.out.println("*");

        }
        for(i=0; i<(2 * (number - 1) + 1); i++){
            System.out.print("*");
        }
    }

    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        Test_1.printstr(number);
        in.close();
    }

}

