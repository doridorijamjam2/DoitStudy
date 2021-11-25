package com.spring.study.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.study.service.TipService;
import com.spring.study.service.TipReplyService;
import com.spring.study.vo.TipVO;
import com.spring.study.vo.Criteria;
import com.spring.study.vo.PageMaker;
import com.spring.study.vo.TipReplyVO;
import com.spring.study.vo.SearchCriteria;

@Controller
@RequestMapping("/tip/*")
public class TipController {

	private static final Logger logger = LoggerFactory.getLogger(TipController.class);
	
	@Inject
	TipService service;
	
	@Inject
	TipReplyService replyService;
	
	// 게시판 글 작성 화면
	@RequestMapping(value = "/tip/writeView", method = RequestMethod.GET)
	public void writeView() throws Exception{
		logger.info("writeView");
		
	}
	
	// 게시판 글 작성
	@RequestMapping(value = "/tip/write", method = RequestMethod.POST)
	public String write(TipVO tipVO) throws Exception{
		logger.info("write");
		
		service.write(tipVO);
		
		return "redirect:/tip/list";
	}
	
	// 게시판 목록 조회
	@RequestMapping(value = "/tip/list", method = RequestMethod.GET)
	public String list(Model model, @ModelAttribute("scri") SearchCriteria scri) throws Exception{
		logger.info("list");
		
		model.addAttribute("list", service.list(scri));
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalCount(service.listCount(scri));
		
		model.addAttribute("pageMaker", pageMaker);
		
		return "tip/list";
		
	}
		
	// 게시판 조회
		@RequestMapping(value = "tip/readView", method = RequestMethod.GET)
		public String read(TipVO tipVO, @ModelAttribute("scri") SearchCriteria scri, Model model) throws Exception{
			logger.info("read");
			
			model.addAttribute("read", service.read(tipVO.getBno()));
			model.addAttribute("scri", scri);
			
			List<TipReplyVO> tipreplyList = replyService.readReply(tipVO.getBno());
			model.addAttribute("replyList", tipreplyList);
			
			return "tip/readView";
		}
		
		// 게시판 수정뷰
		@RequestMapping(value = "tip/updateView", method = RequestMethod.GET)
		public String updateView(TipVO tipVO, @ModelAttribute("scri") SearchCriteria scri, Model model) throws Exception{
			logger.info("updateView");
			
			model.addAttribute("update", service.read(tipVO.getBno()));
			model.addAttribute("scri", scri);
			
			return "tip/updateView";
		}
		
		// 게시판 수정
		@RequestMapping(value = "tip/update", method = RequestMethod.POST)
		public String update(TipVO tipVO, @ModelAttribute("scri") SearchCriteria scri, RedirectAttributes rttr) throws Exception{
			logger.info("update");
			
			service.update(tipVO);
			
			rttr.addAttribute("page", scri.getPage());
			rttr.addAttribute("perPageNum", scri.getPerPageNum());
			rttr.addAttribute("searchType", scri.getSearchType());
			rttr.addAttribute("keyword", scri.getKeyword());
			
			return "redirect:/tip/list";
		}

		// 게시판 삭제
		@RequestMapping(value = "tip/delete", method = RequestMethod.POST)
		public String delete(TipVO tipVO, @ModelAttribute("scri") SearchCriteria scri, RedirectAttributes rttr) throws Exception{
			logger.info("delete");
			
			service.delete(tipVO.getBno());
			
			rttr.addAttribute("page", scri.getPage());
			rttr.addAttribute("perPageNum", scri.getPerPageNum());
			rttr.addAttribute("searchType", scri.getSearchType());
			rttr.addAttribute("keyword", scri.getKeyword());
			
			return "redirect:/tip/list";
		}
		
		//댓글 작성
		@RequestMapping(value="tip/replyWrite", method = RequestMethod.POST)
		public String replyWrite(TipReplyVO vo, SearchCriteria scri, RedirectAttributes rttr) throws Exception {
			logger.info("tipreply Write");
			
			replyService.writeReply(vo);
			
			rttr.addAttribute("bno", vo.getBno());
			rttr.addAttribute("page", scri.getPage());
			rttr.addAttribute("perPageNum", scri.getPerPageNum());
			rttr.addAttribute("searchType", scri.getSearchType());
			rttr.addAttribute("keyword", scri.getKeyword());
			
			return "redirect:/tip/readView";
		}
		
		//댓글 수정 GET
		@RequestMapping(value="tip/replyUpdateView", method = RequestMethod.GET)
		public String replyUpdateView(TipReplyVO vo, SearchCriteria scri, Model model) throws Exception {
			logger.info("tipreply Write");
			
			model.addAttribute("replyUpdate", replyService.selectReply(vo.getRno()));
			model.addAttribute("scri", scri);
			
			return "tip/replyUpdateView";
		}
		
		//댓글 수정 POST
		@RequestMapping(value="tip/replyUpdate", method = RequestMethod.POST)
		public String replyUpdate(TipReplyVO vo, SearchCriteria scri, RedirectAttributes rttr) throws Exception {
			logger.info("reply Write");
			
			replyService.updateReply(vo);
			
			rttr.addAttribute("bno", vo.getBno());
			rttr.addAttribute("page", scri.getPage());
			rttr.addAttribute("perPageNum", scri.getPerPageNum());
			rttr.addAttribute("searchType", scri.getSearchType());
			rttr.addAttribute("keyword", scri.getKeyword());
			
			return "redirect:/tip/readView";
		}
		
		//댓글 삭제 GET
		@RequestMapping(value="tip/replyDeleteView", method = RequestMethod.GET)
		public String replyDeleteView(TipReplyVO vo, SearchCriteria scri, Model model) throws Exception {
			logger.info("reply Write");
			
			model.addAttribute("replyDelete", replyService.selectReply(vo.getRno()));
			model.addAttribute("scri", scri);
			

			return "tip/replyDeleteView";
		}
		
		//댓글 삭제
		@RequestMapping(value="tip/replyDelete", method = RequestMethod.POST)
		public String replyDelete(TipReplyVO vo, SearchCriteria scri, RedirectAttributes rttr) throws Exception {
			logger.info("reply Write");
			
			replyService.deleteReply(vo);
			
			rttr.addAttribute("bno", vo.getBno());
			rttr.addAttribute("page", scri.getPage());
			rttr.addAttribute("perPageNum", scri.getPerPageNum());
			rttr.addAttribute("searchType", scri.getSearchType());
			rttr.addAttribute("keyword", scri.getKeyword());
			
			return "redirect:/tip/readView";
		}

	
}