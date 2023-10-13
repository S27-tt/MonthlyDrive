package com.example.monthlydrive.repository;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.UUID;

/** 運転情報のファクトリークラス */
public class RecordFactory {

	/** 非公開 */
	private RecordFactory() {
		
	}
	/** 新規の運転情報を生成する */
	public static Record newRecord() {
		Record record = new Record();
		return record;
	}
	
	/** 入力内容を設定した運転日報を生成する */
	public static Record createRecord(Record record) {
		String id =UUID.randomUUID().toString();
		record.setId(id);
		Date current = new Date();
		record.setCreatedDate(current);
		record.setUpdatedDate(current);
		return record;
		
	}
	/** 更新内容を設定した運転日報を生成する */
	public static Record updateRecord(Record record, Record form) {
		
		Long time1 = ChronoUnit.MINUTES.between(form.getTime(),form.getTime_2());
		Long time2 = time1 / 60;
		Long time3 = time1 % 60;
		String hourStr = String.format("%02d", time2);
		String minStr = String.format("%02d", time3);
		
		record.setDate(form.getDate());
		record.setTime(form.getTime());
		record.setTime_2(form.getTime_2());
		record.setTime_3(hourStr+":"+minStr);
		record.setTime_4(String.valueOf(time1));
		record.setCar(form.getCar());
		record.setDriver(form.getDriver());
		record.setPurpose(form.getPurpose());
		record.setDestination(form.getDestination());
		record.setMeter(form.getMeter());
		record.setMeter_2(form.getMeter_2());
		record.setMeter_3(form.getMeter_2()-form.getMeter());
		record.setPrivatefee(form.getPrivatefee());
		Date current = new Date();
		record.setUpdatedDate(current);
		return record;
	}
	
	public static Record deleteRecord(Record record) {
        record.setDeleted(true);
        Date current = new Date();
        record.setUpdatedDate(current);
        return record;
    }
	
}
