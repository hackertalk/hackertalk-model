package net.hackertalk.model.event;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.hackertalk.data.comment.Comment;

public class CommentCreatedEvent extends NotificationEvent<Comment> {

    @JsonCreator
    public CommentCreatedEvent(@JsonProperty("source") Comment source) {
        super(source, "COMMENT_CREATED");
    }
}
