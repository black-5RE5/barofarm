package com.barofarm.fish.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.barofarm.fish.vo.FishVo;
import com.barofarm.fish.vo.PageVO;

@Mapper
public interface IF_FishDao {

	public void insert(FishVo fVo) throws Exception;
	public List<FishVo> allview(PageVO pagevo) throws Exception;
	public void delete(int no) throws Exception;
	public FishVo modify(int no) throws Exception;
	public void update(FishVo fVo) throws Exception;
<<<<<<< HEAD
	public FishVo detail(String name);
	public List<FishVo> view(String category);
	public List<FishVo> middleview(String middlecategory);
=======
	public int getTotalCount() throws Exception;
	public List<FishVo> fruitView();
	public List<FishVo> fruitFruit();
	public List<FishVo> meatView();
	public List<FishVo> fishView();
	public List<FishVo> fruitVege();
	public List<FishVo> fruitGrain();
>>>>>>> 65b3721fda1a95f8563f2061e9a39a7f92f171e3
	
}
