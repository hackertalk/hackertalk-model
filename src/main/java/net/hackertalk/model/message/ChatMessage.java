package net.hackertalk.model.message;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;
import net.hackertalk.model.client.User;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "application", name = "chat_message")
public class ChatMessage {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @JsonSerialize(using = ToStringSerializer.class)
    @JsonDeserialize(as = Long.class)
    private Long id;

    @Column(name = "sender_id", nullable = false, updatable = false)
    @JsonSerialize(using = ToStringSerializer.class)
    @JsonDeserialize(as = Long.class)
    private Long senderId; // 发送人ID，一般是用户ID

    @Column(name = "recipient_id", nullable = false, updatable = false)
    @JsonSerialize(using = ToStringSerializer.class)
    @JsonDeserialize(as = Long.class)
    private Long recipientId; // 收信人ID，可以是用户ID、群组ID、其他系统账号ID

    @Column(name = "recipient_type", nullable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    private RecipientType recipientType; // 收信人类型

    @Column(nullable = false, length = 2048)
    private String content;

    @Column(name = "content_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private ContentType contentType;

    @Column(name = "created_at", nullable = false)
    private Long createdAt;

    @ManyToOne
    @JoinColumn(name = "sender_Id", nullable = false, referencedColumnName = "id", updatable = false, insertable = false)
    private User sender;
}
