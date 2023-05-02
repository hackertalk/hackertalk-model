package net.hackertalk.model.event;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.hackertalk.model.comment.Comment;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class CommentLikedEvent extends NotificationEvent {

    private Long fromId;

    private Comment comment;
}
