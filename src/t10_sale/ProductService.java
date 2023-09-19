package t10_sale;

import java.util.List;
import java.util.Scanner;

public class ProductService {
	Scanner scanner = new Scanner(System.in);
	
	ProductDAO dao = new ProductDAO();
	ProductVO vo = null;
	String pName = "";
	int res = 0;
	String ans = "N";

	// 상품관리 주 메뉴
	public void getProductMenu() {
		boolean run = true;
		while(run) {
			System.out.println("-".repeat(55));
			System.out.print("\n1:상품등록 | 2:상품검색 | 3:상품목록 | 4:삭제 | 5:종료  >> ");
			int no = scanner.nextInt();
			
			switch (no) {
				case 1:
					productInput();
					break;
				case 2:
					productSearch();
					break;
				case 3:
					productList();
					break;
				case 4:
					productDelete();
					break;
				default:
					run = false;
			}
		}
		dao.connClose();
	}
	
	// 상품 삭제관리
	private void productDelete() {
		System.out.print("삭제할 상품명을 입력하세요 >> ");
		pName = scanner.next();
		vo = dao.getNameSearch(pName);
		
		if(vo.getpName() == null) System.out.println("=>> 검색하신 상품이 존재하지 않습니다.");
		else {
			res = dao.setProductDelete(vo.getIdx());
			if(res == 0) System.out.println(">> 상품 삭제 실패 >>");
			else System.out.println(">> "+pName + " 상품이 삭제되었습니다 >>");
		}
	}

	// 상품목록 -> 전체 상품 조회
	private void productList() {
		List<ProductVO> vos = dao.getProductList();
		
		System.out.println("\n\t*** 전체 상품 리스트 ***");
		System.out.println("=".repeat(55));
		System.out.println("\t번호\t상품명\t상품가격");
		System.out.println("-".repeat(55));
		for(int i=0; i<vos.size(); i++) {
			vo = vos.get(i);
			System.out.print(vo.getIdx()+"\t");
			System.out.print(vo.getpName()+"\t");
			System.out.print(vo.getPrice()+"\n");
		}
		System.out.println("-".repeat(55));
		System.out.println("\t총 상품건수 : "+vos.size()+"건");
		System.out.println("=".repeat(55));
	}

	// 상품 개별 검색하기
	private void productSearch() {
		System.out.print("검색할 상품명을 입력하세요 >> ");
		pName = scanner.next();
		vo = dao.getNameSearch(pName);
		
		if(vo.getpName() == null) System.out.println("=>> 검색하신 상품이 존재하지 않습니다.");
		else {
			System.out.println("상품고유 번호 : " + vo.getIdx());
			System.out.println("상품명 : " + vo.getpName());
			System.out.println("상품가격 : " + vo.getPrice());
		}
	}

	// 상품관리 메뉴 -> 상품 등록처리
	private void productInput() {
		while(true) {
			System.out.print("상품명을 입력하세요 >> ");
			pName = scanner.next();
			
			// 상품등록 -> 상품명 중복처리
			vo = dao.getNameSearch(pName); 
			if(vo.getpName() != null) System.out.println("=>> 이미 동일한 상품이 존재합니다.");
			else {
				vo.setpName(pName);
				System.out.print("상품가격을 입력하세요 >> ");
				vo.setPrice(scanner.nextInt());
				res = dao.setProductInput(vo);
				if(res == 0) System.out.println(">> 상품 등록 실패 >>");
				System.out.println(">> 상품이 등록되었습니다 >>");
				
				System.out.print("상품등록을 계속 하시겠습니까?(y/n) >> ");
				ans = scanner.next().toUpperCase();
				if(ans.equals("N")) break;
			}
		}
	}
	
}
