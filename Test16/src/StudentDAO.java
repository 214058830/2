//学生信息文件的操作类
import java.io.*;
import java.util.*;
public class StudentDAO {

	//查找所有的学生信息
	public ArrayList<String> findAllStudents()
	{
		ArrayList<String> result=new ArrayList<String>();
		try {
			FileReader fr=new FileReader("/Users/gong/Documents/JAVA/Test16/student.txt");
			//产生了一个文件字符输入流对象
			BufferedReader br=new BufferedReader(fr);
			//以上一个对象作为参数来创建一个缓冲的字符输入流对象
			String str=br.readLine();//读取一行数据
			while(str!=null)
			{
				result.add(str);
				str=br.readLine();
			}
			br.close();
			fr.close();
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("文件未找到");
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("文件读错误");
		}
		return result;
	}

	//通过学号来查找学生的基本信息
	public String findStudentBySno(String sno)
	{
		String result="不存在这个学号";
		try {
			FileReader fr=new FileReader("/Users/gong/Documents/JAVA/Test16/student.txt");
			//产生了一个文件字符输入流对象
			BufferedReader br=new BufferedReader(fr);
			//以上一个对象作为参数来创建一个缓冲的字符输入流对象
			String str=br.readLine();//读取一行数据
			boolean flag=true;
			while(flag)
			{
				if(str.startsWith(sno.trim()))
				{
					result=str;
					flag=false;
				}
				str=br.readLine();//继续读取下一行
				if(str==null)
				{
					flag=false;
				}
			}
			br.close();
			fr.close();
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("文件未找到");
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("文件读错误");
		}
		return result;
	}


	//通过姓名来查找学生的基本信息
	public String findStudentBySname(String sname)
	{
		String result="不存在这个学生";
		try {
			FileReader fr=new FileReader("/Users/gong/Documents/JAVA/Test16/student.txt");
			//产生了一个文件字符输入流对象
			BufferedReader br=new BufferedReader(fr);
			//以上一个对象作为参数来创建一个缓冲的字符输入流对象
			String str=br.readLine();//读取一行数据
			boolean flag=true;
			while(flag)
			{
				if(str.substring(4).startsWith(sname.trim()))
				{
					result=str;
					flag=false;
				}
				str=br.readLine();//继续读取下一行
				if(str==null)
				{
					flag=false;
				}
			}
			br.close();
			fr.close();
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("文件未找到");
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("文件读错误");
		}
		return result;
	}

	//通过姓名来查找学生的基本信息
	public String findStudentByPara(boolean bool,String para)
	{
		String result="不存在这个学生";
		try {
			FileReader fr=new FileReader("/Users/gong/Documents/JAVA/Test16/student.txt");
			//产生了一个文件字符输入流对象
			BufferedReader br=new BufferedReader(fr);
			//以上一个对象作为参数来创建一个缓冲的字符输入流对象
			String str=br.readLine();//读取一行数据
			boolean flag=true;
			while(flag)
			{
				String temp=str;
				if(!bool)
				{
					temp=str.substring(4);
				}
				if(temp.startsWith(para.trim()))
				{
					result=str;
					flag=false;
				}
				str=br.readLine();//继续读取下一行
				if(str==null)
				{
					flag=false;
				}
			}
			br.close();
			fr.close();
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("文件未找到");
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("文件读错误");
		}
		return result;
	}

