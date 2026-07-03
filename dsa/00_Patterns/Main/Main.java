
public class Main
{
	public static void main(String[] args) {
		// pattern 1
// 		int n = 6;
// 		for (int i = 0; i < n; i++) {
// 		    for (int j = 0; j < n; j++) {
// 		        System.out.print("* ");
// 		    }
// 		    System.out.println();
// 		}
		
		// pattern 2
		int n = 6;
		for (int i = 0; i < n; i++) {
		    for (int j = 0; j <= i; j++) {
		        System.out.print("* ");
		    }
		    System.out.println();
		}
	}
}
