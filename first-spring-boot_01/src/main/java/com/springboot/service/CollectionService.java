package com.springboot.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.Collection;
import com.springboot.mapper.CollectionMapper;
import com.springboot.tools.ServiceException;
import com.springboot.tools.UUIDUtils;

@Service
public class CollectionService {

	@Autowired
	private CollectionMapper collectionMapper;

	/**
	 * 添加
	 * 
	 * @param collection
	 * @return
	 */
	public int add(Collection collection) {
		collection.setCollectionid(UUIDUtils.get16UUID());
		Map<String, Object> map = new HashMap<>();
		map.put("userId", collection.getUserid());
		map.put("productId", collection.getProductid());
		List<Map<String, Object>> list = collectionMapper.findList(map);
		if (list.size() > 0) {
			throw new ServiceException("您已收藏过该商品");
		}
		return collectionMapper.insert(collection);
	}

	/**
	 * 删除
	 * 
	 * @param collection
	 * @return
	 */
	public int delete(String id) {
		return collectionMapper.deleteByPrimaryKey(id);
	}

	/**
	 * 根据id查询
	 * 
	 * @param collection
	 * @return
	 */
	public Collection findById(String id) {
		return collectionMapper.selectByPrimaryKey(id);
	}

	/**
	 * 查询列表
	 * 
	 * @param collection
	 * @return
	 */
	public List<Map<String, Object>> findList(Map<String, Object> map) {
		return collectionMapper.findList(map);
	}
}
