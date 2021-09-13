package proj_04;

/*---------------------------
 *         4주차 과제
 * ---------------------------
 * 페이지 네비게이션의 html 코드 출력
 * 날 짜 : 2021.9.5 (일)
 * 작성자 : 박민지 
 * --------------------------*/

public class week04 {
	public static void main(String[] args) {
		long totalCount=4;
		long pageIndex=1;
		
		Pager pager=new Pager(totalCount);
		System.out.println(pager.html(pageIndex));
	}
}
