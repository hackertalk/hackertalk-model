package net.hackertalk.model.event;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.hackertalk.data.comment.Comment;

public class CommentDislikedEvent extends NotificationEvent<Comment> {

    private Long fromId;

    @JsonCreator
    public CommentDislikedEvent(@JsonProperty("source") Comment source,
                                @JsonProperty("fromId") Long fromId) {
        super(source, "COMMENT_DISLIKED");
        this.fromId = fromId;
    }

    public Long getFromId() {
        return fromId;
    }

    public void setFromId(Long fromId) {
        this.fromId = fromId;
    }
}
