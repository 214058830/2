import java.io.*;
public class Test2 {

	public static void main(String[] args) {
		try {
			FileReader fr=new FileReader("/Users/gongbin/Desktop/123.txt");
			int temp=fr.read();//读取一个字符
			while(temp!=-1)
			{
				System.out.print((char)temp+",");
				temp=fr.read();
			}
		} catch (FileNotFoundException e) {
			System.out.println("文件未找到");
		}
		catch (IOException e) {
			System.out.println("文件读取错误");
		}

	}

}