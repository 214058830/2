package test_2;

public class test_2 {

    public static void sort(String str[]){
        String tmp;
        for(int i=0; i<str.length; i++){
            for(int j=0; j<str.length-i-1;j++){
                if(str[j].compareTo(str[j+1]) < 0){
                    tmp = str[j+1];
                    str[j+1] = str[j];
                    str[j] = tmp;
                }
            }
        }
    }
    public static void addSort(String str1[], String str2[]){
        test_2.sort(str1);
        test_2.sort(str2);
        String []tmp = new String[str1.length+str2.length];
        int i = 0, j = 0, k = 0;
        while(i < str1.length){
            tmp[k++] = str1[i++];
        }
        while(j < str2.length){
            tmp[k++] = str2[j++];
        }
        test_2.sort(tmp);
        test_2.print(tmp);
    }
    public static void print(String str[]){
        for(int n=0; n<str.length; n++){
            System.out.print(str[n]+"  ");
        }
        System.out.println();
    }
    public static void print(float str[], int num){
        for(int n=0; n<num; n++){
            System.out.print(str[n]+"  ");
        }
        System.out.println();
    }
    public static void intersectionInt(int str1[], int str2[]){
        for(int i=0; i<str1.length; i++){
            for(int j=0; j<str2.length; j++){
                if(str1[i] == str2[j]){
                    System.out.print(str1[i]+"  ");
                    break;
                }
            }
        }
        System.out.println();
    }
    public static void unionFloat(float str1[],float str2[])
    {
        float []str3 = new float[str1.length+str2.length];
        int i=0;
        int k=0;
        while(i<str1.length)
        {
            str3[k]=str1[i];
            i++;
            k++;
        }
        int j= 0;
        while(j<str2.length)
        {
            str3[k]= str2[j];
            j++;
            k++;
        }
        int num = 0;
        for(i = 0; i < str3.length - num; i++) {
            for(j = i+1; j < str3.length - num; j++) {
                if(str3[j] == str3[i]) {
                    float temp;
                    temp = str3[j];
                    str3[j] = str3[str3.length - num - 1];
                    str3[str3.length - num - 1] = temp;
                    num++;
                    j--;
                }
            }
        }
        test_2.print(str3, str3.length - num);
    }
    public static void main(String[] args) {
        String[] str1 = {"abc", "bc", "ac"};
        String[] str2 = {"bcd", "bac", "acc"};
        test_2.print(str1);
        test_2.print(str2);
        test_2.addSort(str1, str2);
        int[] str3 = {1, 3, 4, 5};
        int[] str4 = {3, 4, 6};
        test_2.intersectionInt(str3, str4);
        float[] str5 = {1.0f, 3.4f, 5.6f};
        float[] str6 = {3.3f, 1.0f};
        test_2.unionFloat(str5, str6);
    }

}
