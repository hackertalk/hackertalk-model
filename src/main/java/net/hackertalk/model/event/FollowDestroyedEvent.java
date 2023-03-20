package net.hackertalk.model.event;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FollowDestroyedEvent extends NotificationEvent<Long> {

    private Long fromId;

    @JsonCreator
    public FollowDestroyedEvent(@JsonProperty("source") Long source,
                                @JsonProperty("formId") Long formId) {
        super(source, "FOLLOW_DESTROYED");
        this.fromId = formId;
    }

    public Long getFromId() {
        return this.fromId;
    }

    public void setFromId(Long fromId) {
        this.fromId = fromId;
    }
}
