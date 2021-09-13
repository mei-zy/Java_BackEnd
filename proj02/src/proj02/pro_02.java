package proj02;

import java.io.*;

/* 자바 2주차 과제
 * 제출자 : 박민지
 */
public class pro_02 {

	public static void main(String args[]) {
		System.out.println("실행");
		try {
			File file = new File("property.html");
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			
			/*html 생성시 head 태그에 추가 내용*/
			writer.write("<head>");
			writer.write("<h2>자바 환경정보</h2>");
			writer.write("\r\n\t <meta charset=\\\"UTF-8\\\"/>");
			writer.write("\r\n\t <style>\r\n\t\t");
			writer.write("table {border-collapse:collapse; width:100%;}");
			writer.write("\r\n\t\t th,td{border:solid 1px #000;padding:10px 5px;}");
			writer.write("\r\n\t </style>\r\n</head>");
			/*테이블 생성*/
			writer.write("\r\n <body><table>\r\n");
			writer.write("\r\n\t<tr>");
			writer.write("\r\n\t\t<th>키</th><th> </tr></tr>");
	
			for (Object k : System.getProperties().keySet()) {
				String key = k.toString();
				String value = System.getProperty(key);
				writer.write("\r\n\t<tr>");
				writer.write("\r\n\t<td>"+key+"</td>");
				writer.write("\r\n\t<td>"+value+"</td>");
			}
			writer.write("\r\n</table></body>");

			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
