package net.hackertalk.model.event;

import lombok.*;
import net.hackertalk.model.notification.BlockedReason;
import net.hackertalk.model.post.Post;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PostBlockedEvent extends NotificationEvent {

    private BlockedReason reason;

    private Post post;
}
