package net.hackertalk.model.event;

import lombok.*;
import net.hackertalk.model.comment.Comment;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CommentCreatedEvent extends NotificationEvent {

    private Comment comment;
}
