package com.tstar.ocs.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tstar.ocs.dao.SidPlanRateMapper;
import com.tstar.ocs.model.SidPlanRate;
import com.tstar.ocs.service.SidPlanRateService;
import com.tstar.util.UUID;

@Service
public class SidPlanRateServiceImpl implements SidPlanRateService {

	@Resource
	private SidPlanRateMapper dao;
	
	public List<SidPlanRate> selectByFk(String fk) {
		return dao.selectByPlanId(fk);
	}

	public String[] insert(SidPlanRate obj) {
		obj.setId(UUID.get());
		obj.setCreateTime(new Date());
		int res = dao.insert(obj);
		if (res > 0) {
			return new String[]{"0", "添加成功！"};
		} else {
			return new String[]{"1", "添加失败！"};
		}
	}

	public String[] update(SidPlanRate obj) {
		obj.setUpdateTime(new Date());
		int res = dao.updateByPrimaryKeySelective(obj);
		if (res > 0) {
			return new String[]{"0", "修改成功！"};
		} else {
			return new String[]{"1", "修改失败！"};
		}
	}

	public String[] delete(String id) {
		int res = dao.deleteByPrimaryKey(id);
		if (res > 0) {
			return new String[]{"0", "删除成功！"};
		} else {
			return new String[]{"1", "删除失败！"};
		}
	}

}
