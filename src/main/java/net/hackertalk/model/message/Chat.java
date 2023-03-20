package net.hackertalk.model.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;
import org.tonggan.common.http.Paging;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@IdClass(ChatId.class)
@Table(schema = "application", name = "chat")
public class Chat {

    @Column(name = "id", nullable = false, unique = true, updatable = false)
    @JsonSerialize(using = ToStringSerializer.class)
    @JsonDeserialize(as = Long.class)
    private Long id;

    @Id
    @Column(name = "sender_id", nullable = false, updatable = false)
    @JsonSerialize(using = ToStringSerializer.class)
    @JsonDeserialize(as = Long.class)
    private Long senderId;

    @Id
    @Column(name = "recipient_id", nullable = false, updatable = false)
    @JsonSerialize(using = ToStringSerializer.class)
    @JsonDeserialize(as = Long.class)
    private Long recipientId;

    @Id
    @Enumerated(EnumType.STRING)
    @Column(name = "recipient_type", nullable = false, updatable = false)
    private RecipientType recipientType;

    @Column(name = "deleted", nullable = false)
    private Boolean deleted;

    @Column(name = "last_seen_message_id", nullable = false)
    @JsonSerialize(using = ToStringSerializer.class)
    @JsonDeserialize(as = Long.class)
    private Long lastSeenMessageId;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Long createdAt;

    @Column(name = "updated_at", nullable = false)
    private Long updatedAt;

    @Transient
    @JsonProperty
    private ChatMessage lastMessage;

    @Transient
    @JsonProperty
    private Paging paging;

    @Transient
    @JsonProperty
    @Builder.Default
    private Collection<ChatMessage> messages = new ArrayList<>();

    @Transient
    @JsonProperty
    private Long unreadCount;

    @Transient
    @JsonProperty
    private String name;

    @Transient
    @JsonProperty
    private String avatar;
}
