package entity;

public class Score {
	private int id;
	private String name;
	private String userId;
	private double mathScore;
	private double javaScore;
	private double htmlScore;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public double getMathScore() {
		return mathScore;
	}
	public void setMathScore(double mathScore) {
		this.mathScore = mathScore;
	}
	public double getJavaScore() {
		return javaScore;
	}
	public void setJavaScore(double javaScore) {
		this.javaScore = javaScore;
	}
	public double getHtmlScore() {
		return htmlScore;
	}
	public void setHtmlScore(double htmlScore) {
		this.htmlScore = htmlScore;
	}
	public Score(int id, String name, String userId, double mathScore, double javaScore, double htmlScore) {
		super();
		this.id = id;
		this.name = name;
		this.userId = userId;
		this.mathScore = mathScore;
		this.javaScore = javaScore;
		this.htmlScore = htmlScore;
	}
	public Score(double mathScore, double javaScore, double htmlScore) {
		super();
		this.mathScore = mathScore;
		this.javaScore = javaScore;
		this.htmlScore = htmlScore;
	}
	public Score() {
		
	}
	@Override
	public String toString() {
		return "Score [id=" + id + ", name=" + name + ", userId=" + userId + ", mathScore=" + mathScore + ", javaScore="
				+ javaScore + ", htmlScore=" + htmlScore + "]";
	}
	
	
}
