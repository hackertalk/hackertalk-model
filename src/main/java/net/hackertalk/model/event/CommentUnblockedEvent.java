package net.hackertalk.model.event;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.hackertalk.data.comment.Comment;
import net.hackertalk.data.notification.BlockedReason;

public class CommentUnblockedEvent extends NotificationEvent<Comment> {

    private BlockedReason reason;

    @JsonCreator
    public CommentUnblockedEvent(@JsonProperty("source") Comment source,
                                 @JsonProperty("reason") BlockedReason reason) {
        super(source, "COMMENT_UNBLOCKED");
    }

    public BlockedReason getReason() {
        return reason;
    }

    public void setReason(BlockedReason reason) {
        this.reason = reason;
    }
}
