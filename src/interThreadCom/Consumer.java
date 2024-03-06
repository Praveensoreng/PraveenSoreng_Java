package interThreadCom;

public class Consumer extends Thread {
	ProjectSerializer projectSerializer;

	public Consumer(ProjectSerializer projectSerializer, String s) {
		super(s);
		this.projectSerializer = projectSerializer;

	}

	@Override
	public void run() {

		projectSerializer.deserializeProjectDetails();

	}
}
