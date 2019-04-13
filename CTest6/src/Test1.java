import java.io.*;
public class Test1 {

	public static void main(String[] args) {
		try {
			FileInputStream fis=new FileInputStream("/Users/gongbin/Desktop/abc.txt");
			//创建一个文件字节输入流对象
			int temp=fis.read();
			//读取一个字节
			while(temp!=-1)//判断是否到文件的尾部
			{
				System.out.print((char)temp+",");
				temp=fis.read();
				//再次读取一个字节
			}

		} catch (FileNotFoundException e) {
			System.out.println("文件未找到");
		}
		catch (IOException e) {
			System.out.println("文件读取错误");
		}


	}

}