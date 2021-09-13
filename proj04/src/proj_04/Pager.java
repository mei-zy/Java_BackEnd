package proj_04;

public class Pager {
	StringBuffer sb=new StringBuffer();
	
	long totalCount;
	long MaxPage=10;
	/*한 페이지당 출력할 max page 변수 =10개 */ 
	long MaxPost=10;
	/*한 페이지당 출력할 max 게시글 변수=10개*/
	
	/*pager의 생성자*/
	public Pager(long totalCount) {
		// TODO Auto-generated constructor stub
		this.totalCount=totalCount;
	}
	 
	/*총 있어야 하는 페이지 수 계산
	  ex. 127페이지면 -> 13 리턴 */
	public long TotalPageIndex(){
		if (totalCount%MaxPost!=0)
			return totalCount/MaxPost+1;
		/*만약 나머지가 0이 아니라면 1페이지를 추가시켜준다*/
		
		return totalCount/MaxPost;
		
	}
	
	/*첫 번째 페이지를 출력해준다.
	 * 만약, PageIndex=2 라면 return 1,
	 * PageIndex=13이라면, return 11 */
	
	public long PrintFirstPage(long a) {
		if(a%MaxPage!=0)
			return (a/MaxPage)*MaxPage+1;
		return a-(MaxPage-1);
	}
	
	
	
	/*출력할 last페이지 수를 계산한다.
	 * 만약 12페이지라면, 20페이지가 마지막 페이지가 된다.*/
	public long PrintLastPage(long a) {
		return PrintFirstPage(a)+MaxPage;
	}
	
	
	/*페이지 html 출력 함수*/
	public String html(long pageIndex) {
		// TODO Auto-generated method stub
		sb.append("<a href='#'>[처음]</a>\n");
		sb.append("<a href='#'>[이전]</a>\n");
		sb.append("\n");
		
		for(long i=PrintFirstPage(pageIndex);i<PrintLastPage(pageIndex);i++) {
			
			// 마지막 페이지보다 totalpage수가 적다면 break문으로 빠져나가야함
			if(i>TotalPageIndex())
				break;
			
			/*만약 pageIndex 번호면 class='on' 출력해주어야함*/
			if(pageIndex==i) {
				sb.append("<a href='#' class='on'> ");
				sb.append(i);
				sb.append(" </a>\n");
			}
			else {
				sb.append("<a href='#'>");
				sb.append(i);
				sb.append(" </a>\n");
			}
		}
		
		/*페이지 수 출력*/
		sb.append("\n");
		sb.append("<a href='#'>[다음]</a>\n");
		sb.append("<a href='#'>[마지막]</a>");
		return sb.toString();
	}

}
