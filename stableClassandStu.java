import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class stableClassandStu {

	public static ArrayList<Student> genStu(ArrayList<Class> cl) throws FileNotFoundException{
		int MAXSTU = 50;
		int MAXCL = cl.size()-2;
    	Scanner file = new Scanner(new File("C:\\Users\\drogers\\Desktop\\subjects.txt")).useDelimiter("\n");
    	
    	String[] subjects =  take(file);
    	
    	 file = new Scanner(new File("C:\\Users\\drogers\\Desktop\\fnames.txt")).useDelimiter("\n");
    	String[] fnames = take(file);
    	
    	 file = new Scanner(new File("C:\\Users\\drogers\\Desktop\\lNames.txt")).useDelimiter("\n");
    	String[] lnames = take(file);
    	
		ArrayList<Student> stu = new ArrayList<Student>();
		
  
		int x = 0;
		ArrayList<String> pref = new ArrayList<String>();
		for(int i =0; i < MAXSTU;) {
			pref.add(cl.get(x).getName());
			x++;

			if(x >= 25) {
				x=0;
			}
			
			if(pref.size() == 7) {
			pref.add("Lunch");
			stu.add(new Student(fnames[i], lnames[i], new Schedule(" \n ", " \n ", " \n ", " \n ", " \n ", " \n ", " \n ", " \n "), pref ));
			pref = new ArrayList<String>();
			i++;
			}
		}
		
		/*for(int i = 0; i < MAXSTU; i++) {
		System.out.println(stu.get(i).getfName()+ " " + stu.get(i).getlName().replaceAll("\n", "")+ "\n" + " " +stu.get(i).listPrint()+"\n");
		}*/
		return stu;
	}
	
	
	public static ArrayList<Class> genClass() throws FileNotFoundException{
		int MAXCLASS = 25;
		
    	Scanner file = new Scanner(new File("C:\\Users\\drogers\\Desktop\\subjects.txt")).useDelimiter("\n");
    	
    	String[] subjects =  take(file);
    	
    	Class gLunch = new  Class(1000, "Lunch", "G");
    	Class hLunch = new  Class(1000, "Lunch", "H");
    	
		ArrayList<Class> cl = new ArrayList<Class>();
		String letter = "";
		int num;
		int x=0;
			
		for(int i = 0; i < MAXCLASS; i++) {

			if(i % 2 == 0) {
				if(i % 3 == 0) {
					letter = "A";
				}
				else if((i >= 7) && (i <10) || i > 17) {
					letter = "B";
				}
				else if(i <= 6) {
					letter = "C";
				}
				else {
					letter = "D";
				}
			}
			else {
				if(i % 3 == 0) {
					letter = "E";
				}
				else if((i > 10) && (i <15) || i >= 17) {
					letter = "F";
				}
				else if(i < 7) {
					letter = "G";
				}
				else {
					letter = "H";
				}
			}
			
			if(i%2==0) {
				num = 10;
			}
			else {
				num = 5;
			}
			
			cl.add(new Class(num,"" + subjects[i] + " ", letter));
		}
		cl.add(gLunch);
		cl.add(hLunch);
		
		return cl;
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		ArrayList<Class> cl = genClass();
		ArrayList<Student> stu = genStu(cl);
		/*
		for(int i = 0; i < cl.size(); i++) {
			System.out.print("Name: " +cl.get(i).getName());
			System.out.println("Block: " + cl.get(i).getBlock());
			System.out.println("Max: " + cl.get(i).getMax());
		}*/
		
		
		/*
		for(int i = 0; i < stu.size(); i++) {
			System.out.println(stu.get(i).listPrint());
		}*/
		
		
		
		
		/*int MAXCLASS = 25;
		int MAXSTU = 50;
		
    	Scanner file = new Scanner(new File("C:\\Users\\drogers\\Desktop\\subjects.txt")).useDelimiter("\n");
    	
    	String[] subjects =  take(file);
    	
    	 file = new Scanner(new File("C:\\Users\\drogers\\Desktop\\fnames.txt")).useDelimiter("\n");
    	String[] fnames = take(file);
    	
    	 file = new Scanner(new File("C:\\Users\\drogers\\Desktop\\lNames.txt")).useDelimiter("\n");
    	String[] lnames = take(file);
    	
		Student[] stu = new Student[MAXSTU];
		
    	Class gLunch = new  Class(1000, "Lunch", "G");
    	Class hLunch = new  Class(1000, "Lunch", "H");
    	
		Class[] cl = new Class[MAXCLASS +2];
		String letter = "";
		int num;
		int x=0;
			
		for(int i = 0; i < MAXCLASS; i++) {

			if(i<3) {
				 letter ="A";
			}
			else if(i > 2 && i < 6) {
				letter = "B";
			}
			else if(i > 5 && i < 9) {
				letter = "C";
			}
			else if(i > 8 && i < 12) {
				letter = "D";
			}
			else if(i > 11 && i < 15) {
				letter = "E";
			}
			else if(i > 14 && i < 18) {
				letter = "F";
			}
			else if(i > 17 && i < 21) {
				letter = "G";
			}
			else if(i > 20 && i < 24) {
				letter = "H";
			}
			else {
				letter = "A";
			}
			
			if(i%2==0) {
				num = 10;
			}
			else {
				num = 5;
			}
			
			cl[i] = new Class(num,"" + subjects[i] + " ", letter);
		}
		cl[MAXCLASS] = gLunch;
		cl[MAXCLASS+1] = hLunch;

		ArrayList<String> pref = new ArrayList<String>();
		for(int i =0; i < stu.length;) {
			pref.add(cl[x].getName());
			x++;

			if(x >= 25) {
				x=0;
			}
			
			
			//pref.clear();
			if(pref.size() == 7) {
			pref.add("Lunch");
			stu[i] = new Student(fnames[i], lnames[i], new Schedule(" \n ", " \n ", " \n ", " \n ", " \n ", " \n ", " \n ", " \n "), pref );
			i++;
			pref = new ArrayList<String>();
			}
		}
		
		for(int i = 0; i < stu.length; i++) {
		System.out.println(stu[i].getfName()+ " " + stu[i].getlName().replaceAll("\n", "")+ "\n" + " " +stu[i].listPrint()+"\n");
		}*/
		
	}
	public static  String[] take(Scanner inFile1){
		
		String token1 = "\n";
	    ArrayList<String> temps = new ArrayList<String>();

	    // while loop
	    while (inFile1.hasNext()) {
	      // find next line
	      token1 = inFile1.next();
	      temps.add(token1);
	    }
	    inFile1.close();

	    String[] tempsArray = temps.toArray(new String[0]);


	    return tempsArray;
	}

}


