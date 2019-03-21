package dto;

import entity.Score;

public class ScoreOfStu {
	
	private String userId;
	private int cls;
	private Score score;
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getCls() {
		return cls;
	}
	public void setCls(int cls) {
		this.cls = cls;
	}
	public Score getScore() {
		return score;
	}
	public void setScore(Score score) {
		this.score = score;
	}
	public ScoreOfStu(String userId,  int cls, Score score,String name) {
		super();
		this.userId = userId;
		this.cls = cls;
		this.score = score;
		this.name=name;
	}
	public ScoreOfStu() {
		super();
	}
	@Override
	public String toString() {
		return "ScoreOfStu [ userId=" + userId +", name=" + name+ ", cls=" + cls + ", score=" + score + "]";
	}
	
}
