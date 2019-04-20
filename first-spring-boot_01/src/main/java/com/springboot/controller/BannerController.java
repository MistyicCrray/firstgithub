package com.springboot.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.springboot.entity.Banner;
import com.springboot.entity.User;
import com.springboot.service.BannerService;
import com.springboot.tools.CurrentUser;
import com.springboot.tools.LoginRequired;
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

	@LoginRequired
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Result add(@RequestParam(required = false) Map<String, Object> map, @CurrentUser User currentUser,
			@RequestParam(required = false) MultipartFile image)
			throws IllegalAccessException, InvocationTargetException {
		if (!currentUser.getUsertype().equals("1")) {
			return ResultGenerator.genFailResult("您无权访问");
		}
		Banner banner = new Banner();
		banner.setCreateBy(currentUser.getId());
		banner.setUpdateBy(currentUser.getId());
		BeanUtils.populate(banner, map);
		return ResultGenerator.genSuccessResult(bannerService.add(banner, image));
	}

	@LoginRequired
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Result delete(@PathVariable String id, @CurrentUser User currentUser) {
		if (!currentUser.getUsertype().equals("1")) {
			return ResultGenerator.genFailResult("您无权访问");
		}
		return ResultGenerator.genSuccessResult(bannerService.delete(id));
	}

	@LoginRequired
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Result update(@PathVariable String id, @RequestParam(required = false) MultipartFile image,
			@RequestParam(required = false) Map<String, Object> map, @CurrentUser User currentUser)
			throws IllegalAccessException, InvocationTargetException {
		if (!currentUser.getUsertype().equals("1")) {
			return ResultGenerator.genFailResult("您无权访问");
		}
		map.put("id", id);
		return ResultGenerator.genSuccessResult(bannerService.update(map, image));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Result find(@PathVariable String id) {
		return ResultGenerator.genSuccessResult(bannerService.find(id));
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public Result findList(@RequestParam(required = false) Map<String, Object> map, Integer size, Integer pageNum) {
		Page<Banner> page = PageHelper.startPage(pageNum == null ? 1 : pageNum, size == null ? 5 : size, "IS_TOP");
		List<Banner> list = bannerService.findList(map);
		return ResultGenerator.genSuccessResult(new TableData<Banner>(page.getTotal(), list));
	}
}
