package com.example.monthlydrive.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	public String index(Model model) {
		model.addAttribute("form", RecordFactory.newRecord());
		model = this.setList(model);
		model.addAttribute("path", "create");
		return "layout";
	}

	private Model setList(Model model) {
		Iterable<Record> list = repository.findAll();
		model.addAttribute("list", list);
		return model;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("form") Record form, BindingResult result,
            Model model) {
        if (!result.hasErrors()) {
            repository.saveAndFlush(RecordFactory.createRecord(form));
            model.addAttribute("form", RecordFactory.newRecord());
        }
        model = this.setList(model);
        model.addAttribute("path", "create");
        return "layout";
    }
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(@ModelAttribute("form") Record form, Model model) {
        Optional<Record> record = repository.findById(form.getId());
        model.addAttribute("form", record);
        model = setList(model);
        model.addAttribute("path", "update");
        return "layout";
    }
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("form") Record form, Model model) {
        Optional<Record> record = repository.findById(form.getId());
        repository.saveAndFlush(RecordFactory.updateRecord(record.get(), form));
        model.addAttribute("form", RecordFactory.newRecord());
        model = setList(model);
        model.addAttribute("path", "create");
        return "layout";
    }

}
