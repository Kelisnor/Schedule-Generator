import java.util.Random;

public class ableTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student[] stu = new Student[25];
		
		Class[] cl = new Class[15];
		//populates the student objects
		for(int i = 0; i <stu.length; i++) {
			stu[i] = new Student(Integer.toString(i), Integer.toString(i*i), new Schedule("", "", "", "", "", "", "", "") );
		}
		
		for(int i = 0; i < cl.length; i++) {
			//randomly makes a number num, for the capacity
			Random r = new Random();
			int num = r.nextInt((10 - 5) + 1) + 5;
			//letter randomly assigns a letter based on the ascii value in String form
			String letter = (char) (r.nextInt((72 - 65) + 1) + 65) + "";
			//puts all the randomly classes together
			cl[i] = new Class(num,"ID: " + i , letter);
		}
		
		
		stu = pop(stu,cl);
		
		for(int i = 0; i < stu.length; i++) {
			System.out.println(stu[i].toString());
		}
		
		
		
		
		
		//for(int i = 0; i < cl.length; i++) {
			//System.out.println(cl[i].toString());
		//}
		
	}
	
	public static Student[] pop(Student[] stu, Class[] cl) {
		for(int i=0;i<stu.length;i++) {
			Schedule a = new Schedule(null, null, null, null, null, null, null, null);
			a.setA(cl[(int)(Math.random()*cl.length)].getName());
			a.setB(cl[(int)(Math.random()*cl.length)].getName());
			a.setC(cl[(int)(Math.random()*cl.length)].getName());
			a.setD(cl[(int)(Math.random()*cl.length)].getName());
			a.setE(cl[(int)(Math.random()*cl.length)].getName());
			a.setF(cl[(int)(Math.random()*cl.length)].getName());
			a.setG(cl[(int)(Math.random()*cl.length)].getName());
			a.setH(cl[(int)(Math.random()*cl.length)].getName());
			stu[i].setSc(a);
		}
		return stu;
	}

	
	
}













