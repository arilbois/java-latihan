public class Random{
	public static void main(String[] args){
		int randomNum = 1 + (int) (Math.random() * 101);
		for(int i = 0; i < 3; i++){
			System.out.println(randomNum);
		}
	}
}