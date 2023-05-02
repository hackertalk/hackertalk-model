package net.hackertalk.model.event;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.hackertalk.model.comment.Comment;
import net.hackertalk.model.notification.BlockedReason;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class CommentBlockedEvent extends NotificationEvent {

    private Comment comment;
    private BlockedReason reason;
}
