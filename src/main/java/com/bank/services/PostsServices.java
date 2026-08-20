package com.bank.services;


import com.bank.dao.PostsJpa;
import com.bank.model.Posts;
import com.bank.postscomments.CommentDTO;
import com.bank.postscomments.PostWithCommentsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


//import org.springframework.kafka.annotation.KafkaListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PostsServices
{

    @Autowired
    PostsJpa postsJpa;

    @Autowired
    RestTemplate   restTemplate; // autowired via @RequiredArgsConstructor

    public Posts  savePosts(Posts post)
    {
        return postsJpa.save(post);
    }

    public List<Posts> getAllPosts()
    {
        return postsJpa.findAll();
    }

    public void deletePosts(Long id )
    {
        postsJpa.deleteById((id));
    }

  /*@KafkaListener(topics = "order", groupId = "order-group")
    public void consume(com.bank.model.Order order) {
        System.out.println("Received from MSK: " + order.getAnme());
    }
*/
    public List<com.bank.postscomments.PostWithCommentsDTO> getPostsWithComments() {
        List<Posts> posts = postsJpa.findAll();
        return posts.stream().map(post -> {

            // Fetch comments from Comments service
            /*CommentDTO[] commentsArray = restTemplate.getForObject(
                    "http://localhost:8080/comments/post/" + post.getId(),
                    CommentDTO[].class
            );*/

            CommentDTO[] commentsArray = restTemplate.getForObject(
                    "http://comments-service.comments.svc.cluster.local:80/comments/post/" + post.getId(),
                    CommentDTO[].class
            );

            List<CommentDTO> comments = commentsArray != null ?
                    Arrays.asList(commentsArray) : new ArrayList<>();

            // Build DTO
            return PostWithCommentsDTO.builder()
                    ///  .id(post.getId())
                    .content(post.getBody() )
                    .author(post.getAuthor())
                    .comments(comments)
                    .build();

        }).toList();
    }


} /// curl http://localhost:8082/posts/getAll

