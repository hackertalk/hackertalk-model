package net.hackertalk.model.event;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.hackertalk.model.client.User;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class UserLockedEvent extends NotificationEvent {

    private User user;
}
