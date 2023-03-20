package net.hackertalk.model.event;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.hackertalk.data.post.Post;

public class PostFavoriteCreatedEvent extends NotificationEvent<Post> {

    private Long fromId;

    @JsonCreator
    public PostFavoriteCreatedEvent(@JsonProperty("source") Post source,
                                    @JsonProperty("fromId") Long fromId) {
        super(source, "POST_FAVORITE_CREATED");
        this.fromId = fromId;
    }

    public Long getFromId() {
        return fromId;
    }

    public void setFromId(Long fromId) {
        this.fromId = fromId;
    }
}
