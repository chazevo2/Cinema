package Cinema.Movie;

import java.util.ArrayList;

public interface MovieDao {
	void insert(Movie m);

	void update(Movie m);

	void delete(int mno);

	Movie select(int mno);
	
	ArrayList<Movie> selectByName(String mname);
	
	ArrayList<Movie> selectByStory(String story);

	ArrayList<Movie> selectByGenre(String genre);

	ArrayList<Movie> selectAll();
}
