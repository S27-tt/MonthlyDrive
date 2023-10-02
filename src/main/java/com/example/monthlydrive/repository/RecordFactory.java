package com.example.monthlydrive.repository;

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
		record.setDate(form.getDate());
		record.setTime(form.getTime());
		record.setCar(form.getCar());
		record.setDriver(form.getDriver());
		record.setPurpose(form.getPurpose());
		record.setDestination(form.getDestination());
		record.setMeter(form.getMeter());
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
