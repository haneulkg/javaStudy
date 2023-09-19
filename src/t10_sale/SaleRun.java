package t10_sale;

import java.util.Scanner;

public class SaleRun {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		boolean run = true;
		
		while(run) {
			System.out.println("\n\t*** 작 업 선 택(메뉴선택) ***");
			System.out.println("=".repeat(55));
			System.out.print("1:상품관리 | 2:판매관리 | 3:종료  >> ");
			int no = scanner.nextInt();
			
			switch(no) {
				case 1:
					ProductService pSerivce = new ProductService();
					pSerivce.getProductMenu();
					break;
				case 2:
					SaleService sSerivce = new SaleService();
					sSerivce.getSaleMenu();
					break;
				default:
					run = false;
			}
		}
		System.out.println("=".repeat(55));
		System.out.println(">>> 작업종료");
		
		scanner.close();
	}

}
