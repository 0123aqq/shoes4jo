package com.multi.shoes4jo.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.multi.shoes4jo.service.RankingviewService;
import com.multi.shoes4jo.util.Criteria;
import com.multi.shoes4jo.util.PageMaker;
import com.multi.shoes4jo.vo.RankingVO;

@Controller
@RequestMapping("/ranking")
public class RankingController {

	@Autowired
	RankingviewService rankingviewService;

	
	
	@RequestMapping(value = "/ranking.do")
	public String list(Model model, Criteria cri) throws Exception {
	    
	    List<RankingVO> list;
	    list = rankingviewService.searchRanking();

	    model.addAttribute("list", list);

	    return "ranking/ranking_list";
	}
	

}
