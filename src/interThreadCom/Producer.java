package interThreadCom;

import java.util.List;
import java.util.Map;

public class Producer extends Thread {

	ProjectSerializer projectSerializer;
	Map<Project, List<Employee>> hMap;

	public Producer(Map<Project, List<Employee>> hMap, ProjectSerializer projectSerializer, String s) {
		super(s);
		this.hMap = hMap;

		this.projectSerializer = projectSerializer;

	}

	@Override
	public void run() {

		projectSerializer.serializeProjectDetails(hMap);

	}

}
