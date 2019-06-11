package sist.com.jdbc;

import java.util.HashMap;
import java.util.Scanner;

import sist.com.dao.BoardDao;
import sist.com.model.BoardModel;
//View
//Data Access Object
//화면
public class JdbcProcessEx2 {
	private Scanner scanner = new Scanner(System.in);
	
	public void writeProcess() {
		BoardModel boardModel = new BoardModel();
		System.out.println("Title:");
		boardModel.setTitle(scanner.next());
		System.out.println("Writer:");
		boardModel.setWriter(scanner.next());
		System.out.println("Contents:");
		boardModel.setContents(scanner.next());
		System.out.println("Password:");
		boardModel.setPassword(scanner.next());
		BoardDao.addBoard(boardModel);
	}
	
	public void selectBoard() {
		for(BoardModel b:BoardDao.listBoard(null) ) {
			System.out.println(b);
		}
	}
	public void infoBoard() {//////내 인포(3.상세정보)
		System.out.println("조회 할 title을 기입해주세요 →");
		String title = scanner.next().trim();
		BoardModel b = BoardDao.InfoBoard(title);
		System.out.println(b==null?"기입하신 title은 존재하지 않습니다.":b);
		
	}
	
	public int searchIndex() {//샘의 인포(3.상세정보)
		System.out.println("SearchTitle : ");
		int no = BoardDao.getNumber(scanner.next().trim());
		return no;
	}
	
	public void info() { //샘의 인포(3.상세정보 / )
		int index = searchIndex();
		BoardDao.updateHit(index); //상세정보를 할 때마다 hit수가 올라감.
		if(index==-1) {
			System.out.println("NOT FOUND ELEMENT");
			return;}
		System.out.println(BoardDao.selectInfo(index));	
	}
	public void selectSearch() {
		HashMap<String, Object>map=new HashMap<String, Object>();
		System.out.println("1.WRITER 2.TITLE 3.CONTENTS");
		String key="",value="";
		switch (scanner.nextInt()) {
		case 1:
			key="writer";
			break;
		case 2:
			key="title";
			break;
		case 3:
			key="contents";
			break;
		}
		System.out.println("SearchContents");
		value=scanner.next();
		map.put(key, value);
		System.out.println(BoardDao.listBoard(null));
	}
	public void deleteBoard() {
		System.out.println("삭제 할 title을 기입해주세요 →");
		String title = scanner.next().trim();
		int rs=BoardDao.deleteBoard(title);
		 System.out.println(rs>0?"삭제 성공":"삭제 할 title이 없습니다.");
		
	}
	//"UPDATE SIBOARD SET CONTENTS=?,PASSWORD=? WHERE TITLE=? "
	public void modifyBoard() {
		BoardModel boardModel = new BoardModel();
		System.out.println("수정 할 title을 기입해주세요 →");
		boardModel.setTitle(scanner.next());
		System.out.println("contents 수정 :");
		boardModel.setContents(scanner.next());
		System.out.println("password 수정 :");
		boardModel.setPassword(scanner.next());
		System.out.println(boardModel);
		int rs = BoardDao.modifyBoard(boardModel);
		System.out.println(rs>0?boardModel.getWriter()+"님이 작성하신"+boardModel.getTitle()+"수정 완료 되었습니다":"Not Found");
	}

	
	
	public void boardMenu() {
		while(true) {
			
		System.out.println("1.글쓰기 2.전체조회 3.상세조회 4.삭제 5.수정  6.검색");
		switch (scanner.nextInt()) {
		case 1:
			writeProcess();
			break;
		case 2:
			selectBoard();
			break;
		case 3:
			//infoBoard();
			info();
			break;
		case 4:
			deleteBoard();
			break;
		case 5:
			modifyBoard();
			break;
		case 6:
			selectSearch();
			break;
		default:
			break;
		}
		}
		
		}
	
	public static void main(String[] args) {
		new JdbcProcessEx2().boardMenu();
	}
	
	
}
