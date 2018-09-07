package Cinema.Screen;

import java.util.ArrayList;

public class ScreenServiceImpl implements ScreenService {
	private ScreenDao dao;

	public ScreenServiceImpl(ScreenDao dao) {
		this.dao = dao;
	}

	@Override
	public void addScreen(Screen scr) {
		// TODO Auto-generated method stub
		dao.insert(scr);
	}

	@Override
	public void editScreen(Screen scr) {
		// TODO Auto-generated method stub
		dao.update(scr);
	}

	@Override
	public void delScreen(int scrno) {
		// TODO Auto-generated method stub
		dao.delete(scrno);
	}

	@Override
	public Screen getScreen(int scrno) {
		// TODO Auto-generated method stub
		return dao.select(scrno);
	}
	
	@Override
	public ArrayList<Screen> getAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

}
