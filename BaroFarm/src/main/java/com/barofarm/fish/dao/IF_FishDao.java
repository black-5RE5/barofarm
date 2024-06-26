package com.barofarm.fish.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.barofarm.fish.vo.FishVo;

@Mapper
public interface IF_FishDao {

	public void insert(FishVo fVo) throws Exception;
	public List<FishVo> allview() throws Exception;
	public void delete(int no) throws Exception;
	public FishVo modify(int no) throws Exception;
	public void update(FishVo fVo) throws Exception;
	public List<FishVo> fruitView();
	public List<FishVo> fruitFruit();
	public List<FishVo> meatView();
	public List<FishVo> fishView();
	public List<FishVo> fruitVege();
	public List<FishVo> fruitGrain();
	
}
