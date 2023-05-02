package net.hackertalk.model.event;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.hackertalk.model.post.Post;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class PostDeletedEvent extends NotificationEvent {

    private Post post;
}
