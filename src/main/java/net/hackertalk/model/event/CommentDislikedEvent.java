package net.hackertalk.model.event;

import lombok.*;
import net.hackertalk.model.comment.Comment;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CommentDislikedEvent extends NotificationEvent {

    private Long fromId;

    private Comment comment;
}
