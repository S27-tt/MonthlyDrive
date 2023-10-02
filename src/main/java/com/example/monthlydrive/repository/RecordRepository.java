package com.example.monthlydrive.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/** 運転情報のリポジトリー */
@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {

	public Optional<Record> findById(String id);

}
