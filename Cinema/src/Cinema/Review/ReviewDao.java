package Cinema.Review;

import java.util.ArrayList;

public interface ReviewDao {
	void insert(Review r);

	void update(Review r);

	void delete(int rno);

	Review select(int rno);
	
	ArrayList<Review> selectByMid(String mid);

	ArrayList<Review> selectByMname(String mname);

	ArrayList<Review> selectAvgScore();

	ArrayList<Review> selectByScore(int score);

	ArrayList<Review> selectAll();
}
