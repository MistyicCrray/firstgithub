package com.springboot.service;

import java.util.List;
import java.util.Map;

import com.springboot.entity.News;

public interface NewsService {

	int addnews(News news);

	int deletenews(String id);

	int updatenews(Map<String, Object> map);

	List<News> selectAll(Map<String, Object> map);

	News selectById(String id);
}
