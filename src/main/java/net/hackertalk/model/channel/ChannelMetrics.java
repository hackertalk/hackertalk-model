package net.hackertalk.model.channel;

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
@Table(schema = "application", name = "channel_metrics")
public class ChannelMetrics {

    @Id
    @Column(name = "channel_id", nullable = false, unique = true, insertable = false, updatable = false)
    @JsonDeserialize(as = Long.class)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long channelId;

    @Builder.Default
    @Column(name = "member_count", nullable = false, insertable = false, updatable = false)
    private Long memberCount = 0L;

    @Builder.Default
    @Column(name = "online_count", nullable = false, insertable = false, updatable = false)
    private Long onlineCount = 0L;
}
