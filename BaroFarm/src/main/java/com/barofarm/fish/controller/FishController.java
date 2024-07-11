package com.barofarm.fish.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.barofarm.fish.service.IF_FishService;
import com.barofarm.fish.vo.FishVo;
import com.barofarm.fish.vo.PageVO;

@Controller
public class FishController {

	@Autowired
	IF_FishService fService;
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}

	@GetMapping("/add")
	public String add() {
		return "add";
	}

	@PostMapping("/addSave")
	public String addSave(@ModelAttribute FishVo fVo) throws Exception {
		fService.insert(fVo);
		return "redirect:/home";
	}

	@GetMapping("/allview")
	public String allview(Model model, @ModelAttribute PageVO pagevo) throws Exception{
	if(pagevo.getPage()==null) {
		pagevo.setPage(1);
	}
	System.out.println("현재 페이지 번호: "+pagevo.getPage());
	
	pagevo.setTotalCount(fService.getTotalCount());
	pagevo.prt();
//	System.out.println("시작페이지 번호: "+pagevo.getStartNo());
//	System.out.println("끝페이지 번호: "+pagevo.getEndNo());
	List<FishVo> fVo = fService.allview(pagevo);
	model.addAttribute("pagevo",pagevo);
	model.addAttribute("allList",fVo);
	return "allview";
	}

	@GetMapping("/delete/{product_no}")
	public String delete(@PathVariable("product_no") int no) throws Exception {
		fService.delete(no);
		return "redirect:/allview";
	}

	@GetMapping("/modify/{product_no}")
	public String modify(@PathVariable("product_no") int no, Model model) throws Exception {
		FishVo fVo = fService.modify(no);
		model.addAttribute("modiVo", fVo);
		return "modify";
	}

	@PostMapping("/modifySave")
	public String modify(@ModelAttribute FishVo fvo) throws Exception {
		fService.update(fvo);
		// System.out.println(fvo.getProduct_name());

		return "redirect:/allview";
	}

	// 담당자 meat
	@GetMapping("/mypage")
	public String mypage() {

		return "mypage";
	}

	//-담당자 meat-
	@GetMapping("/memberUpdate")
	public String memberUpdate() {
		
		return "mypage";
	}

	@GetMapping("/order")
	public String orderDelivery() {

		return "orderDelivery";
	}

	@GetMapping("/basket")
	public String basket() {

		return "basket";
	}

	@GetMapping("/notice")
	public String notice() {

		return "notice";
	}

	// 담당자 son
	@GetMapping("/")
	public String usermain() {
		return "UserMain";
	}

	
	//대분류
	@GetMapping("view")
	public String view(@RequestParam("product_cate") String category , Model model) throws Exception {
		List<FishVo> Vo=fService.view(category);
		model.addAttribute("Vo",Vo);
		return "View";
	}

	//상세보기
	@GetMapping("detail")
	public String detail(@RequestParam("product_no") String name, Model model) throws Exception {
		FishVo detailVo=fService.detail(name);
		model.addAttribute("detailVo", detailVo);
		return "FruitDetail";
	}
	
	//중분류
		@GetMapping("middleview")
		public String middleview(@RequestParam("product_middle") String middlecategory , Model model) throws Exception {
			List<FishVo> Vo=fService.middleview(middlecategory);
			model.addAttribute("Vo", Vo);
			return "View";
		}


}
