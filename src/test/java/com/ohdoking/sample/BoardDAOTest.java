package com.ohdoking.sample;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.ohdoking.sample.domain.BoardVO;
import com.ohdoking.sample.domain.Criteria;
import com.ohdoking.sample.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
public class BoardDAOTest {

  @Inject
  private BoardDAO dao;

  private static Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);

  @Test
  public void testCreate() throws Exception {

	for(int i = 8 ; i < 20; i++){
		BoardVO board = new BoardVO();
	    board.setTitle("junit title"+i);
	    board.setContent("junit content"+i);
	    board.setWriter("user00");
	    dao.create(board);
	}
    
  }

  @Test
  public void testRead() throws Exception {

    logger.info(dao.read(2).toString());
  }

  @Test
  public void testUpdate() throws Exception {

    BoardVO board = new BoardVO();
    board.setBno(1);
    board.setTitle("junit title update");
    board.setContent("junit content update");
    dao.update(board);
  }

  @Test
  public void testDelete() throws Exception {

    dao.delete(1);
  }

  @Test
  public void testListAll() throws Exception {

    logger.info(dao.listAll().toString());

  }
  
  @Test
  public void testListPage() throws Exception{
	  int page = 3;
	  
	  List<BoardVO> list = dao.listPage(page);
	  
	  for(BoardVO boardVO: list){
		  logger.info(boardVO.getBno() + ":" + boardVO.getTitle());
	  }
  }
  
  @Test
  public void testListCriteria() throws Exception{
	  Criteria criteria = new Criteria();
	  criteria.setPage(2);
	  criteria.setPerPageNum(20);
	  
	  List<BoardVO> list = dao.listCriteria(criteria);

//	  for(BoardVO boardVO: list){
//		  logger.info(boardVO.getBno() + ":" + boardVO.getTitle());
//	  }
	  
	  logger.info(list.size()+"");
	  
  }
  
  /*
   * 
   * URI를 작성할대 도움이 되는 클래스 
		UriComponents
		UriComponentsBuilder
   */
  @Test
  public void testURI() throws Exception{
	  UriComponents uriComponent = 
			  UriComponentsBuilder.newInstance()
			  .path("/board/read")
			  .queryParam("bno", 12)
			  .queryParam("perPageNum", 20)
			  .build();
	  
	  assertEquals("/board/read?bno=12&perPageNum=20", uriComponent.toString());
	  
	  logger.info(uriComponent.toString());
  }
  
  @Test
  public void testURI2() throws Exception{
	  UriComponents uriComponent = 
			  UriComponentsBuilder.newInstance()
			  .path("/{module}/{page}")
			  .queryParam("bno", 12)
			  .queryParam("perPageNum", 20)
			  .build()
			  .expand("board","read")
			  .encode();
	  
	  assertEquals("/board/read?bno=12&perPageNum=20", uriComponent.toString());
	  
	  logger.info(uriComponent.toString());
  }

}
