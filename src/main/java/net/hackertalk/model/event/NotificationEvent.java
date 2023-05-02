package net.hackertalk.model.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;
import java.time.Clock;
import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @Type(value = CommentBlockedEvent.class, name = "COMMENT_BLOCKED"),
        @Type(value = CommentCreatedEvent.class, name = "COMMENT_CREATED"),
        @Type(value = CommentDeletedEvent.class, name = "COMMENT_DELETED"),
        @Type(value = CommentDislikedEvent.class, name = "COMMENT_DISLIKED"),
        @Type(value = CommentLikedEvent.class, name = "COMMENT_LIKED"),
        @Type(value = CommentUnblockedEvent.class, name = "COMMENT_UNBLOCKED"),
        @Type(value = FollowCreatedEvent.class, name = "FOLLOW_CREATED"),
        @Type(value = FollowDeletedEvent.class, name = "FOLLOW_DELETED"),
        @Type(value = PostBlockedEvent.class, name = "POST_BLOCKED"),
        @Type(value = PostCreatedEvent.class, name = "POST_CREATED"),
        @Type(value = PostDeletedEvent.class, name = "POST_DELETED"),
        @Type(value = PostDislikedEvent.class, name = "POST_DISLIKED"),
        @Type(value = PostFavoriteCreatedEvent.class, name = "POST_FAVORITE_CREATED"),
        @Type(value = PostFavoriteDeletedEvent.class, name = "POST_FAVORITE_DELETED"),
        @Type(value = PostLikedEvent.class, name = "POST_LIKED"),
        @Type(value = PostUnblockedEvent.class, name = "POST_UNBLOCKED"),
        @Type(value = UserCreatedEvent.class, name = "USER_CREATED"),
        @Type(value = UserDisabledEvent.class, name = "USER_DISABLED"),
        @Type(value = UserEnabledEvent.class, name = "USER_ENABLED"),
        @Type(value = UserLockedEvent.class, name = "USER_LOCKED"),
})
public abstract class NotificationEvent implements Serializable {

    private final String eventId;
    private final long timestamp;

    public NotificationEvent() {
        this.eventId = UUID.randomUUID().toString();
        this.timestamp = System.currentTimeMillis();
    }

    public NotificationEvent(Clock clock) {
        this.eventId = UUID.randomUUID().toString();
        this.timestamp = clock.millis();
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final String getEventId() {
        return this.eventId;
    }
}
