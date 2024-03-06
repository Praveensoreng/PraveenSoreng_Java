package interThreadCom;

public class InterThreadComTest {

	public static void main(String[] args) {
		
		ProjectSerializer projectSerializer = new ProjectSerializer();
		
		Employee e1 = new Employee("E001","Harsha","9383993933","RTNagar",1000);
		Employee e2 = new Employee("E002","Harish","9354693933","Jayanagar",2000);
		Employee e3 = new Employee("E003","Meenal","9383976833","Malleswaram",1500);
		Employee e4 = new Employee("E004","Sundar","9334593933","Vijayanagar",3000);
		Employee e5 = new Employee("E005","Suman","9383678933","Indiranagar",2000);
		Employee e6 = new Employee("E006","Suma","9385493933","KRPuram",1750);
		Employee e7 = new Employee("E007","Chitra","9383978933","Koramangala",4000);
		Employee e8 = new Employee("E008","Suraj","9383992133","Malleswaram",3000);
		Employee e9 = new Employee("E009","Manu","9345193933","RTNagar",2000);
		Employee e10 = new Employee("E010","Kiran","9383975673","Koramangala",4000);
		Employee e11 = new Employee("E011","Mrinal","9383992789","Malleswaram",3000);
		Employee e12 = new Employee("E012","Mahesh","9345193763","RTNagar",2000);
		
		
		projectSerializer.eList1.add(e1);
		projectSerializer.eList1.add(e2);
		projectSerializer.eList2.add(e3);
		projectSerializer.eList2.add(e4);
		projectSerializer.eList3.add(e5);
		projectSerializer.eList3.add(e6);
		projectSerializer.eList4.add(e7);
		projectSerializer.eList4.add(e8);
		projectSerializer.eList5.add(e9);
		projectSerializer.eList5.add(e10);
		projectSerializer.eList6.add(e11);
		projectSerializer.eList6.add(e12);
		
		Project project1 = new Project("P1","Music Synthesizer",23);
		Project project2 = new Project("P2","Vehicle Movement Tracker",13);
		Project project3 = new Project("P3","Liquid Viscosity Finder",15);
		Project project4 = new Project("P4","InsuranceTool",23);
		Project project5 = new Project("P5","BankingTool",13);
		Project project6 = new Project("P6","PayrollTool",15);
		
		projectSerializer.hMap1.put(project1, projectSerializer.eList1);
		projectSerializer.hMap1.put(project2, projectSerializer.eList2);
		projectSerializer.hMap2.put(project3, projectSerializer.eList3);
		projectSerializer.hMap2.put(project4, projectSerializer.eList4);
		projectSerializer.hMap3.put(project5, projectSerializer.eList5);
		projectSerializer.hMap3.put(project6, projectSerializer.eList6);
		
		Producer producer1 = new Producer(projectSerializer.hMap1,projectSerializer,"Producer1");
		Consumer consumer1 = new Consumer(projectSerializer,"Consumer1");
		Producer producer2 = new Producer(projectSerializer.hMap2,projectSerializer,"Producer2");
     	Consumer consumer2 = new Consumer(projectSerializer,"Consumer2");
		Producer producer3 = new Producer(projectSerializer.hMap3,projectSerializer,"Producer3");
		Consumer consumer3 = new Consumer(projectSerializer,"Consumer3");
		
		producer1.start();
		producer2.start();
		producer3.start();
		
		consumer1.start();
		consumer2.start();
     	consumer3.start();
		

	}

}
