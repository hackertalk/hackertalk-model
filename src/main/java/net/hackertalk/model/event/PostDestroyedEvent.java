package net.hackertalk.model.event;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.hackertalk.model.post.Post;

public class PostDestroyedEvent extends NotificationEvent<Post> {

    @JsonCreator
    public PostDestroyedEvent(@JsonProperty("source") Post source) {
        super(source, "POST_DESTROYED");
    }
}
