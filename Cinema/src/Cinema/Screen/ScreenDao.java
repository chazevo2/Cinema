package Cinema.Screen;

import java.util.ArrayList;

public interface ScreenDao {

	void insert(Screen scr);

	void update(Screen scr);

	void delete(int scrno);

	Screen select(int scrno);
	
	ArrayList<Screen> selectAll();

}
