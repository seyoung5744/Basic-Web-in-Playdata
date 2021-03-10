package mem;

import java.util.ArrayList;

public interface Service {
	void addMember(Member m);
	Member getMember(String id);
	ArrayList<Member> getAll();
	void editMember(Member m);
	void delMember(String id);
	boolean login(String id, String pwd);
}
