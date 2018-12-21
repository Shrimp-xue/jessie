package com.jessie.dao.sys;

import com.jessie.common.persistence.CrudDao;
import com.jessie.common.persistence.annotation.MyBatisDao;
import com.jessie.model.sys.Dict;

import java.util.List;


/**
 * 字典DAO接口
 */
@MyBatisDao
public interface DictDao extends CrudDao<Dict> {

    public List<String> findTypeList(Dict dict);

}
