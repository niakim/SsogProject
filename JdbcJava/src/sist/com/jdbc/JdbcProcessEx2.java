package sist.com.jdbc;

import java.util.HashMap;
import java.util.Scanner;

import sist.com.dao.BoardDao;
import sist.com.model.BoardModel;
//View
//Data Access Object
//ȭ��
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
	public void infoBoard() {//////�� ����(3.������)
		System.out.println("��ȸ �� title�� �������ּ��� ��");
		String title = scanner.next().trim();
		BoardModel b = BoardDao.InfoBoard(title);
		System.out.println(b==null?"�����Ͻ� title�� �������� �ʽ��ϴ�.":b);
		
	}
	
	public int searchIndex() {//���� ����(3.������)
		System.out.println("SearchTitle : ");
		int no = BoardDao.getNumber(scanner.next().trim());
		return no;
	}
	
	public void info() { //���� ����(3.������ / )
		int index = searchIndex();
		BoardDao.updateHit(index); //�������� �� ������ hit���� �ö�.
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
		System.out.println("���� �� title�� �������ּ��� ��");
		String title = scanner.next().trim();
		int rs=BoardDao.deleteBoard(title);
		 System.out.println(rs>0?"���� ����":"���� �� title�� �����ϴ�.");
		
	}
	//"UPDATE SIBOARD SET CONTENTS=?,PASSWORD=? WHERE TITLE=? "
	public void modifyBoard() {
		BoardModel boardModel = new BoardModel();
		System.out.println("���� �� title�� �������ּ��� ��");
		boardModel.setTitle(scanner.next());
		System.out.println("contents ���� :");
		boardModel.setContents(scanner.next());
		System.out.println("password ���� :");
		boardModel.setPassword(scanner.next());
		System.out.println(boardModel);
		int rs = BoardDao.modifyBoard(boardModel);
		System.out.println(rs>0?boardModel.getWriter()+"���� �ۼ��Ͻ�"+boardModel.getTitle()+"���� �Ϸ� �Ǿ����ϴ�":"Not Found");
	}

	
	
	public void boardMenu() {
		while(true) {
			
		System.out.println("1.�۾��� 2.��ü��ȸ 3.����ȸ 4.���� 5.����  6.�˻�");
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
