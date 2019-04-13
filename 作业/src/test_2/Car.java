package test_2;

public class Car {

    private String model;
    private String admin;
    private String number;
    private int speed;
    private int weight;

    public void setModel(String model){
        this.model = model;
    }
    public void setAdmin(String admin){
        this.admin = admin;
    }
    public void setNumber(String number){
        this.number = number;
    }
    public void setSpeed(int speed){
        this.speed = speed;
    }
    public void setWeight(int weight){
        this.weight =weight;
    }

    public String getModel(){
        return model;
    }
    public String getAdmin(){
        return admin;
    }
    public String getNumber(){
        return number;
    }
    public int getSpeed(){
        return speed;
    }
    public int getweight(){
        return weight;
    }
    public Car(){
        System.out.println("�޲εĹ��췽��");
    }
    public Car(int a){
        System.out.println("�вҵĹ��췽��������Ϊ"+a);
    }
    public void print(){
        System.out.println("�ͺ�:"+model+"������:"+admin+"���ƺ�:"
                +number+"�ٶ�:"+speed+"����:"+weight);
    }
    public void print1(){
        System.out.println("������:"+admin+"���ƺ�:"+number);
    }
    public void print2(){
        System.out.println("���ƺ�:"+number+"�ٶ�:"+speed);
    }
    public void print3(){
        System.out.println("�ٶ�:"+speed+"����:"+weight);
    }
    public void print4(){
        System.out.println("�ͺ�:"+model+"�ٶ�:"+speed);
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Car car = new Car();
        car.setModel("����");
        car.setAdmin("����");
        car.setNumber("10086");
        car.setSpeed(10);
        car.setWeight(20);
        car.print();
    }

}
