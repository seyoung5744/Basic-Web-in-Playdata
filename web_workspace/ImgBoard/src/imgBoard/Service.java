package imgBoard;

import java.util.ArrayList;

public interface Service {
	void writeImgboard(ImgBoard ib);
	ImgBoard getImgboard(int num);
	ArrayList<ImgBoard> getAll();
	void editImgboard(ImgBoard ib);
	void delImgboard(int num);
}
