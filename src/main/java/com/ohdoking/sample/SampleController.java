package com.ohdoking.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ohdoking.sample.domain.ProductVo;

@Controller
public class SampleController {

	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	@RequestMapping("doA")
	public void doA(){
		logger.info("doA call");
		
	}
	
	@RequestMapping("doB")
	public void doB(){
		logger.info("doB call");
	}
	
	@RequestMapping("doC")
	public String doC(@ModelAttribute("msg") String msg){
		logger.info("doC call");
		
		return "result";
	}
	
	@RequestMapping("doD")
	public String doD(Model model){

		ProductVo product = new ProductVo("Sample Product", 10000);
		// 뷰에 원하는 데이터를 전달하는 일종의 컨테이너나 상자의 역할 		
		model.addAttribute(product);
		return "productDetail";
	}
	
	@RequestMapping("doE")
	public String doE(RedirectAttributes rttr){
		logger.info("doE called but redirect to /doF ..");
		
		//임시적인 데이터를 전달함! 리다이렉트시!		
		rttr.addFlashAttribute("msg", "이것은 메시지! 리다이렉트와 함께가");
		//redirect, forward 다 있
		return "redirect:/doF";
	}
	
	@RequestMapping("doF")
	public void doF(String msg){
		logger.info("doF call : " + msg);
	}
	
	
}
