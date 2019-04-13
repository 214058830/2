package test_1;

import java.util.Scanner;

public class Test_3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int year = in.nextInt();
        System.out.println(year+"的生肖为"+Test_3.fun(year));
        in.close();
    }

    static String fun(int year){
        switch(year%12){
            case 0:
                return "猴";
            case 1:
                return "鸡";
            case 2:
                return "狗";
            case 3:
                return "猪";
            case 4:
                return "鼠";
            case 5:
                return "牛";
            case 6:
                return "虎";
            case 7:
                return "兔";
            case 8:
                return "龙";
            case 9:
                return "蛇";
            case 10:
                return "马";
            case 11:
                return "羊";
            default:
                return "error";
        }
    }

}

