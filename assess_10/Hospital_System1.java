package assess_10;

import java.util.*;
 
public class Hospital_System1 implements Comparable<Hospital_System1> {
int id;
String name;
 
public Hospital_System1(int id, String name)
{
	this.id=id;
	this.name=name;
}
@Override
public int compareTo(Hospital_System1 p)
{
	return this.id - p.id;
}
@Override
public String toString()
{
	return id + " - " + name;
}
 
public static void main(String[] args)
	{
	TreeSet<Hospital_System1> patients=new TreeSet<>();
	
	patients.add(new Hospital_System1(101, "Vinay"));
	patients.add(new Hospital_System1(102, "Sonali"));
	patients.add(new Hospital_System1(103, "Radhya"));
	patients.add(new Hospital_System1(101, "Vinay"));
	
	System.out.println("Unique Registered Patients");
	for(Hospital_System1 p: patients)
	{
		System.out.println(p);
	}
 
	}
 
}
 
 