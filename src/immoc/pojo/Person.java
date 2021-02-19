package src.immoc.pojo;

import java.io.Serializable;

public class Person implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public  transient String sex ;
	public transient int frend ;
	public String name ;
	public int age ;
	public String getName() {
		return name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getFrend() {
		return frend;
	}
	public void setFrend(int frend) {
		this.frend = frend;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [sex=" + sex + ", frend=" + frend + ", name=" + name
				+ ", age=" + age + "]";
	}
	

}
