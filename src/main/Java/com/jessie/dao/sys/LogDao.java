package com.jessie.dao.sys;

import com.jessie.common.persistence.CrudDao;
import com.jessie.common.persistence.annotation.MyBatisDao;
import com.jessie.model.sys.Log;

/**
 * 日志DAO接口
 */
@MyBatisDao
public interface LogDao extends CrudDao<Log> {

}
