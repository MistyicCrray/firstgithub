package com.springboot.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.Address;
import com.springboot.mapper.AddressMapper;
import com.springboot.tools.UUIDUtils;

@Service
public class AddressService {

	@Autowired
	private AddressMapper addressMapper;

	/**
	 * 添加地址
	 * 
	 * @param address
	 * @return
	 */
	public int add(Address address) {
		address.setAddrid(UUIDUtils.get16UUID());
		address.setStatus("1"); // 非默认地址
		address.setCreatedate(new Date());
		return addressMapper.insert(address);
	}

	/**
	 * 修改地址
	 * 
	 * @param map
	 * @return
	 */
	public Integer update(Map<String, Object> map) {
		if (map.get("status") != "") {
			Map<String, Object> addrmap = new HashMap<String, Object>();
			addrmap.put("status", "0");
			List<Address> addrssList = findList(addrmap);
			if (addrssList.size() != 0) {
				addrssList.get(0).setStatus("1");
				addressMapper.updateByPrimaryKey(addrssList.get(0));
			}
		}
		return addressMapper.update(map);
	}

	/**
	 * 添加地址
	 * 
	 * @param id
	 * @return
	 */
	public int delete(String id) {
		return addressMapper.deleteByPrimaryKey(id);
	}

	/**
	 * 查询地址
	 * 
	 * @param id
	 * @return
	 */
	public Address findById(String id) {
		return addressMapper.selectByPrimaryKey(id);
	}

	/**
	 * 查询地址
	 * 
	 * @param map
	 * @return
	 */
	public List<Address> findList(Map<String, Object> map) {
		return addressMapper.findList(map);
	}
}
