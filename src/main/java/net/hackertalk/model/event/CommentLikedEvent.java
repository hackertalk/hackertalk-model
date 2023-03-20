package net.hackertalk.model.event;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.hackertalk.model.comment.Comment;

public class CommentLikedEvent extends NotificationEvent<Comment> {

    private Long fromId;

    @JsonCreator
    public CommentLikedEvent(@JsonProperty("source") Comment source,
                             @JsonProperty("fromId") Long fromId) {
        super(source, "COMMENT_LIKED");
        this.fromId = fromId;
    }

    public Long getFromId() {
        return fromId;
    }

    public void setFromId(Long fromId) {
        this.fromId = fromId;
    }
}
