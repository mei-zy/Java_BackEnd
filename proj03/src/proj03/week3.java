package proj03;
import java.util.Scanner;

public class week3 {

	static int[] X_arr=new int[10];
	static int[] Y_arr=new int[10];
	static int my_X;
	static int my_Y;
	
	// X�� ���� �ߺ��˻�
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
	
	//�迭���� ���� ���� �� �ε��� ���ϱ�
	public static int Min(double closeInt[]) {
		int min_index=0;
		for(int j=1;j<10;j++) {
			if(closeInt[min_index]>closeInt[j])
				min_index=j;
		}
		return min_index;
	}
	
	//��ǥ���ϱ�
	public static double Coordinate(int x, int y) {
		return Math.sqrt(x*x+y*y);
	}
	
	public static void main(String args[]) {
		double[] close=new double[10];
		Scanner sc=new Scanner(System.in);
		
		System.out.println("�� ��ǥ X���� �Է��� �ּ���.");
		my_X=sc.nextInt();
		System.out.println("�� ��ǥ Y���� �Է��� �ּ���.");
		my_Y=sc.nextInt();
		
		int i=0;
		while(i<10) {
			System.out.println((i+1)+"/10��° �Է�");
			/*�Է� �ޱ�*/
			System.out.println("������ ��ǥ X���� �Է��� �ּ���.");
			X_arr[i]=sc.nextInt();
			System.out.println("������ ��ǥ Y���� �Է��� �ּ���.");
			Y_arr[i]=sc.nextInt();
			
			/*�ߺ� �˻�*/
			if (SameEnter_X(X_arr[i],Y_arr[i],i)==false) {
				System.out.println("������ ��ǥ���� �̹� �����մϴ�. �ٽ� �Է��� �ּ���.");
				continue;
			}
			else {
				//��ǥ���ϱ�
				close[i]=Coordinate(X_arr[i],Y_arr[i]);
				i++;
			}
		}
		
		for(i=0;i<10;i++) {
			System.out.println("("+X_arr[i]+" , "+Y_arr[i]+") => "+close[i]);
		}
		int t=Min(close);
		System.out.println(t);
		System.out.println("���� ����� ��ǥ :\n ("+X_arr[t]+","+Y_arr[t]+") =>"+close[t]);
	}

}
