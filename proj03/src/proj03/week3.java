package proj03;
import java.util.Scanner;

public class week3 {

	static int[] X_arr=new int[10];
	static int[] Y_arr=new int[10];
	static int my_X;
	static int my_Y;
	
	// X에 대한 중복검사
	public static boolean SameEnter_X(int x,int y,int count) {

		for(int j=0;j<(count-1);j++) {
			if(X_arr[j]==x) {
				for(int z=0;z<(count-1);z++) {
					if(Y_arr[z]==y)
						return false;
				}
			}
		}
		return true;
	}
	
	//배열에서 가장 작은 수 인덱스 구하기
	public static int Min(double closeInt[]) {
		int min_index=0;
		for(int j=1;j<10;j++) {
			if(closeInt[min_index]>closeInt[j])
				min_index=j;
		}
		return min_index;
	}
	
	//좌표구하기
	public static double Coordinate(int x, int y) {
		return Math.sqrt(x*x+y*y);
	}
	
	public static void main(String args[]) {
		double[] close=new double[10];
		Scanner sc=new Scanner(System.in);
		
		System.out.println("내 좌표 X값을 입력해 주세요.");
		my_X=sc.nextInt();
		System.out.println("내 좌표 Y값을 입력해 주세요.");
		my_Y=sc.nextInt();
		
		int i=0;
		while(i<10) {
			System.out.println((i+1)+"/10번째 입력");
			/*입력 받기*/
			System.out.println("임의의 좌표 X값을 입력해 주세요.");
			X_arr[i]=sc.nextInt();
			System.out.println("임의의 좌표 Y값을 입력해 주세요.");
			Y_arr[i]=sc.nextInt();
			
			/*중복 검사*/
			if (SameEnter_X(X_arr[i],Y_arr[i],i)==false) {
				System.out.println("동일한 좌표값이 이미 존재합니다. 다시 입력해 주세요.");
				continue;
			}
			else {
				//좌표구하기
				close[i]=Coordinate(X_arr[i],Y_arr[i]);
				i++;
			}
		}
		
		for(i=0;i<10;i++) {
			System.out.println("("+X_arr[i]+" , "+Y_arr[i]+") => "+close[i]);
		}
		int t=Min(close);
		System.out.println(t);
		System.out.println("제일 가까운 좌표 :\n ("+X_arr[t]+","+Y_arr[t]+") =>"+close[t]);
	}

}
