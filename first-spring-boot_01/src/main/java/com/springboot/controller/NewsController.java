package com.springboot.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.service.NewsService;
import com.springboot.tools.Result;
import com.springboot.tools.ResultGenerator;

@RestController
@RequestMapping("/news")
public class NewsController {

	@Autowired
	private NewsService newsService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public Result getAll(@RequestParam(required = false) Map<String, Object> map) {
		return ResultGenerator.genSuccessResult(newsService.selectAll(map));
	}
}
