package com.example.monthlydrive.repository;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/** 運転情報 */
@Entity
@Table(name = "record")
@Data
public class Record {
	/** ID */
	@Id
	@Column
	private String id = null;

	/** 日付 */
	@Column(length = 20, nullable = false)
	private Date date = null; 
	
	/** 時間 */
	@Column(length = 20, nullable = false)
	private String time = null;
	
	/** 車名 */
	@Column(length = 20, nullable = false)
	private String car = null;
	
	/** 運転者 */
	@Column(length = 20, nullable = false)
	private String driver = null;
	
	/** 用途 */
	@Column(length = 20, nullable = false)
	private String purpose = null;
	
	/** 目的地 */
	@Column(length = 20, nullable = false)
	private String destination = null;
	
	/** メーター */
	@Column(length = 20, nullable = false)
	private String meter = null;
	
	/** 私用料金 */
	@Column(length = 20, nullable = false)
	private String privatefee = null;
	
	private Date createdDate = null;
	
	private Date updatedDate = null;
	
	private boolean deleted = false;
	
}
