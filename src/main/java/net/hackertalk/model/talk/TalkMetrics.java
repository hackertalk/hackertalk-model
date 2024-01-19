package net.hackertalk.model.talk;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "application", name = "talk_metrics")
public class TalkMetrics {

    @Id
    @Column(name = "talk_id", nullable = false, updatable = false, insertable = false)
    @JsonSerialize(using = ToStringSerializer.class)
    @JsonDeserialize(as = Long.class)
    private Long talkId;

    @Builder.Default
    @Column(name = "like_count", nullable = false, updatable = false, insertable = false)
    private Long likeCount = 0L;

    @Builder.Default
    @Column(name = "reply_count", nullable = false, updatable = false, insertable = false)
    private Long replyCount = 0L;

    @Builder.Default
    @Column(name = "quote_count", nullable = false, updatable = false, insertable = false)
    private Long quoteCount = 0L;

    @Builder.Default
    @Column(name = "impression_count", nullable = false, updatable = false, insertable = false)
    private Long impressionCount = 0L;
}
