package com.sriman.ticketbooking.ticket;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketJpaRepository extends JpaRepository<Ticket, Integer> {
}
