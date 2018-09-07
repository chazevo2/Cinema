package Cinema.Movie;

import java.util.ArrayList;

public interface MovieService {
	void addMovie(Movie m);

	void editMovie(Movie m);

	void delMovie(int mno);

	Movie getMovie(int mno);

	ArrayList<Movie> getByName(String mname);

	ArrayList<Movie> getByStory(String story);

	ArrayList<Movie> getByGenre(String genre);

	ArrayList<Movie> getAll();
}
