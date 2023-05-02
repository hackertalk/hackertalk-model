package net.hackertalk.model.event;

import lombok.*;
import net.hackertalk.model.comment.Comment;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CommentLikedEvent extends NotificationEvent {

    private Long fromId;

    private Comment comment;
}
