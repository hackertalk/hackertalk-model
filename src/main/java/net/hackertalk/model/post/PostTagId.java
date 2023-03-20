package net.hackertalk.model.post;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class PostTagId implements Serializable {

    private Long postId;

    private Long tagId;
}
