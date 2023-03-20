package net.hackertalk.model.event;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.hackertalk.model.comment.Comment;

public class CommentDestroyedEvent extends NotificationEvent<Comment> {

    @JsonCreator
    public CommentDestroyedEvent(@JsonProperty("source") Comment source) {
        super(source, "COMMENT_DESTROYED");
    }
}
