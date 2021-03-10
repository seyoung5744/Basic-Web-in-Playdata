package board;

import java.util.ArrayList;

public interface Service {
	void writeBoard(Board b);
	Board getBoard(int num);
	ArrayList<Board> getByTitle(String title);
	ArrayList<Board> getByWriter(String writer);
	ArrayList<Board> getAll();
	void editBoard(Board b);
	void delBoard(int num);
}
