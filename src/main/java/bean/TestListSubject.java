package bean;

import java.util.HashMap;
import java.util.Map;

public class TestListSubject implements java.io.Serializable{
	private int entYear;
	private String studentNo;
	private String studentName;
	private String classNum;
	private Map<Integer,Integer> points=new HashMap<>();
//	ここもどうするのかわからね
	public TestListSubject(){};
	public int getEntYear() {
		return entYear;
	}
	
	public String getStudentNo() {
		return studentNo;
	}
	
	public String getStudentName() {
		return studentName;
	}
	
	public String getClassNum() {
		return classNum;
	}
	
	public Map<Integer,Integer> getPoints(){
		return points;
	}
//	ここもわからん
	public String getPoint(int key) {
		return points.get(key).toString();
	}
	
	public void setEntYear(int entYear) {
		this.entYear=entYear;
	}
	
	public void setStudentNo(String student_no) {
		this.studentNo=student_no;
	}
	
	public void setStudentName(String student_name) {
		this.studentName=student_name;
	}
	
	public void setClassNum(String classNum) {
		this.classNum=classNum;
	}
	
	public void setPoints(Map<Integer,Integer> points) {
		this.points=points;
	}
	
//	ここもわからん
	public void putPoint(int key,int value) {
		this.points.put(key,value);
	}
	
}