package net.hackertalk.model.channel;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@IdClass(ChannelBanId.class)
@Table(schema = "application", name = "channel_ban")
public class ChannelBan {

    @Column(name = "id", nullable = false, unique = true, updatable = false)
    @JsonDeserialize(as = Long.class)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    @Id
    @Column(name = "channel_id", nullable = false, updatable = false)
    @JsonDeserialize(as = Long.class)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long channelId;

    @Id
    @Column(name = "user_id", nullable = false, updatable = false)
    @JsonDeserialize(as = Long.class)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Long createdAt;
}
