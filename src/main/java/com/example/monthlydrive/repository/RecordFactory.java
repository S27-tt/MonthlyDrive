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
	public static Record createRecord(Record record, Record form) {
		String id = UUID.randomUUID().toString();
		record.setId(id);
		record.setDate(form.getStartTime().format(DateTimeFormatter.ofPattern("MM月dd日(E)", Locale.JAPANESE)));
		record.setCorrectSt(form.getStartTime().format(DateTimeFormatter.ofPattern("HH:mm")));
		Date current = new Date();
		record.setCreatedDate(current);
		record.setUpdatedDate(current);
		return record;

	}

	/** 更新内容を設定した運転日報を生成する */
	public static Record updateRecord(Record record, Record form) {

		String date = form.getStartTime().format(DateTimeFormatter.ofPattern("MM月dd日(E)", Locale.JAPANESE));
		String correctSt = form.getStartTime().format(DateTimeFormatter.ofPattern("MMdd"));
		String correctEt = form.getEndTime().format(DateTimeFormatter.ofPattern("MMdd"));
		String correctEt2 = form.getEndTime().format(DateTimeFormatter.ofPattern("HH"));
		int correctSt2 = Integer.parseInt(correctSt);
		int correctEt3 = Integer.parseInt(correctEt);
		int correctEt4 = Integer.parseInt(correctEt2);
		int dateDiff = correctEt3 - correctSt2;
		String hourEt = String.valueOf(correctEt4 + (dateDiff * 24));

		if (dateDiff == 0) {
			correctSt = form.getStartTime().format(DateTimeFormatter.ofPattern("HH:mm"));
			correctEt = form.getEndTime().format(DateTimeFormatter.ofPattern("HH:mm"));
		} else if (dateDiff >= 1) {
			correctSt = form.getStartTime().format(DateTimeFormatter.ofPattern("HH:mm"));
			correctEt = form.getEndTime().format(DateTimeFormatter.ofPattern(hourEt + ":mm"));
		} else {
			correctSt = form.getStartTime().format(DateTimeFormatter.ofPattern("HH:mm"));
			correctEt = form.getEndTime().format(DateTimeFormatter.ofPattern("HH:mm"));
		}

		Long timeLag = ChronoUnit.MINUTES.between(form.getStartTime(), form.getEndTime());
		Long hour = timeLag / 60;
		Long min = timeLag % 60;
		String hourStr = String.format("%02d", hour);
		String minStr = String.format("%02d", min);

		record.setDate(date);
		record.setStartTime(form.getStartTime());
		record.setEndTime(form.getEndTime());
		record.setCorrectSt(correctSt);
		record.setCorrectEt(correctEt);
		record.setTimeLag(hourStr + ":" + minStr);
		record.setCar(form.getCar());
		record.setDriver(form.getDriver());
		record.setPurpose(form.getPurpose());
		record.setDestination(form.getDestination());
		record.setStartMeter(form.getStartMeter());
		record.setEndMeter(form.getEndMeter());
		record.setMeterDiff(form.getEndMeter() - form.getStartMeter());
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
