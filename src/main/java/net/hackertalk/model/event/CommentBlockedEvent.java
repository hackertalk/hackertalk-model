package net.hackertalk.model.event;

import lombok.*;
import net.hackertalk.model.comment.Comment;
import net.hackertalk.model.notification.BlockedReason;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CommentBlockedEvent extends NotificationEvent {

    private Comment comment;
    private BlockedReason reason;
}
