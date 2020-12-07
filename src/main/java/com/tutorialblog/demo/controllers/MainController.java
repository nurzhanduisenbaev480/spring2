package com.tutorialblog.demo.controllers;


import com.tutorialblog.demo.domain.Message;
import com.tutorialblog.demo.domain.User;
import com.tutorialblog.demo.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {
    private final MessageRepository messageRepository;

    public MainController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @GetMapping("/home")
    public String home(@RequestParam(required = false) String filter, Model model){
        Iterable<Message> messages = messageRepository.findAll();
        if (filter != null && !filter.isEmpty()){
            messages = messageRepository.findByTag(filter);
            model.addAttribute("filter", filter);
        }else{
            messages = messageRepository.findAll();
        }
        model.addAttribute("messages", messages);

        model.addAttribute("title", "Home Page");
        return "home";
    }
    @PostMapping("/home")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String text,
            @RequestParam String tag,
            Map<String, Object> model)
    {
        Message message = new Message(text, tag, user);
        messageRepository.save(message);
        Iterable<Message> messages = messageRepository.findAll();
        model.put("messages", messages);
        model.put("title", "Home Page");
        return "home";
    }
//    @PostMapping("filter")
//    public String filter(@RequestParam String filter, Map<String, Object> model){
//        Iterable<Message> messages;
//        if (filter != null && !filter.isEmpty()){
//            messages = messageRepository.findByTag(filter);
//        }else{
//            messages = messageRepository.findAll();
//        }
//        model.put("messages", messages);
//        model.put("title", "Home Page");
//        return "home";
//    }
}
