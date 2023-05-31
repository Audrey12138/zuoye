package com.controller;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.beans.GoodsInfo;
import com.service.GoodsService;
@Controller  
@RequestMapping("/goods")
	public class GoodsController {	
	@Resource
	private GoodsService goodsService;
	   //查询商品列表
		@RequestMapping("/goods-manager")
		public String getAll(ModelMap m) {
			List<GoodsInfo> goodsList = goodsService.getAll();
			m.put("goodsList", goodsList);
			return "goods-manager";
		}
		
		//跳转：添加商品
		@GetMapping("/goods-add")
		public String gotoAddGoods() {
			return "/goods-add";  
		}
		
		//添加商品成功
		@RequestMapping("/goods/goods-add")
		public String addGoods(GoodsInfo goods,ModelMap m) {
			 goodsService.addGoods(goods);
			 m.put("msg", "商品添加成功");
			 return "redirect:/goods/goods-manager";
		}
		
		//真正的提交表单，修改商品信息
		@PostMapping("/update")
		public String update(GoodsInfo goods,ModelMap m) {
			goodsService.updateGoods(goods);
			//m.put("goods", goods); 
			//m.put("msg", "商品修改成功");
			//return "goods-update";
			
			return "forward:/goods/getall";
		}
		
		//删除
		@GetMapping("/delete/{goodsCode}")
		public String delete(@PathVariable("goodsCode") Integer goodsCode,ModelMap m)
		{
			goodsService.deleteGoods(goodsCode);
			m.put("msg"	,"删除成功");
			return "redirect:/goods-manager";
		}
				}
				