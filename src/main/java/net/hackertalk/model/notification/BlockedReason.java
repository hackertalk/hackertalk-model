package net.hackertalk.model.notification;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;
import net.hackertalk.data.TargetType;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "application", name = "blocked_reason")
public class BlockedReason {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @JsonDeserialize(as = Long.class)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    @Column(name = "from_id", nullable = false, updatable = false)
    @JsonDeserialize(as = Long.class)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long fromId;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private BlockedType type;

    @Column(name = "target_id", nullable = false, updatable = false)
    @JsonDeserialize(as = Long.class)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long targetId;

    @Column(name = "target_type", nullable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    private TargetType targetType;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Long createdAt;

    public enum BlockedType {
        SPAM,               // 垃圾信息，灌水、批量盖楼
        EXPLICIT,           // 色情或暴露内容
        HATE_SPEECH,        // 仇恨言论，暴力内容，辱骂等
        NOT_SUITABLE,       // 不合适地讨论，比如政治敏感内容
        COMMERCIAL_CONTENT, // 不受欢迎的商业内容，广告，招聘、推广
    }
}
