//对于学生信息文件进行数据操作的类
import java.io.*;
import java.util.*;
public class StudentDAO {

	//通过学号来查找学生信息
	public String findStuByNum(String num)
	{
		String result="";
		//用来保存结果的字符串
		try
		{
			FileReader fr=new FileReader("/Users/gongbin/Desktop/student.txt");
			//创建一个文件字符输入流
			BufferedReader br=new BufferedReader(fr);
			//用文件字符输入流对象来创建缓冲字符输入流对象
			String temp=br.readLine();
			//先读取一行数据
			boolean flag=true;
			while(flag)
			{
				if(temp.startsWith(num))
				{
					result=temp;
					break;
				}
				temp=br.readLine();//再次读取一行数据
				if(temp==null)
				{
					flag=false;
				}
			}
			br.close();
			fr.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("文件未找到");
		}
		catch (IOException e) {
			System.out.println("文件读取错误");
		}
		return result;
	}

	//通过姓名来查询学生信息
	public String findStuBySname(String sname)
	{
		String result="";
		//用来保存结果的字符串
		try
		{
			FileReader fr=new FileReader("/Users/gongbin/Desktop/student.txt");
			//创建一个文件字符输入流
			BufferedReader br=new BufferedReader(fr);
			//用文件字符输入流对象来创建缓冲字符输入流对象
			String temp=br.readLine();
			//先读取一行数据
			boolean flag=true;
			while(flag)
			{
				if(temp.substring(4).startsWith(sname))
				{
					result=temp;
					break;
				}
				temp=br.readLine();//再次读取一行数据
				if(temp==null)
				{
					flag=false;
				}
			}
			br.close();
			fr.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("文件未找到");
		}
		catch (IOException e) {
			System.out.println("文件读取错误");
		}
		return result;
	}

	//学生信息查询方法
	public String findStuByPara(String para,int index)
	{
		String result="";
		//用来保存结果的字符串
		try
		{
			FileReader fr=new FileReader("/Users/gongbin/Desktop/student.txt");
			//创建一个文件字符输入流
			BufferedReader br=new BufferedReader(fr);
			//用文件字符输入流对象来创建缓冲字符输入流对象
			String temp=br.readLine();
			//先读取一行数据
			boolean flag=true;
			while(flag)
			{
				String str=temp;
				if(index==2)
				{
					str=temp.substring(4);
				}
				if(str.startsWith(para))
				{
					result=temp;
					break;
				}
				temp=br.readLine();//再次读取一行数据
				if(temp==null)
				{
					flag=false;
				}
			}
			br.close();
			fr.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("文件未找到");
		}
		catch (IOException e) {
			System.out.println("文件读取错误");
		}
		return result;
	}

	//增加一条学生记录的方法
	public boolean addStudent(String stuinfo)
	{
		boolean result=false;
		String[] strs=stuinfo.split(",");
		if(!numIsExists(strs[0]))
		{

			try
			{
				FileWriter fw=new FileWriter("/Users/gongbin/Desktop/student.txt",true);
				//创建一个文件字符输出流对象,第二个参数为真表示追加到文件尾部
				BufferedWriter bw=new BufferedWriter(fw);
				//以文件字符输出流对象来创建缓冲的字符输出流对象
				bw.newLine();
				//创建新的一行
				bw.write(stuinfo);
				//写入新的学生记录
				bw.close();
				fw.close();
				result=true;
			}
			catch (FileNotFoundException e) {
				System.out.println("文件未找到");
			}
			catch (IOException e) {
				System.out.println("文件写错误");
			}
		}
		return result;
	}

	//判断所添加的学生记录是否已经存在
	private boolean numIsExists(String num)
	{
		boolean result=false;
		try
		{
			FileReader fr=new FileReader("/Users/gongbin/Desktop/student.txt");
			//创建一个文件字符输入流
			BufferedReader br=new BufferedReader(fr);
			//用文件字符输入流对象来创建缓冲字符输入流对象
			String temp=br.readLine();
			//先读取一行数据
			boolean flag=true;
			while(flag)
			{
				if(temp.startsWith(num))
				{
					result=true;
					break;
				}
				temp=br.readLine();
				if(temp==null)
				{
					flag=false;
				}
			}
			br.close();
			fr.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("文件未找到");
		}
		catch (IOException e) {
			System.out.println("文件读取错误");
		}
		return result;
	}
	//增加多条学生记录的方法
	public int addStudents(String[] stus)
	{
		int result=0;
		//保存成功插入的学生记录个数
		if(stus!=null)//判断传递过来的数组不是空的
		{
			if(stus.length>0)//判断数组的长度不为0
			{
				for(int i=0;i<stus.length;i++)
				{
					if(addStudent(stus[i]))
					{
						result++;
					}
				}
			}
		}
		return result;
	}

