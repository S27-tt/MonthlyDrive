package com.example.monthlydrive.repository;

import java.time.LocalDateTime;
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

	/** 出発時間 */
	@Column(length = 20)
	private LocalDateTime startTime = LocalDateTime.now();

	/** 到着時間 */
	@Column(length = 20)
	private LocalDateTime endTime = null;

	/** 出発時間修正 */
	@Column(length = 20)
	private String correctSt = null;

	/** 到着時時間修正 */
	@Column(length = 20)
	private String correctEt = null;

	/** 時間差分 */
	@Column(length = 20)
	private String timeLag = null;

	/** 車名 */
	@Column(length = 20)
	private String car = null;

	/** 運転者 */
	@Column(length = 20)
	private String driver = null;

	/** 用途 */
	@Column(length = 20)
	private String purpose = null;

	/** 目的・行く先 */
	@Column(length = 20)
	private String destination = null;

	/** 出発メーター */
	@Column(length = 20)
	private int startMeter;

	/** 到着メーター */
	@Column(length = 20)
	private int endMeter;

	/** メーター差分 */
	@Column(length = 20)
	private int meterDiff;

	/** 私用料金 */
	@Column(length = 20)
	private int privatefee;

	/** 作成日時 */
	private Date createdDate = null;

	/** 更新日時 */
	private Date updatedDate = null;

	private boolean deleted = false;

}
