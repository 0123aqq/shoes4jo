package com.multi.shoes4jo.service.goods;

import java.util.List;

import com.multi.shoes4jo.vo.GoodsDetailVO;

public interface GoodsDetailService {
	
    public void insert(GoodsDetailVO vo);
    
    public List<GoodsDetailVO> selectAllGoods();

    public GoodsDetailVO selectOne(int gno);
    
    public void update(GoodsDetailVO vo);
    
    public void delete(int gno);

}