package test_1;

public class Test_2 {

    public static void main(String[] args) {
        Test_2 p = new Test_2();
        p.my_printf1();
    }
    void my_printf1(){
        int i = 1;
        while(i <= 9){
            for(int j=1; j<=i; j++){
                System.out.print(j+"*"+i+" = "+j*i+"  ");
            }
            System.out.println();
            i++;
        }
    }

}
