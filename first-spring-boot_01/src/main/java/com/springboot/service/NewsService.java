package com.springboot.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.News;
import com.springboot.mapper.NewsMapper;
import com.springboot.tools.UUIDUtils;

@Service
public class NewsService{

	@Autowired
	private NewsMapper newsMapper;

	public int addnews(News news) {
		news.setId(UUIDUtils.get16UUID());
		news.setCreatedate(new Date());
		news.setUpdatedate(new Date());
		return newsMapper.insert(news);
	}

	public int deletenews(String id) {
		return newsMapper.deleteByPrimaryKey(id);
	}

	public int updatenews(Map<String, Object> map) {
		return newsMapper.update(map);
	}

	public List<News> selectAll(Map<String, Object> map) {
		return newsMapper.findList(map);
	}

	public News selectById(String id) {
		return newsMapper.selectByPrimaryKey(id);
	}

}
