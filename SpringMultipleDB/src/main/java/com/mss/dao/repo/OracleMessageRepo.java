package com.mss.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mss.dao.TblOracle;

public interface OracleMessageRepo extends JpaRepository<TblOracle, Long> {
}
