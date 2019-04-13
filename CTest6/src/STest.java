
public class STest {

	public static void main(String[] args) {
		StudentDAO dao=new StudentDAO();
		System.out.println(dao.findStuByPara("001", 1));
		System.out.println(dao.findStuByPara("张三", 2));
		System.out.println(dao.addStudent("006,丁一,男"));
		String[] strs={"001,张三,男","007,王红,女","008,张凡,男"};
		System.out.println("成功添加了"+dao.addStudents(strs)+"条学生记录");
//		System.out.println(dao.deleteStudent("008"));
//		String[] nums={"002","001","004"};
//		System.out.println("成功删除了"+dao.deleteStudents(nums)+"条学生记录");
//		dao.updateStudent("003,王五,女");
		System.out.println("hhhh");
	}

}
