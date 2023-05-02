package net.hackertalk.model.event;

import lombok.*;
import net.hackertalk.model.client.User;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserEnabledEvent extends NotificationEvent {

    private User user;
}
