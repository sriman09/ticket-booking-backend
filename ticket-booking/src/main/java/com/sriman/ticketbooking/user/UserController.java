package com.sriman.ticketbooking.user;

import com.sriman.ticketbooking.passenger.Passenger;
import com.sriman.ticketbooking.passenger.PassengerJpaRepository;
import com.sriman.ticketbooking.ticket.Ticket;
import com.sriman.ticketbooking.ticket.TicketJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    private UserJpaRepository repository;

    @Autowired
    private TicketJpaRepository ticketJpaRepository;

    @Autowired
    private PassengerJpaRepository passengerJpaRepository;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return repository.findAll();
    }

    //Get User by Id
    @GetMapping("/users/{id}")
    public Optional<User> retrieveUser(@PathVariable int id){
        Optional<User> user = repository.findById(id);
        return user;
    }

    //Register User
    @PostMapping("/register")
    public ResponseEntity<Object> userRegistration(@RequestBody User user){
        User savedUser = repository.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    //Delete User
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        repository.deleteById(id);
    }

    //Get all tickets
    @GetMapping("users/{id}/ticket")
    public List<Ticket> getAllTickets(@PathVariable int id){
        User user =repository.getById(id);
        return user.getTicket();
    }

    //Add new tickets
    @PostMapping("users/{id}/ticket")
    public ResponseEntity<Object> addTickets(@PathVariable int id,@RequestBody Ticket ticket){
        Optional<User> optionalUser = repository.findById(id);
        User user = optionalUser.get();
        ticket.setUser(user);
        ticketJpaRepository.save(ticket);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(ticket.getId()).toUri();
        return ResponseEntity.created(location).build();

    }

    //Add new Passenger to the ticket
    @PostMapping("users/{id}/ticket/{t_id}/passenger")
    public ResponseEntity<Object> addPassenger(@PathVariable int t_id,@RequestBody Passenger passenger){
        Optional<Ticket> optionalTicket = ticketJpaRepository.findById(t_id);
        Ticket ticket = optionalTicket.get();
        passenger.setTicket(ticket);
        passengerJpaRepository.save(passenger);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(passenger.getId()).toUri();
        return ResponseEntity.created(location).build();

    }

    //Get passenger from ticket
    @GetMapping("users/{id}/ticket/{t_id}/passenger")
    public List<Passenger> getPassenger(@PathVariable int t_id){
        Ticket ticket = ticketJpaRepository.getById(t_id);
        return ticket.getPassenger();
    }

}
