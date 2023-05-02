package net.hackertalk.model.event;

import lombok.*;
import net.hackertalk.model.post.Post;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PostDislikedEvent extends NotificationEvent {

    private Long fromId;

    private Post post;
}
