package net.hackertalk.model.event;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.hackertalk.model.notification.BlockedReason;
import net.hackertalk.model.post.Post;

public class PostBlockedEvent extends NotificationEvent<Post> {

    private BlockedReason reason;

    @JsonCreator
    public PostBlockedEvent(@JsonProperty("source") Post source,
                            @JsonProperty("reason") BlockedReason reason) {
        super(source, "POST_BLOCKED");
        this.reason = reason;
    }

    public BlockedReason getReason() {
        return reason;
    }

    public void setReason(BlockedReason reason) {
        this.reason = reason;
    }
}
