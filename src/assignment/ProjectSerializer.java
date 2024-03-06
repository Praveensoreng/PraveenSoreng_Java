package assignment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectSerializer {
	List<Employee> elist1;
	List<Employee> elist2;
	List<Employee> elist3;

	Map<Project, List<Employee>> projectMap1;
	String fileName = "projectEmployeeDetails.ser";

	public ProjectSerializer() {

		this.elist1 = new ArrayList<>();
		this.elist2 = new ArrayList<>();
		this.elist3 = new ArrayList<>();
		this.projectMap1 = new HashMap<>();

	}

	public void serializeProjectDetails(Map<Project, List<Employee>> projectMap) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(fileName)))) {
			oos.writeObject(projectMap);
			System.out.println("Project Employee Details has been serialized successfully!");
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void deserializeProjectDetails() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(fileName)))) {
			try {
				Object object = ois.readObject();
				Map<Project, List<Employee>> projectMap = (Map<Project, List<Employee>>) object;

				for(Map.Entry<Project, List<Employee>> entry : projectMap.entrySet()) {
					System.out.println("DeSerialized Data :");
					System.out.println("The Project");
					System.out.println(entry.getKey());
					System.out.println("Has following Employees");
					System.out.println(entry.getValue() + "\n");
					
				}
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

//void displayProjectMap() {
//	for(Map.Entry<Project , List<Employee>> entry : projectMap1.entrySet()) {
//		System.out.println(entry.getKey() + "\n" + entry.getValue() + "\n");
//	}
//	System.out.println();
//	
//}

}
