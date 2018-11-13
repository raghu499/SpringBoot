package com.mss.dao.repo;

import com.mss.dao.TblMysql;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MysqlMessageRepo extends JpaRepository<TblMysql, Long>{

	
	
}
