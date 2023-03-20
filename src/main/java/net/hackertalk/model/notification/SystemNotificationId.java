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
public class SystemNotificationId implements Serializable {
    private Long fromId;
    private Long messageId;
    private MessageType messageType;
}
