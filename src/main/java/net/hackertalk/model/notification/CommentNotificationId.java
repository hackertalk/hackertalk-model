package net.hackertalk.model.notification;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class CommentNotificationId implements Serializable {
    private Long fromId;
    private Long toId;
    private Long messageId;
    private MessageType messageType;
}
