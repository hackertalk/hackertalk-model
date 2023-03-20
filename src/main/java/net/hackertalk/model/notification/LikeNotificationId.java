package net.hackertalk.model.notification;

import lombok.*;
import net.hackertalk.data.TargetType;

import java.io.Serializable;

@Setter
@Getter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class LikeNotificationId implements Serializable {
    private Long fromId;
    private Long targetId;
    private TargetType targetType;
    private Action action;
}
