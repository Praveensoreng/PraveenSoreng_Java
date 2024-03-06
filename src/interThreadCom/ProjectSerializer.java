package interThreadCom;

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
	List<Employee> eList1;
	List<Employee> eList2;
	List<Employee> eList3;
	List<Employee> eList4;
	List<Employee> eList5;
	List<Employee> eList6;

	Map<Project, List<Employee>> hMap1;
	Map<Project, List<Employee>> hMap2;
	Map<Project, List<Employee>> hMap3;

	String fileName = "projectEmployeeDetail.ser";

	public ProjectSerializer() {
		super();

		this.eList1 = new ArrayList<>();
		this.eList2 = new ArrayList<>();
		this.eList3 = new ArrayList<>();
		this.eList4 = new ArrayList<>();
		this.eList5 = new ArrayList<>();
		this.eList6 = new ArrayList<>();

		this.hMap1 = new HashMap<>();
		this.hMap2 = new HashMap<>();
		this.hMap3 = new HashMap<>();
	}

	boolean status = true;

	// serialization Method

	public synchronized void serializeProjectDetails(Map<Project, List<Employee>> projectMap) {
		while (status == false) {
			try {
				wait();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

		System.out.println("serialized called by " + Thread.currentThread().getName());
		System.out.println("Data to be Serialized:");
		for (Map.Entry<Project, List<Employee>> entry : projectMap.entrySet()) {
			System.out.println();

			System.out.println(entry.getKey());
			System.out.println();

			System.out.println(entry.getValue() + "\n");

		}
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(fileName)))) {
			oos.writeObject(projectMap);
			System.out.println("Project Employee Details has been serialized successfully!");
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		status = false;
		notifyAll();
	}

	// deserialization Method

	public synchronized void deserializeProjectDetails() {

		while (status == true) {
			try {

				wait();

			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
		System.out.println();
		System.out.println("Deserialized called by" + " " + Thread.currentThread().getName());
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(fileName)))) {
			try {
				System.out.println("Deserialized Data:");
				Object object = ois.readObject();
				Map<Project, List<Employee>> projectMap = (Map<Project, List<Employee>>) object;

				for (Map.Entry<Project, List<Employee>> entry : projectMap.entrySet()) {
					System.out.println();
					System.out.println("The Project:");
					System.out.println(entry.getKey());
					System.out.println();
					System.out.println("Has following Employees:");
					System.out.println(entry.getValue() + "\n");

				}
				System.out.println("********************************************************");
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		status = true;
		notifyAll();
	}

}
