package com.example.monthlydrive.repository;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
	@Column(length = 20)
	private String date = null; 
	
	/** 時間 */
	@Column(length = 20)
	private LocalDateTime time = LocalDateTime.now();
	
	@Column(length = 20)
	private LocalDateTime time_2 = null;
	
	@Column(length = 20)
	private String time_3 = null;	
	
	@Column(length = 20)
	private String time_4 = null;
	
	@Column(length = 20)
	private String time_5 = null;	
	
	@Column(length = 20)
	private String time_6 = null;
	
	/** 車名 */
	@Column(length = 20)
	private String car = null;
	
	/** 運転者 */
	@Column(length = 20)
	private String driver = null;
	
	/** 用途 */
	@Column(length = 20)
	private String purpose = null;
	
	/** 目的地 */
	@Column(length = 20)
	private String destination = null;
	
	/** メーター */
	@Column(length = 20)
	private int meter;
	
	@Column(length = 20)
	private int meter_2;
	
	@Column(length = 20)
	private int meter_3;	
	
	/** 私用料金 */
	@Column(length = 20)
	private int privatefee;
	
	private Date createdDate = null;
	
	private Date updatedDate = null;
	
	private boolean deleted = false;
	
}
