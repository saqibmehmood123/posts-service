package com.bank.web;

import com.bank.model.Order;
import com.bank.model.Posts;
import com.bank.postscomments.PostWithCommentsDTO;
import com.bank.services.PostsServices;
import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@CrossOrigin(origins = "*")
public class PostsController {
    @Autowired
    PostsServices postsServices;
 /*    @Autowired
     private KafkaTemplate<String, Order> kafkaTemplate;
*/
    @GetMapping("/getPostComments")
    public List<com.bank.postscomments.PostWithCommentsDTO> getPostsWithComments()
        {

            System.out.println(" before getting data ");
            List<PostWithCommentsDTO>  ALLPOSTS =   postsServices.getPostsWithComments();
            System.out.println(" before getting data " + ALLPOSTS.size());
            return  ALLPOSTS;
        }
/*

     @GetMapping("/kafka")
    public String sendKafkaMessage() {
        Order order = new Order("Hello MSK!");  // message to send
        kafkaTemplate.send("order", order);      // topic = order
        return "Message sent to MSK!";
    }
*/



        @GetMapping("/getAll")
    public List<Posts> getAll() {

        System.out.println(" before getting data ");
        List<Posts>  ALLPOSTS =   postsServices.getAllPosts();
        System.out.println(" before getting data " + ALLPOSTS.size());
        return  ALLPOSTS;
    }


    @PostMapping("/save")
    public Posts saveSingle(@RequestBody Posts posts) {

        System.out.println(" before saving data ");

        return  postsServices.savePosts(posts);
    }

    @DeleteMapping("/delete/{id}")

    public String deleteSingle(@PathVariable("id") Long id) {

        System.out.println(" before saving data ");
        postsServices.deletePosts(id);
        return  "Deleted Succesfully";
    }

    @GetMapping("/test")
    public String test() {
        return "API is reachable";
    }
}
