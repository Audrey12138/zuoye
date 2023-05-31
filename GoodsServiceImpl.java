package com.serviceImpl;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.beans.GoodsInfo;
import com.mapper.GoodsMapper;
import com.service.GoodsService;
				
	@Service @Transactional
	public class GoodsServiceImpl implements GoodsService {
	@Resource
	
	private GoodsMapper goodsMapper;
	
	public int addGoods(GoodsInfo goods) {
		return goodsMapper.addGoods(goods);
					}
				
	public void updateGoods(GoodsInfo goods) {
		goodsMapper.updateGoods(goods);
					}
				
	public int deleteGoods(int goodsCode) {
		return goodsMapper.deleteGoods(goodsCode);
					}
	
	public GoodsInfo getGoodsByGoodsCode(int goodsCode) {
		return goodsMapper.getGoodsByGoodsCode(goodsCode);
					}
	
	public List<GoodsInfo> getAll() {
		return goodsMapper.getAll();
					}
				
	
	
				}
				