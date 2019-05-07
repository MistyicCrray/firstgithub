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
import com.springboot.entity.Collection;
import com.springboot.entity.User;
import com.springboot.service.CollectionService;
import com.springboot.tools.CurrentUser;
import com.springboot.tools.LoginRequired;
import com.springboot.tools.Result;
import com.springboot.tools.ResultGenerator;
import com.springboot.tools.TableData;

@RestController
@RequestMapping("/collection")
public class CollectionController {

	@Autowired
	private CollectionService collectionService;

	@LoginRequired
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Result add(@RequestBody Collection collection, @CurrentUser User currentUser) {
		collection.setUserid(currentUser.getId());
		return ResultGenerator.genSuccessResult(collectionService.add(collection));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Result delete(@PathVariable(value = "id") String id) {
		return ResultGenerator.genSuccessResult(collectionService.delete(id));
	}

	@LoginRequired
	@RequestMapping(value = "", method = RequestMethod.GET)
	public Result findList(Integer pageNum, Integer size, @RequestParam Map<String, Object> map,
			@CurrentUser User currentUser) {
		map.put("userId", currentUser.getId());
		Page<User> page = PageHelper.startPage(pageNum == null ? 1 : pageNum, size == null ? 5 : size);
		List<Map<String, Object>> findList = collectionService.findList(map);
		return ResultGenerator.genSuccessResult(new TableData<Map<String, Object>>(page.getTotal(), findList));
	}
	
}
