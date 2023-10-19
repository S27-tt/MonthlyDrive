package com.example.monthlydrive.repository;


import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;
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
	public static Record createRecord(Record record ,Record form) {
		String id =UUID.randomUUID().toString();
		record.setId(id);
		record.setDate(form.getTime().format(DateTimeFormatter.ofPattern("MM月dd日(E)", Locale.JAPANESE)));
		record.setTime_2(form.getTime());
		record.setTime_3(form.getTime().format(DateTimeFormatter.ofPattern("HH:mm")));
		Date current = new Date();
		record.setCreatedDate(current);
		record.setUpdatedDate(current);
		return record;
		
	}
	/** 更新内容を設定した運転日報を生成する */
	public static Record updateRecord(Record record, Record form) {
		
		String time4 = form.getTime().format(DateTimeFormatter.ofPattern("MM月dd日(E)", Locale.JAPANESE));
		String time5 = form.getTime().format(DateTimeFormatter.ofPattern("MMdd"));
		String time6 = form.getTime_2().format(DateTimeFormatter.ofPattern("MMdd"));
		int time7 = Integer.parseInt(time5);
		int time8 = Integer.parseInt(time6);
		
		if(time8 - time7 == 0) {
			time5 = form.getTime().format(DateTimeFormatter.ofPattern("HH:mm"));
			time6 = form.getTime_2().format(DateTimeFormatter.ofPattern("HH:mm"));
		}else if (time8 - time7 == 1) {
			time5 = form.getTime().format(DateTimeFormatter.ofPattern("HH:mm"));
			time6 = form.getTime_2().format(DateTimeFormatter.ofPattern("HH:mm(翌日)"));
		}else {
			time5 = form.getTime().format(DateTimeFormatter.ofPattern("HH:mm"));
			time6 = form.getTime_2().format(DateTimeFormatter.ofPattern("HH:mm(MM/dd)"));
		}
		
		Long time1 = ChronoUnit.MINUTES.between(form.getTime(),form.getTime_2());
		Long time2 = time1 / 60;
		Long time3 = time1 % 60;
		String hourStr = String.format("%02d", time2);
		String minStr = String.format("%02d", time3);
		
		record.setDate(time4);
		record.setTime(form.getTime());
		record.setTime_2(form.getTime_2());
		record.setTime_3(time5);
		record.setTime_4(time6);
		record.setTime_5(hourStr+":"+minStr);
		record.setTime_6(String.valueOf(time1));
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
