package Cinema.Review;

import java.util.ArrayList;

public interface ReviewService {
	void addReview(Review r);

	void editReview(Review r);

	void delReview(int rno);

	Review getMovie(int rno);
	
	ArrayList<Review> getByMid(String mid);

	ArrayList<Review> getByMname(String mname);

	ArrayList<Review> getAvgScore();

	ArrayList<Review> getByScore(int score);

	ArrayList<Review> getAll();
}
