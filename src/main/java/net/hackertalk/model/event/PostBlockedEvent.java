package net.hackertalk.model.event;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.hackertalk.model.notification.BlockedReason;
import net.hackertalk.model.post.Post;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class PostBlockedEvent extends NotificationEvent {

    private BlockedReason reason;

    private Post post;
}
