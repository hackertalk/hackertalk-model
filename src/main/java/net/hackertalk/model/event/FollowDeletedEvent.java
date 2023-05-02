package net.hackertalk.model.event;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class FollowDeletedEvent extends NotificationEvent {

    private Long fromId;

    private Long toId;
}
