package com.barofarm.fish.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class FishVo {
	
	private String product_cate=null;
	private String product_middle=null;
	private int product_no=0;
	private String product_name=null;
	private int product_price=0;
	private String product_origin=null;
	private int product_stock=0;
	private List<MultipartFile> dealFiles; //사진첨부
	
}
