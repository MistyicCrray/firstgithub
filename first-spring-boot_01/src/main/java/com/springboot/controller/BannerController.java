package com.springboot.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.springboot.entity.Banner;
import com.springboot.service.BannerService;
import com.springboot.tools.Result;
import com.springboot.tools.ResultGenerator;
import com.springboot.tools.TableData;

/**
 * 轮播图
 * 
 * @author Administrator
 *
 */

@RestController
@RequestMapping("/banner")
public class BannerController {

	@Autowired
	private BannerService bannerService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public Result add(@RequestBody Banner banner) {
		return ResultGenerator.genSuccessResult(bannerService.add(banner));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Result delete(@PathVariable String id) {
		return ResultGenerator.genSuccessResult(bannerService.delete(id));
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public Result update(@RequestBody Banner banner) {
		return ResultGenerator.genSuccessResult(bannerService.add(banner));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Result find(@PathVariable String id) {
		return ResultGenerator.genSuccessResult(bannerService.find(id));
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public Result findList(@RequestParam(required = false) Map<String, Object> map, Integer size, Integer pageNum) {
		Page<Banner> page = PageHelper.startPage(pageNum == null ? 1 : pageNum, size == null ? 5 : size);
		List<Banner> list = bannerService.findList(map);
		return ResultGenerator.genSuccessResult(new TableData<Banner>(page.getTotal(), list));
	}
}
