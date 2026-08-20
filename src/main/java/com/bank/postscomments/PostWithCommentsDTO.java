package com.bank.postscomments;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostWithCommentsDTO {
    private Long id;
    private String content;
    private String author;
    private List<CommentDTO> comments;
}
