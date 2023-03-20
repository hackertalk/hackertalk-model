package net.hackertalk.model.event;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FollowCreatedEvent extends NotificationEvent<Long> {

    private Long fromId;

    @JsonCreator
    public FollowCreatedEvent(@JsonProperty("source") Long source,
                              @JsonProperty("fromId") Long fromId) {
        super(source, "FOLLOW_CREATED");
        this.fromId = fromId;
    }

    public Long getFromId() {
        return fromId;
    }

    public void setFromId(Long fromId) {
        this.fromId = fromId;
    }
}
