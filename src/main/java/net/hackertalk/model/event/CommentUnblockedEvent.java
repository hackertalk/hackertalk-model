package net.hackertalk.model.event;

import lombok.*;
import net.hackertalk.model.comment.Comment;
import net.hackertalk.model.notification.BlockedReason;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CommentUnblockedEvent extends NotificationEvent {

    private BlockedReason reason;

    private Comment comment;
}
