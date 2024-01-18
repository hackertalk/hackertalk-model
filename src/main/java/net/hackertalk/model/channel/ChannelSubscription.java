package net.hackertalk.model.channel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@IdClass(ChannelSubscriptionId.class)
@Table(schema = "application", name = "channel_subscription")
public class ChannelSubscription {

    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Id
    @JsonDeserialize(as = Long.class)
    @JsonSerialize(using = ToStringSerializer.class)
    @Column(name = "channel_id", nullable = false, updatable = false)
    private Long channelId;

    @Id
    @JsonIgnore
    @Column(name = "session_id", nullable = false, updatable = false)
    private String sessionId;

    @JsonDeserialize(as = Long.class)
    @JsonSerialize(using = ToStringSerializer.class)
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "created_at", nullable = false)
    private Long createdAt;
}
