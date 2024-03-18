package com.example.springwithsql.Controller;

import com.example.springwithsql.Auth.Trash.MyUserDetails;
import com.example.springwithsql.Entity.Message;
import com.example.springwithsql.Repository.MyMessageRepository;
import com.example.springwithsql.Auth.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
public class MyAPIController {

   // @Autowired
  //  private MyUserDetailsService userService;
    @Autowired
    private MyUserRepository myUserRepository;
    @Autowired
    private MyMessageRepository myMessageRepository;

    @GetMapping("/api/error")
    public String getError(){
        return "Bajo jajo";
    }

  //  @GetMapping("/api/user")
   // public List<MyUserDetails> getUsers(){
   ///     System.out.println(myUserRepository.findAll().size());
   //     return myUserRepository.findAll();
  //  }

    @PostMapping("/api2/register")
    public String registerUser(@RequestParam String username, @RequestParam String password, @RequestParam String role) {
        createUser(username, password, role);
        return "registration_success"; // Redirect or handle success
    }

/*    @PostMapping("/api/register")
    public boolean postRegister(@RequestBody MyLoginBody myLoginBody){
        if (myUserRepository.findByUsername(myLoginBody.getUsername()).isEmpty()) { // Check if username is taken
            try {
                myUserRepository.save(
                        new User(
                                myLoginBody.getUsername(),
                                User.HashPassword(myLoginBody.getPassword()),
                                true)
                ); // Try insert name

                return true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return false;
    }*/

/*    @PostMapping("/api/login")
    public User postLogin(@RequestBody MyLoginBody myLoginBody) {

        String hashedPassword = User.HashPassword(myLoginBody.getPassword());

        List<User> users = myUserRepository.findByUsernameAndPassword(myLoginBody.getUsername(), hashedPassword);

        if(users.isEmpty())
            return null;



        return users.getFirst();
    }*/

    public void createUser(String username, String password, String role) {
        MyUserDetails user = new MyUserDetails(username, password, true); // Enabled by default
        //user.setRoles(Collections.singletonList(new UserRole(role))); // Set the user role
       // myUserRepository.save(user);
    }

    @GetMapping("/api/messages")
    public List<Message> getMessages(){
        return myMessageRepository.findAll();
    }

    @PostMapping("/api/message")
    public boolean postLogin(@RequestBody Message message) {
        try {
            myMessageRepository.save(new Message(message.getContent()));
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
