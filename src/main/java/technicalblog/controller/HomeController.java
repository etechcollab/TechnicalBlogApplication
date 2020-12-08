package technicalblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import technicalblog.model.Post;
import technicalblog.service.PostService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;



@Controller
public class HomeController {
    public HomeController() {
        System.out.println("*** HomeController ***");
    }



    @Autowired
    public PostService postService;

    @RequestMapping("/")
    public String getAllPosts(Model model) {
        ArrayList<Post>posts= null;
        try {
            posts = postService.getAllPosts();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        model.addAttribute("posts", posts);

        return "index";

    }

}