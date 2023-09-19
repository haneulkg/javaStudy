package t10_sale;

import java.util.ArrayList;
import java.util.Scanner;
//
public class SaleService {
	Scanner scanner = new Scanner(System.in);
	
//	ProductDAO dao = null;
	SaleDAO dao = new SaleDAO();
	ProductVO pVO = null;
	SaleVO sVO = null;
	
	String pName = "";
	int res = 0;
	String ans = "N";
	
	public SaleService() {
	}
	
	// 판매관리 주 메뉴
	public void getSaleMenu() {
		boolean run = true;
		
		while(run) {
			System.out.println("-".repeat(55));
			System.out.print("\n1:판매내역등록 | 2:상품검색 | 3:날짜검색 | 4:판매내역리스트 | 5:삭제 | 6:종료 >> ");
			int no = scanner.nextInt();
				
			switch (no) {
				case 1:
					SaleInput();	// 판매내역 등록하기
					break;
				case 2:
					SaleSearch();	// 판매상품 검색하기
					break;
				case 3:
					SaleDateSearch();	// 판매 일자별 검색하기
					break;
				case 4:
					SaleList();
					break;
				case 5:
//					saleDelete();
					break;
				default:
					run = false;
			}
		}
		
	}
	
	// 전체 판매내역검색
	private void SaleList() {
		ArrayList<SaleVO> vos = dao.getSaleList();

		System.out.println("\n\t*** 판매 상품 리스트(전체) ***");
		System.out.println("=".repeat(55));
		System.out.println("\t번호\t상품명\t판매수량\t판매가격\t판매일자");
		System.out.println("-".repeat(55));
		for(int i=0; i<vos.size(); i++) {
			sVO = vos.get(i);
			System.out.print(sVO.getIdx()+"\t");
			System.out.print(sVO.getpName()+"\t");
			System.out.print(sVO.getEa()+"\t");
			System.out.print((sVO.getSalePrice()*sVO.getEa())+"\t");
			System.out.print(sVO.getpDate().substring(0,10)+"\n");
		}
		System.out.println("-".repeat(55));
		System.out.println("\t총 판매상품건수 : "+vos.size()+"건");
		System.out.println("=".repeat(55));
	}

	// 판매일자 검색
	private void SaleDateSearch() {
		System.out.print("검색할 판매일자를 입력하세요 >> ");
		String pDate = scanner.next();
		ArrayList<SaleVO> vos = dao.getSaleDateSearch(pDate);

		System.out.println("\n\t*** 판매 상품 리스트(일자별) ***");
		System.out.println("=".repeat(55));
		System.out.println("\t번호\t상품명\t판매수량\t판매가격\t판매일자");
		System.out.println("-".repeat(55));
		for(int i=0; i<vos.size(); i++) {
			sVO = vos.get(i);
			System.out.print(sVO.getIdx()+"\t");
			System.out.print(sVO.getpName()+"\t");
			System.out.print(sVO.getEa()+"\t");
			System.out.print((sVO.getSalePrice()*sVO.getEa())+"\t");
			System.out.print(sVO.getpDate().substring(0,10)+"\n");
		}
		System.out.println("-".repeat(55));
		System.out.println("\t총 판매상품건수 : "+vos.size()+"건");
		System.out.println("=".repeat(55));
	}

	// 판매상품 검색
	private void SaleSearch() {
		System.out.print("검색할 판매상품명을 입력하세요 >> ");
		pName = scanner.next();
		ArrayList<SaleVO> vos = dao.getSaleNameSearch(pName);

		System.out.println("\n\t*** 판매 상품 리스트(판매상품별) ***");
		System.out.println("=".repeat(55));
		System.out.println("\t번호\t상품명\t판매수량\t판매가격\t판매일자");
		System.out.println("-".repeat(55));
		for(int i=0; i<vos.size(); i++) {
			sVO = vos.get(i);
			System.out.print(sVO.getIdx()+"\t");
			System.out.print(sVO.getpName()+"\t");
			System.out.print(sVO.getEa()+"\t");
			System.out.print((sVO.getSalePrice()*sVO.getEa())+"\t");
			System.out.print(sVO.getpDate().substring(0,10)+"\n");
		}
		System.out.println("-".repeat(55));
		System.out.println("\t총 판매상품건수 : "+vos.size()+"건");
		System.out.println("=".repeat(55));
	}

	// 판매내역 등록
	private void SaleInput() {
		while(true) {
			System.out.print("판매상품명을 입력하세요 >> ");
			pName = scanner.next();
			
			// 판매상품이상품테이블에 등록된 상품인지 검색
			pVO = dao.getNameSearch(pName); 
			if(pVO.getpName() == null) System.out.println("=>> 등록된 상품이 아닙니다.");
			else {
				sVO = new SaleVO();
				sVO.setpName(pName);
				System.out.print("판매수량을 입력하세요 >> ");
				sVO.setEa(scanner.nextInt());
				System.out.print("판매날짜(년:yyyy-월-일)를 입력하세요 >> ");
				sVO.setpDate(scanner.next());
				res = dao.setSaleInput(sVO);
				if(res == 0) System.out.println(">> 판매상품 등록 실패 >>");
				System.out.println(">> 판매상품이 등록되었습니다 >>");
				
				System.out.print("판매상품등록을 계속 하시겠습니까?(y/n) >> ");
				ans = scanner.next().toUpperCase();
				if(ans.equals("N")) break;
			}
		}
	}
}
