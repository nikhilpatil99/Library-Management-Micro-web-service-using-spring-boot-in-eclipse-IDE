package com.spring.database.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.database.dao.TicketDao;
import com.spring.database.model.Ticket;



@RestController
@RequestMapping("/ticket")
public class TicketController {
	@Autowired
	private TicketDao dao;
	
	
	
	@GetMapping
	public String check() {
		
		return "Working Correctly";
	}
	

	@PostMapping("/bookTickets")
	public String bookTicket(@RequestBody List<Ticket> tickets) {
		dao.saveAll(tickets);
		return "ticket booked : " + tickets.size();
	}

	@GetMapping("/getTickets")
	public List<Ticket> getTickets() {
		return (List<Ticket>) dao.findAll();
	}
	@RequestMapping(method = RequestMethod.DELETE, value = "/DelTickets/{id}")
	public void Delete(@PathVariable String id) {
		dao.deleteById(id);
		
	}
	@RequestMapping(method = RequestMethod.PUT, value= "/updateTicket/{id}")
	public void update(@RequestBody List<Ticket> tickets,@PathVariable String id)
	{
		dao.saveAll(tickets);
	}
	@RequestMapping("/getTickets/{id}")
	public void one(@PathVariable String id) {
		
		dao.findById(id);
		
	}
	

}