	//增加一条学生记录
	public boolean addStudent(String stuinfo)
	{
		String[] strs=stuinfo.split(",");
		if(!numIsExist(strs[0]))
		{
			try {
				FileWriter fw=new FileWriter("/Users/gong/Documents/JAVA/Test16/student.txt",true);
				//创建一个文件的字符输出流,第二个参数表示是在文件尾部进行追加
				BufferedWriter bw=new BufferedWriter(fw);
				//以上面创建的对象为参数创建一个缓冲字符输出流
				bw.newLine();
				//创建新的一行
				bw.write(stuinfo);
				bw.close();
				fw.close();
			}
			catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("文件未找到");
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("文件写错误");
			}
			return true;
		}
		else
		{
			return false;
		}
	}

	//判断是否已经存在重复的学号
	private boolean numIsExist(String num)
	{
		boolean result=false;
		try {
			FileReader fr=new FileReader("/Users/gong/Documents/JAVA/Test16/student.txt");
			//产生了一个文件字符输入流对象
			BufferedReader br=new BufferedReader(fr);
			//以上一个对象作为参数来创建一个缓冲的字符输入流对象
			String str=br.readLine();//读取一行数据
			while(str!=null)
			{
				if(str.startsWith(num))
				{
					result=true;
					break;
				}
				str=br.readLine();
			}

			br.close();
			fr.close();
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("文件未找到");
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("文件读错误");
		}
		return result;
	}

	//增加多条学生记录
	public int addStudents(String[] stus)
	{
		int result=0;
		//定义一个变量来保存添加成功的学生记录个数
		if(stus!=null)
		{
			if(stus.length>0)
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
		//保存删除是否成功的变量
		try
		{
			FileReader fr=new FileReader("/Users/gong/Documents/JAVA/Test16/student.txt");
			//产生了一个文件字符输入流对象
			BufferedReader br=new BufferedReader(fr);
			//以上一个对象作为参数来创建一个缓冲的字符输入流对象
			String str=br.readLine();//读取一行数据
			ArrayList<String> list=new ArrayList<String>();
			//保存读入的学生信息
			boolean flag=true;
			while(flag)
			{
				list.add(str);
				str=br.readLine();//再次读取一行数据
				if(str==null)
				{
					flag=false;
				}
			}
			br.close();
			fr.close();
			for(int i=0;i<list.size();i++)
			{
				if(list.get(i).startsWith(num))
				{
					list.remove(i);
					result=true;
					break;
				}
			}//将对应的学生记录移除
			FileWriter fw=new FileWriter("/Users/gong/Documents/JAVA/Test16/student.txt");
			//创建一个文件的字符输出流,不需要追加
			BufferedWriter bw=new BufferedWriter(fw);
			//以上面创建的对象为参数创建一个缓冲字符输出流
			for(int i=0;i<list.size();i++)
			{
				bw.write(list.get(i));
				//分别写入学生记录
				bw.newLine();
			}
			bw.flush();
			bw.close();
			fw.close();
		}
		catch(IOException ex)
		{

		}
		return result;
	}
	//删除多条学生记录的方法
	public int deleteStus(String[] nums)
	{
		int result=0;
		//用来保存成功删除的学生记录个数
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

	//修改一条记录的方法
	public boolean updateStudent(String stuinfo)
	{
		String[] strs=stuinfo.split(",");
		if(numIsExist(strs[0]))
		{
			try
			{
				FileReader fr=new FileReader("/Users/gong/Documents/JAVA/Test16/student.txt");
				//产生了一个文件字符输入流对象
				BufferedReader br=new BufferedReader(fr);
				//以上一个对象作为参数来创建一个缓冲的字符输入流对象
				String str=br.readLine();//读取一行数据
				ArrayList<String> list=new ArrayList<String>();
				//保存读入的学生信息
				boolean flag=true;
				while(flag)
				{
					list.add(str);
					str=br.readLine();//再次读取一行数据
					if(str==null)
					{
						flag=false;
					}
				}
				br.close();
				fr.close();

				for(int i=0;i<list.size();i++)
				{
					if(list.get(i).startsWith(strs[0]))
					{
						list.remove(i);
						//先从动态数组对象中移除
						list.add(stuinfo);
						//然后再添加修改后的学生记录
						break;
					}
				}//将对应的学生记录移除
				FileWriter fw=new FileWriter("/Users/gong/Documents/JAVA/Test16/student.txt");
				//创建一个文件的字符输出流,不需要追加
				BufferedWriter bw=new BufferedWriter(fw);
				//以上面创建的对象为参数创建一个缓冲字符输出流
				for(int i=0;i<list.size();i++)
				{
					bw.write(list.get(i));
					//分别写入学生记录
					bw.newLine();
				}
				bw.flush();
				bw.close();
				fw.close();
			}
			catch(IOException ex)
			{

			}
			return true;
		}
		else
		{
			return false;
		}
	}
	//修改多条学生记录
	public int updateStus(String[] stus)
	{
		int result=0;
		if(stus!=null)
		{
			if(stus.length>0)
			{
				for(int i=0;i<stus.length;i++)
				{
					if(updateStudent(stus[i]))
					{
						result++;
					}
				}
			}
		}
		return result;
	}
}
