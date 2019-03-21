package dao;

import org.apache.ibatis.annotations.Param;

import entity.Score;

public interface ScoreDao {
	public Score getScore(String userId);
	public void insertscore(Score score);
	public void updateScore(@Param("score") Score score);
}
