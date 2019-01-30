package com.springboot.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.News;
import com.springboot.mapper.NewsMapper;
import com.springboot.tools.UUIDUtils;

@Service
public class NewsService {

	@Autowired
	private NewsMapper newsMapper;

	public int add(News news) {
		news.setId(UUIDUtils.get16UUID());
		return newsMapper.insert(news);
	}

	public int delete(String id) {
		return newsMapper.deleteByPrimaryKey(id);
	}

	public int update(Map<String, Object> map) {
		return newsMapper.update(map);
	}

	public List<News> findList(Map<String, Object> map) {
		return newsMapper.findList(map);
	}

	public News findById(String id) {
		return newsMapper.selectByPrimaryKey(id);
	}

}
