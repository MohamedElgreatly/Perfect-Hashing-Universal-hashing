
public class Main {

	public static void main(String[] args) {
		Integer values[]= {10,20,12,13,45,14,15,16,17,18,22,19,30,23,24,29,25,28};
		NNSpaceSolution obj =new NNSpaceSolution(values);
		obj.hashForm();
		obj.printHashTable();
		System.out.println();
		System.out.println(obj.numb_collision());
		
		//read txt file
		
	}

}
