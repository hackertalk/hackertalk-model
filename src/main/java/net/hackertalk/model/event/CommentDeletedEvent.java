package net.hackertalk.model.event;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.hackertalk.model.comment.Comment;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class CommentDeletedEvent extends NotificationEvent {

    private Comment comment;
}
