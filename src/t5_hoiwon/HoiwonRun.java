package t5_hoiwon;

import java.util.ArrayList;
import java.util.Scanner;

public class HoiwonRun {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		HoiwonDAO dao = new HoiwonDAO();
		boolean run = true;
		String name = "";
		HoiwonVO vo = null;
		
		while(run) {
			System.out.print("1:전체조회 | 2:개별조회 | 3:회원가입 | 4:수정 | 5:삭제 | 6:종료 >> ");
			int no = scanner.nextInt();
				
			switch(no) {
				case 1:
					// 전체 회원 조회하기
					ArrayList<HoiwonVO> vos = dao.getList();	// 전체검색 호출
					
					 System.out.println("\t\t** 주 소 록 **");
					 System.out.println("=".repeat(50));
					 System.out.println("번호\t성명\t나이\t주소\t성별");
					 System.out.println("-".repeat(50));
					for(HoiwonVO v : vos) {
						 System.out.print(v.getIdx() +"\t");
						 System.out.print(v.getName() +"\t");
						 System.out.print(v.getAge() +"\t");
						 System.out.print(v.getAddress() + "\t");
						 System.out.print(v.getGender()+"\n");
						 System.out.println("-".repeat(50));
					 }
					 System.out.println("=".repeat(50));
					 System.out.println("총 회원 : "+vos.size()+"명");
					 
					break;
				case 2:
					// 개별 회원 조회하기
					System.out.print("검색할 회원명을 입력 >> ");
					name = scanner.next();
					System.out.println();
					System.out.println("-".repeat(40));
					
					vo = dao.getSearch(name);	// 개별검색 호출
//					if(vo != null) {	// vo값은 null값이 되지않으므로 46번라인과 비교하지 않는다.
					if(vo.getName() != null) {
						System.out.println("번호 : " + vo.getIdx());
						System.out.println("성명 : " + vo.getName());
						System.out.println("나이 : " + vo.getAge());
						System.out.println("주소 : " + vo.getAddress());
						System.out.println("성별 : " + vo.getGender());
					}
					else {
						System.out.println(name + "님의 자료가 없습니다.");
					}
					break;
				case 3: // 회원가입 하기
//					System.out.print("회원 성명을 입력하세요 >> ");
//					name = scanner.next();
//					System.out.print("회원 나이를 입력하세요 >> ");
//					int age = scanner.nextInt();
//					System.out.print("회원 주소를 입력하세요 >> ");
//					String address = scanner.next();
//					System.out.print("회원 성별을 입력하세요(1:남자|2:여자) >> ");
//					int gender = scanner.nextInt();
//					dao.setHoiwonInput(name,age,address,gender);	// 회원가입 메소드 호출
					
					vo = new HoiwonVO();
					System.out.print("회원 성명을 입력하세요 >> ");
					vo.setName(scanner.next());
					System.out.print("회원 나이를 입력하세요 >> ");
					vo.setAge(scanner.nextInt());
					System.out.print("회원 주소를 입력하세요 >> ");
					vo.setAddress(scanner.next());
					System.out.print("회원 성별을 입력하세요(1:남자|2:여자) >> ");
					int gender = scanner.nextInt();
					if(gender == 1) vo.setGender("남자");
					else vo.setGender("여자");
					int res = dao.setHoiwonInput(vo);	// 회원가입 메소드 호출
					if(res == 0) System.out.println(vo.getName()+"님 회원 가입에 실패하셨습니다.");
					else System.out.println(vo.getName()+"님 가입이 완료되었습니다.");
					
					break;
				case 4: // 수정하기
					System.out.print("수정할 회원명을 입력하세요 >> ");
					name = scanner.next();
					
					vo = dao.getSearch(name);
					if(vo.getName() == null) System.out.println(name + "님의 자료가 존재하지 않습니다.");
					else {
						System.out.println("-".repeat(40));
						System.out.println("수정할 항목의 번호를 입력하세요");
						System.out.print(("1:나이 | 2:주소 | 3:성별 | 4:종료 >> "));
						no = scanner.nextInt();
						
						int age = vo.getAge();
						String address = vo.getAddress();
						String strGender = vo.getGender();
						
						switch(no) {
							case 1:
								System.out.print("수정할 나이를 입력하세요 >> ");
								age = scanner.nextInt(); 
								break;
							case 2:
								System.out.print("수정할 주소를 입력하세요 >> ");
								address = scanner.next();
								break;
							case 3:
								System.out.print("수정할 성별을 입력하세요(1:남자|2:여자) >> ");
								gender = scanner.nextInt();
								if(gender == 1) strGender = "남자";
								else strGender = "여자";
								break;
							default:
								break;
						}
						res = dao.setHoiwonUpdate(name,age,address,strGender);
						if(res == 0) System.out.println(name + "님의 자료 수정이 실패되었습니다.");
						System.out.println(name + "님의 자료가 수정되었습니다.");
					}
					break;
				case 5: // 삭제처리하기
					System.out.print("삭제할 회원명을 입력하세요 >> ");
					name = scanner.next();
					System.out.println();
					System.out.println("-".repeat(40));
					
					vo = dao.getSearch(name);	// 개별자료 검색
					if(vo.getName() == null) {
						System.out.println(name + "님의 자료가 존재하지 않습니다.");
					}
					else {
						dao.setDelete(name);
						System.out.println(name + "님의 자료가 삭제되었습니다.");
					}
					break;
				default: 
					run = false;
			}
			System.out.println("=".repeat(50));
 		}
		System.out.println("작업끝");
		// DB conn객체 close
		dao.connClose();
		
		scanner.close();
	}
}
