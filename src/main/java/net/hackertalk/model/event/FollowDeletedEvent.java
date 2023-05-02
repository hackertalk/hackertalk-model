package net.hackertalk.model.event;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class FollowDeletedEvent extends NotificationEvent {

    private Long fromId;

    private Long toId;
}
