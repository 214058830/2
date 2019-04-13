package all;

public class Data2Packet {
    private String number;
    private String password;

    public void setNumber(String number){
        this.number = number;
    }
    public String getNumber(){
        return number;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return password;
    }

    public Data2Packet(String number, String password)
    {
        this.number = number;
        this.password = password;
    }
    public Data2Packet(){

    }
}
