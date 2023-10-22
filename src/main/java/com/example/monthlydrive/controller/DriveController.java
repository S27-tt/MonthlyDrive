package com.example.monthlydrive.controller;

import java.util.Optional;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.monthlydrive.repository.RecordFactory;
import com.example.monthlydrive.repository.RecordRepository;
import com.example.monthlydrive.repository.Record;

@Controller
public class DriveController {

	@Autowired
	private RecordRepository repository;

	@RequestMapping(value = "/", method = RequestMethod.GET)

	public String index2(Model model) {
		model.addAttribute("form", RecordFactory.newRecord());
		model = this.setList(model);
		model.addAttribute("path", "create");
		return "result";
	}

	@RequestMapping(value = "/start", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("form", RecordFactory.newRecord());
		model = this.setList(model);
		model.addAttribute("path", "create");
		return "layout";
	}

	private Model setList(Model model) {
		Iterable<Record> list = repository.findByDeletedFalseOrderByDateAsc();

		Long time1 = 0L;
		int sum2 = 0;
		int sum3 = 0;

		for (Record record : list) {
			LocalDateTime time2 = record.getTime_2();
			if (time2 != null) {
				time1 += ChronoUnit.MINUTES.between(record.getTime(), time2);
				sum2 += record.getPrivatefee();
				sum3 += record.getMeter_3();
			}
		}

		Long hour = time1 / 60;
		Long time3 = time1 % 60;
		String hourStr = String.format("%02d", hour);
		String minStr = String.format("%02d", time3);
		model.addAttribute("list", list);
		model.addAttribute("sum1", hourStr + ":" + minStr);
		model.addAttribute("sum2", sum2);
		model.addAttribute("sum3", sum3);

		return model;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@ModelAttribute("form") @Validated Record form, BindingResult result, Model model) {
		if (!result.hasErrors()) {
			repository.saveAndFlush(RecordFactory.createRecord(form, form));
			model.addAttribute("form", RecordFactory.newRecord());
			model = this.setList(model);
			model.addAttribute("path", "create");
			return "result";
		}
		
		return "layout";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@ModelAttribute("form") Record form, Model model) {
		Optional<Record> record = repository.findById(form.getId());
		model.addAttribute("form", record);
		model = setList(model);
		model.addAttribute("path", "update");
		return "arrive";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("form") @Validated Record form, BindingResult result, Model model) {
		if (!result.hasErrors()) {
			Optional<Record> record = repository.findById(form.getId());
			repository.saveAndFlush(RecordFactory.updateRecord(record.get(), form));
			model.addAttribute("form", RecordFactory.newRecord());
			model = setList(model);
			model.addAttribute("path", "create");
			return "result";
		}
		
	
		
		return "arrive";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(@ModelAttribute("form") Record form, Model model) {
		Optional<Record> record = repository.findById(form.getId());
		repository.saveAndFlush(RecordFactory.deleteRecord(record.get()));
		model.addAttribute("form", RecordFactory.newRecord());
		model = setList(model);
		model.addAttribute("path", "create");
		return "result";
	}

}
