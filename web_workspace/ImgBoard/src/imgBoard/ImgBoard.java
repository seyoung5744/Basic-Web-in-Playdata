package imgBoard;

public class ImgBoard {
	private int num;
	private String writer;
	private String title;
	private String path;
	private String content;
	
	public ImgBoard() {}
	
	public ImgBoard(int num, String writer, String title, String content, String path) {
		super();
		this.num = num;
		this.writer = writer;
		this.title = title;
		this.path = path;
		this.content = content;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "ImgBoard [num=" + num + ", writer=" + writer + ", title=" + title + ", path=" + path + ", content="
				+ content + "]";
	}
	
}
