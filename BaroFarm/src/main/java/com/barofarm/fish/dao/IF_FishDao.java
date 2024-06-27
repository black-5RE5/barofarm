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
	public FishVo detail(String name);
	public List<FishVo> view(String category);
	public List<FishVo> middleview(String middlecategory);
	
}
