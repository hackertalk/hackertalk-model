package net.hackertalk.model.event;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.hackertalk.model.client.User;

public class UserEnabledEvent extends NotificationEvent<User>{

    @JsonCreator
    public UserEnabledEvent(@JsonProperty("source") User source) {
        super(source, "USER_ENABLED");
    }
}
