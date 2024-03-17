package com.example.springwithsql.Controller;

import com.example.springwithsql.Entity.Message;
import com.example.springwithsql.Repository.MyMessageRepository;
import com.example.springwithsql.Repository.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MyController {
    @Autowired
    private MyUserRepository myUserRepository;
    @Autowired
    private MyMessageRepository myMessageRepository;
    @GetMapping("/List")
    public String add(Model model){
        List<Message> messages = myMessageRepository.findAll();
        Message message = new Message();

        for (Message m : messages){
            System.out.println(m.content);
        }

        model.addAttribute("header","All MSG List");
        model.addAttribute("msgList", messages);
        model.addAttribute("message", message);
        return "list";
    }
    @PostMapping("/submit")
    public String submitForm(Message message) {
        System.out.println(message.toString());
        myMessageRepository.save(new Message(message.getContent()));
        return "redirect:/List";
    }


}
