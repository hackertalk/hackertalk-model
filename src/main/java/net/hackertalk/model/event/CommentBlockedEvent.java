package net.hackertalk.model.event;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.hackertalk.data.comment.Comment;
import net.hackertalk.data.notification.BlockedReason;

public class CommentBlockedEvent extends NotificationEvent<Comment> {

    private BlockedReason reason;

    @JsonCreator
    public CommentBlockedEvent(@JsonProperty("source") Comment source,
                               @JsonProperty("reason") BlockedReason reason) {
        super(source, "COMMENT_BLOCKED");
        this.reason = reason;
    }

    public BlockedReason getReason() {
        return reason;
    }

    public void setReason(BlockedReason reason) {
        this.reason = reason;
    }
}
