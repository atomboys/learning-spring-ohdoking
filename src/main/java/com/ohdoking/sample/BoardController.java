package com.ohdoking.sample;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ohdoking.sample.domain.BoardVO;
import com.ohdoking.sample.domain.Criteria;
import com.ohdoking.sample.domain.PageMaker;
import com.ohdoking.sample.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {

  private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

  @Inject
  private BoardService service;

  @RequestMapping(value = "/register", method = RequestMethod.GET)
  public void registerGET(BoardVO board, Model model) throws Exception {

    logger.info("register get ...........");
  }

   @RequestMapping(value = "/register", method = RequestMethod.POST)
   public String registPOST(BoardVO board, RedirectAttributes rttr) throws Exception {
  
   logger.info("regist post ...........");
   logger.info(board.toString());
  
   service.regist(board);
  
   rttr.addFlashAttribute("result", "SUCCESS");
  
//   return "/board/success";
   return "redirect:/board/listAll";
   }
   
   @RequestMapping(value="/listAll", method = RequestMethod.GET)
   public void listAll(Model model) throws Exception{
	   logger.info("show all list...");
	   
	   model.addAttribute("list",service.listAll());
   }
   
   @RequestMapping(value = "/read", method = RequestMethod.GET)
   public void read(@RequestParam("bno") int bno, Model model) throws Exception {

     model.addAttribute(service.read(bno));
   }
   
   @RequestMapping(value = "/readPage", method = RequestMethod.GET)
   public void read(@RequestParam("bno") int bno, @ModelAttribute("cri") Criteria cri ,Model model) throws Exception {
 
     model.addAttribute(service.read(bno));
   }
   
   
   @RequestMapping(value = "/removePage", method = RequestMethod.POST)
   public String remove(@ModelAttribute("cri")Criteria cri, @RequestParam("bno") int bno, RedirectAttributes rttr) throws Exception {

     service.remove(bno);

     rttr.addAttribute("page",cri.getPage());
     rttr.addAttribute("perPageNum",cri.getPerPageNum());
     rttr.addFlashAttribute("result", "SUCCESS");

     return "redirect:/board/listPage";
   }
   
   @RequestMapping(value = "/remove", method = RequestMethod.POST)
   public String remove(@RequestParam("bno") int bno, RedirectAttributes rttr) throws Exception {

     service.remove(bno);

     rttr.addFlashAttribute("result", "SUCCESS");

     return "redirect:/board/listAll";
   }

   @RequestMapping(value = "/modify", method = RequestMethod.GET)
   public void modifyGET(int bno, Model model) throws Exception {

     model.addAttribute(service.read(bno));
   }
   
   @RequestMapping(value = "/modifyPage", method = RequestMethod.GET)
   public void modifyPagingGET(@ModelAttribute("cri")Criteria cri, int bno, Model model) throws Exception {

     model.addAttribute(service.read(bno));
   }

   @RequestMapping(value = "/modify", method = RequestMethod.POST)
   public String modifyPOST(BoardVO board, RedirectAttributes rttr) throws Exception {

     logger.info("mod post............");

     service.modify(board);
     rttr.addFlashAttribute("result", "SUCCESS");

     return "redirect:/board/listAll";
   }

   @RequestMapping(value = "/modifyPage", method = RequestMethod.POST)
   public String modifyPagingPOST(BoardVO board, @ModelAttribute("cri")Criteria cri, RedirectAttributes rttr) throws Exception {
	   
	   logger.info("mody paging post............");
	   
	   service.modify(board);
	   
	   rttr.addAttribute("page",cri.getPage());
	   rttr.addAttribute("perPageNum",cri.getPerPageNum());
	   rttr.addFlashAttribute("result", "SUCCESS");
	   
	   return "redirect:/board/listPage";
   }
   
   @RequestMapping(value="/listCri", method = RequestMethod.GET)
   public void listCriteria(Criteria cri, Model model) throws Exception{
	   logger.info("show list page with criteria....");
	   
	   model.addAttribute("list", service.listCriteria(cri));
   }

   @RequestMapping(value="/listPage", method = RequestMethod.GET)
   public void listPage(@ModelAttribute("cri")Criteria cri, Model model) throws Exception{

	   logger.info(cri.toString() +" : " + service.listCountCriteria(cri));
	   
	   model.addAttribute("list", service.listCriteria(cri));
	   PageMaker pageMaker = new PageMaker();
	   pageMaker.setCri(cri);
	   pageMaker.setTotalCount(service.listCountCriteria(cri));
	   model.addAttribute("pageMaker",pageMaker);
   }


}
