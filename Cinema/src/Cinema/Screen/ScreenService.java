package Cinema.Screen;

import java.util.ArrayList;

public interface ScreenService {
	void addScreen(Screen scr);

	void editScreen(Screen scr);

	void delScreen(int scrno);

	Screen getScreen(int scrno);

	ArrayList<Screen> getAll();
}