	//删除一条学生记录的方法
	public boolean deleteStudent(String num)
	{
		boolean result=false;
		try
		{
			ArrayList<String> list=new ArrayList<String>();
			//定义一个对象来保存读出的学生记录
			FileReader fr=new FileReader("/Users/gongbin/Desktop/student.txt");
			//创建一个文件字符输入流
			BufferedReader br=new BufferedReader(fr);
			//用文件字符输入流对象来创建缓冲字符输入流对象
			String temp=br.readLine();
			//先读取一行数据
			boolean flag=true;
			while(flag)
			{
				list.add(temp);//将某行数据写入到容器中
				temp=br.readLine();//再次读取一行数据
				if(temp==null)
				{
					flag=false;
				}
			}
			br.close();
			fr.close();
			/////以下是进行查找并删除的代码
			for(int i=0;i<list.size();i++)
			{
				if(list.get(i).startsWith(num))
				{
					list.remove(i);
					result=true;
					break;
				}
			}
			////重新写入文件的代码
			FileWriter fw=new FileWriter("/Users/gongbin/Desktop/student.txt");
			//创建一个文件字符输出流对象
			BufferedWriter bw=new BufferedWriter(fw);
			//以文件字符输出流对象来创建缓冲的字符输出流对象
			for(int i=0;i<list.size();i++)
			{
				bw.write(list.get(i));
				bw.newLine();
			}
			bw.close();
			fw.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("文件未找到");
		}
		catch (IOException e) {
			System.out.println("文件读取错误");
		}
		return result;
	}

	//删除多条学生记录的方法
	public int deleteStudents(String[] nums)
	{
		int result=0;
		if(nums!=null)
		{
			if(nums.length>0)
			{
				for(int i=0;i<nums.length;i++)
				{
					if(deleteStudent(nums[i]))
					{
						result++;
					}
				}
			}
		}
		return result;
	}

	//修改一条学生记录的方法
	public boolean updateStudent(String stuinfo)
	{
		boolean result=false;
		String[] strs=stuinfo.split(",");
		try
		{
			ArrayList<String> list=new ArrayList<String>();
			//定义一个对象来保存读出的学生记录
			FileReader fr=new FileReader("/Users/gongbin/Desktop/student.txt");
			//创建一个文件字符输入流
			BufferedReader br=new BufferedReader(fr);
			//用文件字符输入流对象来创建缓冲字符输入流对象
			String temp=br.readLine();
			//先读取一行数据
			boolean flag=true;
			while(flag)
			{
				list.add(temp);//将某行数据写入到容器中
				temp=br.readLine();//再次读取一行数据
				if(temp==null)
				{
					flag=false;
				}
			}
			br.close();
			fr.close();
			/////以下是进行查找并删除的代码
			for(int i=0;i<list.size();i++)
			{
				if(list.get(i).startsWith(strs[0]))
				{
					list.remove(i);
					result=true;
					break;
				}
			}
			list.add(stuinfo);
			////重新写入文件的代码
			FileWriter fw=new FileWriter("/Users/gongbin/Desktop/student.txt");
			//创建一个文件字符输出流对象
			BufferedWriter bw=new BufferedWriter(fw);
			//以文件字符输出流对象来创建缓冲的字符输出流对象
			for(int i=0;i<list.size();i++)
			{
				bw.write(list.get(i));
				bw.newLine();
			}
			bw.close();
			fw.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("文件未找到");
		}
		catch (IOException e) {
			System.out.println("文件读取错误");
		}
		return result;
	}

	//修改多条学生记录的方法
	public int updateStudents(String[] stuinfos)
	{
		int result=0;
		if(stuinfos!=null)
		{
			if(stuinfos.length>0)
			{
				for(int i=0;i<stuinfos.length;i++)
				{
					if(updateStudent(stuinfos[i]))
					{
						result++;
					}
				}
			}
		}
		return result;
	}

}
