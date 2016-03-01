package com.tianque.plugin.analysisNew.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.tianque.core.base.AbstractBaseDao;
import com.tianque.domain.property.OrganizationLevel;
import com.tianque.domain.property.PropertyTypes;

@Repository("areaOrgStatNewDao")
public class AreaOrgStatNewDaoImpl extends AbstractBaseDao implements
		AreaOrgStatNewDao {

	@Override
	public Map<String, Object> getAreaOrgStatDate(String orgCode,
			Long provincePropertyDomainId, Long cityPropertyDomainId,
			Long districtPropertyDomainId, Long townPropertyDomainId,
			Long villagePropertyDomainId, Long gridPropertyDomainId,
			Long gridPropertyDomainIdByType) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orgCode", orgCode);
		map.put("provincePropertyDomainId", provincePropertyDomainId);
		map.put("cityPropertyDomainId", cityPropertyDomainId);
		map.put("districtPropertyDomainId", districtPropertyDomainId);
		map.put("townPropertyDomainId", townPropertyDomainId);
		map.put("villagePropertyDomainId", villagePropertyDomainId);
		map.put("gridPropertyDomainId", gridPropertyDomainId);
		map.put("gridPropertyDomainIdByType", gridPropertyDomainIdByType);
		return (Map<String, Object>) getSqlMapClientTemplate().queryForObject(
				"organization.countAreaOrgStat", map);

	}

	private Map<String, Object> getParMap() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("organization_level", PropertyTypes.ORGANIZATION_LEVEL);
		map.put("province", OrganizationLevel.PROVINCE);
		map.put("city", OrganizationLevel.CITY);
		map.put("district", OrganizationLevel.DISTRICT);
		map.put("village", OrganizationLevel.VILLAGE);
		map.put("grid", OrganizationLevel.GRID);
		map.put("town", OrganizationLevel.TOWN);
		map.put("organization_type", PropertyTypes.ORGANIZATION_TYPE);
		return map;

	}

}
