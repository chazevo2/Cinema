package Cinema.Review;

import java.util.ArrayList;
import java.util.Scanner;

import Cinema.Members.MembersController;

public class ReviewController {
	private ReviewService service;

	public ReviewController(ReviewService service) {
		this.service = service;
	}

	public void write(Scanner sc) {
		Review r = new Review();
		r.setMid(MembersController.getLoginId());
		if(r.getMid().equals("")) {
			System.out.println("로그인 후 이용바랍니다.");
			return;
		}
		System.out.print("영화 번호:");
		r.setMno(sc.nextInt());
		System.out.print("평점(0 ~ 100):");
		r.setScore(sc.nextInt());
		if(r.getScore() > 100 || r.getScore() < 0) {
			System.out.println("잘못된 입력입니다.");
			return;
		}
		System.out.print("후기(100자 이내):");
		r.setMemo(sc.nextLine());
		r.setMemo(sc.nextLine());
		service.addReview(r);
		System.out.println("추가 완료");
	}

	public void rewrite(Scanner sc) {
		Review r = new Review();
		if(MembersController.getLoginId().equals("")) {
			System.out.println("로그인 후 이용바랍니다.");
			return;
		}
		ArrayList<Review> list = service.getByMid(MembersController.getLoginId());
		if(list == null) {
			System.out.println("작성글이 존재하지 않습니다.");
			return;
		}
		System.out.println("내가 작성한 리뷰목록");
		for(Review r2 : list)
			System.out.println(r2);
		System.out.print("수정할 리뷰의 번호:");
		r.setRno(sc.nextInt());
		Review r3 = service.getMovie(r.getRno());
		if (r3 == null) {
			System.out.println("잘못된 입력입니다.");
			return;
		}
		if (r3.getMid().equals(MembersController.getLoginId())) {
			System.out.print("변경할 평점(0 ~ 100):");
			r.setScore(sc.nextInt());
			System.out.print("변경할 후기 내용:");
			r.setMemo(sc.next());
			service.editReview(r);
			System.out.println("변경이 완료 되었습니다.");
		} else {
			System.out.println("본인 글만 수정 가능합니다.");
		}

	}

	public void delete(Scanner sc) {
		if(MembersController.getLoginId().equals("")) {
			System.out.println("로그인 후 이용바랍니다.");
			return;
		}
		System.out.println("내가 작성한 리뷰목록");
		ArrayList<Review> list = service.getByMid(MembersController.getLoginId());
		if(list == null) {
			System.out.println("작성글이 존재하지 않습니다.");
			return;
		}
		System.out.println("내가 작성한 리뷰목록");
		for(Review r1 : list)
			System.out.println(r1);
		System.out.print("삭제할 리뷰의 번호:");
		Review r2 = service.getMovie(sc.nextInt());
		if (r2 == null) {
			System.out.println("잘못된 입력입니다.");
			return;
		}
		if (r2.getMid().equals(MembersController.getLoginId())) {
			service.delReview(r2.getRno());
			System.out.println("삭제가 완료되었습니다.");
		} else {
			System.out.println("본인의 글만 삭제 가능합니다.");
		}

	}

	public void search(Scanner sc) {
		System.out.print("검색할 리뷰 번호:");
		Review r = service.getMovie(sc.nextInt());
		if (r == null) {
			System.out.println("잘못된 입력입니다.");
			return;
		} else {
			System.out.println(r);
		}
	}

	public void searchByName(Scanner sc) {
		System.out.println("검색할 영화 이름:");
		ArrayList<Review> list = service.getByMname(sc.nextLine());
		list = service.getByMname(sc.nextLine());
		if (list == null) {
			System.out.println("검색하신 영화가 존재하지 않습니다.");
			return;
		}
		for (Review r : list) {
			System.out.println(r);
		}
	}

	public void searchAVG() {
		if (service.getAvgScore() == null) {
			System.out.println("목록이 비었습니다.");
			return;
		}
		for (Review r : service.getAvgScore()) {
			System.out.println("Review [mname=" + r.getMname() + ", write=" + r.getMid() + "명, avg(score)=" + r.getScore() + "]");
		}
	}

	public void searchByScore(Scanner sc) {
		System.out.print("검색할 평점:");
		int score = sc.nextInt();
		ArrayList<Review> list = service.getByScore(score);
		if (list == null) {
			System.out.println("검색하신 영화가 존재하지 않습니다.");
			return;
		}
		System.out.println("평점이 " + score + "이상인 검색 목록들입니다.");
		for (Review r : list) {
			System.out.println(r);
		}
	}

	public void searchAll() {
		if (service.getAll() == null) {
			System.out.println("목록이 비었습니다.");
			return;
		}
		for (Review r : service.getAll()) {
			System.out.println(r);
		}
	}

}
