package net.hackertalk.model.event;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.hackertalk.model.notification.BlockedReason;
import net.hackertalk.model.post.Post;

public class PostUnblockedEvent extends NotificationEvent<Post> {

    private BlockedReason reason;

    @JsonCreator
    public PostUnblockedEvent(@JsonProperty("source") Post source,
                              @JsonProperty("reason") BlockedReason reason) {
        super(source, "POST_UNBLOCKED");
        this.reason = reason;
    }

    public BlockedReason getReason() {
        return reason;
    }

    public void setReason(BlockedReason reason) {
        this.reason = reason;
    }
}
