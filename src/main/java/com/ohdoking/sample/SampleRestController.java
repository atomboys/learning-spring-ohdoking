package com.ohdoking.sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ohdoking.sample.domain.SampleVO;

@RestController
@RequestMapping("/samplerest")
public class SampleRestController {

	@RequestMapping("hello")
	public String sayHello(){
		
		return "HELLO";
	}
	
	@RequestMapping("/sendVO")
	public SampleVO sendVO(){
		
		SampleVO sampleVO = new SampleVO();
		sampleVO.setMno(0);
		sampleVO.setFirstName("Dokeun");
		sampleVO.setLastName("OH");
		
		return sampleVO;
	}
	
	@RequestMapping("/sendList")
	public List<SampleVO> sendList(){
		
		List<SampleVO> list = new ArrayList<SampleVO>();
		for(int i = 0; i < 10 ; i++){
		
			SampleVO sampleVO = new SampleVO();
			sampleVO.setMno(i);
			sampleVO.setFirstName("Dokeun");
			sampleVO.setLastName("OH");
			list.add(sampleVO);
		}
		
		return list;
	}
	
	@RequestMapping("/sendMap")
	public Map<Integer, SampleVO> sendMap(){
		
		Map<Integer, SampleVO> map = new HashMap<Integer, SampleVO>();
		
		for(int i = 0; i < 10 ; i++){
			SampleVO sampleVO = new SampleVO();
			sampleVO.setMno(i);
			sampleVO.setFirstName("Dokeun");
			sampleVO.setLastName("OH");
			map.put(i, sampleVO);
		}
		;
		return map;
	}
	
	@RequestMapping("/sendErrorAuth")
	public ResponseEntity<Void> sendListAuth(){
		return new ResponseEntity<Void>(HttpStatus.BAD_GATEWAY);
	}
	
	@RequestMapping("sendErrorNot")
	public ResponseEntity<List<SampleVO>> sendListNot(){
		
		List<SampleVO> list = new ArrayList<SampleVO>();
		for(int i = 0; i < 10 ; i++){
		
			SampleVO sampleVO = new SampleVO();
			sampleVO.setMno(i);
			sampleVO.setFirstName("Dokeun");
			sampleVO.setLastName("OH");
			list.add(sampleVO);
		}
		
		return new ResponseEntity<List<SampleVO>>(list, HttpStatus.NOT_FOUND);
	}
}
