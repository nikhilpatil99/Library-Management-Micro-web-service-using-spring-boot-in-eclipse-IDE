package com.spring.database.dao;

import org.springframework.data.repository.CrudRepository;

import com.spring.database.model.Ticket;



public interface TicketDao extends CrudRepository<Ticket, String>{

}
