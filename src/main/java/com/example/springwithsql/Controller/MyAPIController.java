package com.example.springwithsql.Controller;

import com.example.springwithsql.Entity.Message;
import com.example.springwithsql.Repository.MyMessageRepository;
import com.example.springwithsql.Auth.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MyAPIController {
    @Autowired
    private MyUserRepository myUserRepository;
    @Autowired
    private MyMessageRepository myMessageRepository;

    @GetMapping("/api/error")
    public ResponseEntity<String> getError(){
        return new ResponseEntity<>("Hello World!", HttpStatus.BAD_REQUEST);
    } // Error Request
    @GetMapping("/api/messages")
    public ResponseEntity<List<Message>> getAllMessages() {
        return new ResponseEntity<>(myMessageRepository.findAll(), HttpStatus.OK);
    } // Return All Messages
    @GetMapping("/api/message")
    public ResponseEntity<Message> getMessageByID(@RequestParam int id){
        Optional<Message> optionalMessage = myMessageRepository.findById(id); // Find message by id
        Message message = new Message(); // Declare Empty message container
        if (optionalMessage.isPresent()) { // If repository found message by id
            message = optionalMessage.get(); // Assign found message to container
            return new ResponseEntity<>(message, HttpStatus.OK); // Return found message with ok status
        }
        else {
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST); // Return empty container with bad request status
        }
    } // Return Message To User
    @PostMapping("/api/message")
    public HttpStatus postMessage(@RequestBody Message message) {
        try {
            myMessageRepository.save(new Message(message.getContent()));
            return HttpStatus.ACCEPTED;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return HttpStatus.BAD_REQUEST;
        }
    } // Add New Message
}
