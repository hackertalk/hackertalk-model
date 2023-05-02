package net.hackertalk.model.event;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.hackertalk.model.comment.Comment;
import net.hackertalk.model.notification.BlockedReason;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class CommentUnblockedEvent extends NotificationEvent {

    private BlockedReason reason;

    private Comment comment;
}
