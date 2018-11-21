package com.springboot.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.springboot.entity.News;
import com.springboot.service.NewsService;
import com.springboot.tools.Result;
import com.springboot.tools.ResultGenerator;
import com.springboot.tools.TableData;

@RestController
@RequestMapping("/news")
public class NewsController {

	@Autowired
	private NewsService newsService;

	/**
	 * 查询
	 * 
	 * @Title: getAll
	 * @Description: TODO
	 * @param map
	 * @return Result
	 * @author hlx
	 * @date 2018年11月19日下午5:18:54
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public Result getAll(Integer pageNum, Integer size, @RequestParam(required = false) Map<String, Object> map) {
		Page<News> page = PageHelper.startPage(pageNum == null ? 1 : pageNum, size == null ? 5 : size);
		List<News> list = newsService.findList(map);
		return ResultGenerator.genSuccessResult(new TableData<News>(page.getTotal(), list));
	}

	/**
	 * 添加
	 * 
	 * @Title: add
	 * @Description: TODO
	 * @param news
	 * @return Result
	 * @author hlx
	 * @date 2018年11月19日下午5:20:11
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Result add(@ModelAttribute News news) {
		return ResultGenerator.genSuccessResult(newsService.add(news));
	}

	/**
	 * 删除
	 * 
	 * @Title: add
	 * @Description: TODO
	 * @param news
	 * @return Result
	 * @author hlx
	 * @date 2018年11月19日下午5:20:45
	 */
	@RequestMapping(value = "", method = RequestMethod.DELETE)
	public Result delete(@PathVariable String id) {
		return ResultGenerator.genSuccessResult(newsService.delete(id));
	}

	/**
	 * 修改
	 * 
	 * @Title: update
	 * @Description: TODO
	 * @param map
	 * @return Result
	 * @author hlx
	 * @date 2018年11月19日下午5:21:54
	 */
	@RequestMapping(value = "", method = RequestMethod.PUT)
	public Result update(@RequestParam(required = false) Map<String, Object> map) {
		return ResultGenerator.genSuccessResult(newsService.update(map));
	}

	/**
	 * 详情
	* @Title: findById 
	* @Description: TODO 
	* @param id
	* @return Result
	* @author hlx
	* @date 2018年11月19日下午5:27:36
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Result findById(@PathVariable String id) {
		return ResultGenerator.genSuccessResult(newsService.findById(id));
	}

}
