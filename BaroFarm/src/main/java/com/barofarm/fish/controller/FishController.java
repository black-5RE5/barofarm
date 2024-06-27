package com.barofarm.fish.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.barofarm.fish.service.IF_FishService;
import com.barofarm.fish.vo.FishVo;

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
	public String allview(Model model) throws Exception{
	List<FishVo> fVo = fService.allview();
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

	// 마이페이지 개발중 - 담당자 meat
	@GetMapping("/mypage")
	public String mypage() {

		return "mypage";
	}

	// 마이페이지 회원정보 수정시 update 작업해야함 -담당자 meat-
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

	// 레이아웃 개발중 - 담당자 son
	@GetMapping("/")
	public String usermain() {
		return "UserMain";
	}

	@GetMapping("fruitview")//농산물전체
	public String fruit(Model model) throws Exception {
		List<FishVo> fruitVo=fService.fruitView();
		System.out.println("상품 상세보기"+fruitVo.toString());
		model.addAttribute("fruitVo", fruitVo);
		return "FruitView";
	}
	@GetMapping("fruitFruit")//과일 전체보기
	public String fruitFruit(Model model) throws Exception {
		List<FishVo> fruitFruit=fService.fruitFruit();
		model.addAttribute("fruitFruit", fruitFruit);
		return "Fruit_Fruit";
	}
	@GetMapping("fruitVege")//채소 전체보기
	public String fruitVege(Model model) throws Exception {
		List<FishVo> fruitVege=fService.fruitVege();
		model.addAttribute("fruitVege", fruitVege);
		return "Fruit_Vegetable";
	}
	@GetMapping("fruitGrain")//곡물 전체보기
	public String fruitGrain(Model model) throws Exception {
		List<FishVo> fruitGrain=fService.fruitGrain();
		model.addAttribute("fruitGrain", fruitGrain);
		return "Fruit_Grains";
	}
	//상세보기 어떻게 해야하냐 ..
	@GetMapping("fruitDetail")//농산물 상세보기 예시
	public String fruitdetail(Model model) throws Exception {
		List<FishVo> fruitVo=fService.fruitView();
		System.out.println("상품 상세보기"+fruitVo.toString());
		model.addAttribute("fruitVo", fruitVo);
		return "FruitDetail";
	}

	@GetMapping("fishview")//수산물전체
	public String fish(Model model) throws Exception {
		List<FishVo> fishVo=fService.fishView();
		System.out.println("상품 상세보기"+fishVo.toString());
		model.addAttribute("fishVo", fishVo);
		return "FishView";
	}
}
