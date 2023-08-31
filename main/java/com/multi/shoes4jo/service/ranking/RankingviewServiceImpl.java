package com.multi.shoes4jo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.shoes4jo.mapper.RankingMapper;
import com.multi.shoes4jo.util.Criteria;
import com.multi.shoes4jo.vo.RankingVO;

@Service("rankingviewService")
public class RankingviewServiceImpl implements RankingviewService {

	@Autowired
	private RankingMapper rankingMapper;

	@Override
	public List<RankingVO> searchRanking() {
	    return rankingMapper.searchRanking();
	}


}
