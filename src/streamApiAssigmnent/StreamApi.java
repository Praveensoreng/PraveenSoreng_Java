package streamApiAssigmnent;

import java.util.Arrays;
import java.util.List;

public class StreamApi {

	public static void main(String[] args) {
	List<Integer> list = Arrays.asList(1,2,3,4,5);
	
	Integer result = list.stream().filter(i -> i%2 != 0).mapToInt(i -> i*i).sum();
	System.out.println(result);

	}

}
