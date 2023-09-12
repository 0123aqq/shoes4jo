package com.multi.shoes4jo.goodsdetail;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.shoes4jo.mapper.GoodsDetailMapper;

@Service("goodsDetailService")
public class GoodsDetailServiceImpl implements GoodsDetailService {

	@Autowired
	private GoodsDetailMapper goodsMapper;

	@Override
	public void insert(GoodsDetailVO vo) {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String dateString = formatter.format(new Date());

		vo.setDate(dateString);

		goodsMapper.insert(vo);
	}

	@Override
	public List<GoodsDetailVO> selectAllGoods() {
		return goodsMapper.selectAllGoods();
	}

	@Override
	public List<GoodsDetailVO> selectOne(String keyword) {
		return goodsMapper.selectOne(keyword);
	}

	@Override
	public void update(GoodsDetailVO vo) {
		goodsMapper.update(vo);
	}

	@Override
	public void delete(int gno) {
		goodsMapper.delete(gno);
	}

	@Override
	public void deleteByKeyword(String keyword) {
		goodsMapper.deleteByKeyword(keyword);
	}
}
