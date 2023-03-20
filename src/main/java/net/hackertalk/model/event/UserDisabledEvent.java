package net.hackertalk.model.event;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.hackertalk.data.client.User;

public class UserDisabledEvent extends NotificationEvent<User>{

    @JsonCreator
    public UserDisabledEvent(@JsonProperty("source") User source) {
        super(source, "USER_DISABLED");
    }
}
