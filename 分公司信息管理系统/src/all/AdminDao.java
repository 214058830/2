package all;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class AdminDao {
    public static ArrayList<DataPacket> queryAllData(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<DataPacket> list = new ArrayList<DataPacket>();
        try{
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();

            String sql = "SELECT * FROM `table`";
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                DataPacket dataPacket = new DataPacket();
                dataPacket.setNum(rs.getString("num"));
                dataPacket.setName(rs.getString("name"));
                dataPacket.setOld(rs.getString("old"));
                dataPacket.setSex(rs.getString("sex"));
                dataPacket.setMoney(rs.getString("money"));
                list.add(dataPacket);
            }
            return list;
        }catch (Exception e){
            new False();
        }finally {
            JDBCUtils.release(rs, stmt, conn);
        }
        return null;
    }
    public static ArrayList<DataPacket> queryNumData(String n){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<DataPacket> list = new ArrayList<DataPacket>();
        try{
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();

            String sql = "SELECT * FROM `table` where num = "+ n;
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                DataPacket dataPacket = new DataPacket();
                dataPacket.setNum(rs.getString("num"));
                dataPacket.setName(rs.getString("name"));
                dataPacket.setOld(rs.getString("old"));
                dataPacket.setSex(rs.getString("sex"));
                dataPacket.setMoney(rs.getString("money"));
                list.add(dataPacket);
            }
            return list;
        }catch (Exception e){
            new False();
        }finally {
            JDBCUtils.release(rs, stmt, conn);
        }
        return null;
    }
    public static void addDataPacket(DataPacket dataPacket){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "INSERT INTO `table`(num, name, old, sex, money)"
                    + "VALUES (" + dataPacket.getNum() + ",'"
                    + dataPacket.getName() + "'," + dataPacket.getOld()
                    +",'" + dataPacket.getSex() + "',"+ dataPacket.getmoney() + ")";
            int num = stmt.executeUpdate(sql);
            if(num > 0) {
                new Success();
            }
            else{
                new False();
            }
        }catch (Exception e){
            new False();
        }finally {
            JDBCUtils.release(rs, stmt, conn);
        }
    }
    public static void delDataPacket(String delNumber){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs =null;
        try{
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "DELETE FROM `table` WHERE num = "+ delNumber;
            int num = stmt.executeUpdate(sql);
            if(num > 0){
                new Success();
            }
            else{
                new False();
            }
        }catch (Exception e){
            new False();
        }finally {
            JDBCUtils.release(rs, stmt, conn);
        }
    }
    public static void ModifyDataPacket(DataPacket dataPacket){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs =null;
        try{
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "UPDATE `table` SET name = '"+ dataPacket.getName() +
                    "',old = "+ dataPacket.getOld() + ",sex ='" + dataPacket.getSex() +
                    "',money = " + dataPacket.getmoney() + " WHERE num =" + dataPacket.getNum();
            int num = stmt.executeUpdate(sql);
            if(num > 0){
                new Success();
            }
            else{
                new False();
            }
        }catch (Exception e){
            new False();
        }finally {
            JDBCUtils.release(rs, stmt, conn);
        }
    }
    public static ArrayList<Data2Packet> LandAllData(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Data2Packet> list = new ArrayList<Data2Packet>();
        try{
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM Land";
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                Data2Packet dataPacket = new Data2Packet();
                dataPacket.setNumber(rs.getString("number"));
                dataPacket.setPassword(rs.getString("password"));
                list.add(dataPacket);
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.release(rs, stmt, conn);
        }
        return null;
    }
    public static void addData2Packet(Data2Packet dataPacket){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "INSERT INTO `Land`(number, password)"
                    + "VALUES ('" + dataPacket.getNumber() + "','"
                    + dataPacket.getPassword() + "')";
            int num = stmt.executeUpdate(sql);
            if(num > 0){
                new Success();
            }
            else{
                new False();
            }
        }catch (Exception e){
            new False();
        }finally {
            JDBCUtils.release(rs, stmt, conn);
        }
    }
}