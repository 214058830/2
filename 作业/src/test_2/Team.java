package test_2;

public class Team {

    int num;

    public class teacher{
        int age;
        String sex;
        teacher(int age, String sex){
            this.age = age;
            this.sex = sex;
        }
        public void fun() {
            System.out.println("����ʦ������Ϊ��"+age+"�Ա�Ϊ��"+sex);
        }
    }
    public class undergraduate{
        int age;
        String sex;
        undergraduate(int age, String sex){
            this.age = age;
            this.sex = sex;
        }
        public void fun() {
            System.out.println("���о���������Ϊ��"+age+"�Ա�Ϊ��"+sex);
        }
    }
    public class graduateStudent{
        int age;
        String sex;
        graduateStudent(int age, String sex){
            this.age = age;
            this.sex = sex;
        }
        public void fun() {
            System.out.println("�ñ�����������Ϊ��"+age+"�Ա�Ϊ��"+sex);
        }
    }
    Team(int number){
        this.num = number;
        System.out.println("Team�Ĺ��췽���ѵ���");
    }
    public void fun() {
        System.out.println("�Ŷӵ�����Ϊ��"+num);
    }

    public static void main(String[] args) {
        Team team = new Team(3);
        team.fun();
    }

}
