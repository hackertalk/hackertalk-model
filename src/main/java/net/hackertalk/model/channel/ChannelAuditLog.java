package net.hackertalk.model.channel;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "application", name = "channel_audit_log")
public class ChannelAuditLog {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @JsonDeserialize(as = Long.class)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    @JsonDeserialize(as = Long.class)
    @JsonSerialize(using = ToStringSerializer.class)
    @Column(name = "channel_id", nullable = false)
    private Long channelId;

    @JsonDeserialize(as = Long.class)
    @JsonSerialize(using = ToStringSerializer.class)
    @Column(name = "from_id", nullable = false)
    private Long fromId;

    @JsonDeserialize(as = Long.class)
    @JsonSerialize(using = ToStringSerializer.class)
    @Column(name = "target_id", nullable = false)
    private Long targetId;

    @Enumerated(EnumType.STRING)
    @Column(name = "action_type", nullable = false)
    private ActionType actionType;

    @Column(name = "reason", nullable = false, length = 512)
    private String reason;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Long createdAt;

    public enum ActionType {
        CHANNEL_CREATE,
        CHANNEL_UPDATE,
        CHANNEL_DELETE,
        MEMBER_MUTE,
        MEMBER_UNMUTE,
        MEMBER_BAN_CREATE,
        MEMBER_BAN_DELETE,
    }
}
