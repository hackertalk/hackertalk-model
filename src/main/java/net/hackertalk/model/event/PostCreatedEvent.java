package net.hackertalk.model.event;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.hackertalk.data.post.Post;

public class PostCreatedEvent extends NotificationEvent<Post> {

    @JsonCreator
    public PostCreatedEvent(@JsonProperty("source") Post source) {
        super(source, "POST_CREATED");
    }
}
