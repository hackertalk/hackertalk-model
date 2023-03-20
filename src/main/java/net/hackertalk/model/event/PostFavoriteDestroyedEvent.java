package net.hackertalk.model.event;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.hackertalk.model.post.Post;

public class PostFavoriteDestroyedEvent extends NotificationEvent<Post> {

    private Long fromId;

    @JsonCreator
    public PostFavoriteDestroyedEvent(@JsonProperty("source") Post source,
                                      @JsonProperty("fromId") Long fromId) {
        super(source, "POST_FAVORITED_DESTROYED");
        this.fromId = fromId;
    }

    public Long getFromId() {
        return fromId;
    }

    public void setFromId(Long fromId) {
        this.fromId = fromId;
    }
}
