package com.springboot.controller;

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
import com.springboot.entity.Address;
import com.springboot.entity.User;
import com.springboot.service.AddressService;
import com.springboot.tools.CurrentUser;
import com.springboot.tools.LoginRequired;
import com.springboot.tools.Result;
import com.springboot.tools.ResultGenerator;
import com.springboot.tools.TableData;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private AddressService addressService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	@LoginRequired
	public Result add(@RequestBody Address address, @CurrentUser User user) {
		address.setUserid(user.getId());
		System.out.println(address.getProvince());
		return ResultGenerator.genSuccessResult(addressService.add(address));
	}

	@LoginRequired
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Result delete(@PathVariable String id, @CurrentUser User user) {
		return ResultGenerator.genSuccessResult(addressService.delete(id));
	}

	@LoginRequired
	@RequestMapping(value = "", method = RequestMethod.PUT)
	public Result update(@RequestParam Map<String, Object> map, @CurrentUser User user) {
		return ResultGenerator.genSuccessResult(addressService.update(map));
	}

	@LoginRequired
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Result findById(@PathVariable String id, @CurrentUser User user) {
		return ResultGenerator.genSuccessResult(addressService.findById(id));
	}

	@LoginRequired
	@RequestMapping(value = "", method = RequestMethod.GET)
	public Result findList(@RequestParam(required = false) Map<String, Object> map, @CurrentUser User user,
			Integer pageNum, Integer size) {
		map.put("userid", user.getId());
		Page<Address> page = PageHelper.startPage(pageNum == null ? 1 : pageNum, size == null ? 5 : size,
				"status");
		return ResultGenerator.genSuccessResult(new TableData<Address>(page.getTotal(), addressService.findList(map)));
	}
}
