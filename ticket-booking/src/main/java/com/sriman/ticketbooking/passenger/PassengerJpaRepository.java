package com.sriman.ticketbooking.passenger;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerJpaRepository extends JpaRepository<Passenger, Integer> {
}
