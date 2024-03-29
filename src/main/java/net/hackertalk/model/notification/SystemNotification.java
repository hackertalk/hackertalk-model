package net.hackertalk.model.notification;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import jakarta.persistence.*;
import lombok.*;
import net.hackertalk.model.TargetType;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@IdClass(SystemNotificationId.class)
@Table(schema = "application", name = "system_notification")
public class SystemNotification {

    @Column(name = "id", nullable = false, unique = true)
    @JsonDeserialize(as = Long.class)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    @Id
    @JsonIgnore
    @Column(name = "from_id", nullable = false, updatable = false)
    @JsonDeserialize(as = Long.class)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long fromId;

    @Column(name = "to_id", nullable = false, updatable = false)
    @JsonDeserialize(as = Long.class)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long toId;

    @Column(name = "target_id", nullable = false, updatable = false)
    @JsonDeserialize(as = Long.class)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long targetId;

    @Column(name = "target_type", nullable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    private TargetType targetType;

    @Id
    @Column(name = "message_id", nullable = false, updatable = false)
    @JsonDeserialize(as = Long.class)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long messageId;

    @Id
    @Column(name = "message_type", nullable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    private MessageType messageType;

    @Column(name = "unread", nullable = false)
    private Boolean unread;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Long createdAt;
}
