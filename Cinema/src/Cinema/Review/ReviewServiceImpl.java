package Cinema.Review;

import java.util.ArrayList;

public class ReviewServiceImpl implements ReviewService {
	private ReviewDao dao;
	
	public ReviewServiceImpl(ReviewDao dao) {
		this.dao = dao;
	}

	@Override
	public void addReview(Review r) {
		// TODO Auto-generated method stub
		dao.insert(r);
	}

	@Override
	public void editReview(Review r) {
		// TODO Auto-generated method stub
		dao.update(r);
	}

	@Override
	public void delReview(int rno) {
		// TODO Auto-generated method stub
		dao.delete(rno);
	}

	@Override
	public Review getMovie(int rno) {
		// TODO Auto-generated method stub
		return dao.select(rno);
	}
	
	@Override
	public ArrayList<Review> getByMid(String mid) {
		// TODO Auto-generated method stub
		return dao.selectByMid(mid);
	}

	@Override
	public ArrayList<Review> getByMname(String mname) {
		// TODO Auto-generated method stub
		return dao.selectByMname(mname);
	}

	@Override
	public ArrayList<Review> getAvgScore() {
		// TODO Auto-generated method stub
		return dao.selectAvgScore();
	}

	@Override
	public ArrayList<Review> getByScore(int score) {
		// TODO Auto-generated method stub
		return dao.selectByScore(score);
	}

	@Override
	public ArrayList<Review> getAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

}
