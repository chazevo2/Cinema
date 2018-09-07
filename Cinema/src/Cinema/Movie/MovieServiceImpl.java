package Cinema.Movie;

import java.util.ArrayList;

public class MovieServiceImpl implements MovieService {
	private MovieDao dao;
	
	public MovieServiceImpl(MovieDao dao) {
		this.dao = dao;
	}

	@Override
	public void addMovie(Movie m) {
		// TODO Auto-generated method stub
		dao.insert(m);
	}

	@Override
	public void editMovie(Movie m) {
		// TODO Auto-generated method stub
		dao.update(m);
	}

	@Override
	public void delMovie(int mno) {
		// TODO Auto-generated method stub
		dao.delete(mno);
	}

	@Override
	public Movie getMovie(int mno) {
		// TODO Auto-generated method stub
		return dao.select(mno);
	}

	@Override
	public ArrayList<Movie> getByName(String mname) {
		// TODO Auto-generated method stub
		return dao.selectByName(mname);
	}

	@Override
	public ArrayList<Movie> getByStory(String story) {
		// TODO Auto-generated method stub
		return dao.selectByStory(story);
	}

	@Override
	public ArrayList<Movie> getByGenre(String genre) {
		// TODO Auto-generated method stub
		return dao.selectByGenre(genre);
	}

	@Override
	public ArrayList<Movie> getAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

}
