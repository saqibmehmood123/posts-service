package com.bank.postscomments;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentDTO {
    private Long id;
    private Long postId;
    private String content;
    private String author;
}
