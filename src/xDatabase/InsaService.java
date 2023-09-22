package xDatabase;

import java.util.Calendar;

public class InsaService {
	InsaVO vo = null;
	
	// 오늘날짜 구하기(입사일 초기값)
	public InsaVO getDefaultDate() {
		vo = new InsaVO();
		
		Calendar cal = Calendar.getInstance();
		vo.setStrYY(cal.get(Calendar.YEAR)+"");
		vo.setStrMM(cal.get(Calendar.MONTH)+1+"");
		vo.setStrYY(cal.get(Calendar.DATE)+"");
		
		return vo;
	}
	
}
