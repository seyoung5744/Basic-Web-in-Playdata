package board;

import java.util.ArrayList;

public interface Dao {
	void insert(Board b);//���� ��¥�� ����.
	Board selectByNum(int num);//�۹�ȣ�� �˻�
	ArrayList<Board> selectByWriter(String writer);//�ۼ��ڷ� �˻�
	ArrayList<Board> selectByTitle(String title);//�������� �˻�
	ArrayList<Board> selectAll();//�����˻�
	void update(Board b);//�ۼ���. �۹�ȣ�� ã�Ƽ�, ��¥�� ����� ����. ����, ������ �Է¹��� ������ ����.
	void delete(int num);//�ۻ���. �۹�ȣ�� ã�Ƽ�
}
