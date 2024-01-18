package net.hackertalk.model.comment;

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
@Table(schema = "application", name = "comment_metrics")
public class CommentMetrics {

    @Id
    @Column(name = "comment_id", nullable = false, insertable = false, updatable = false)
    @JsonDeserialize(as = Long.class)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long commentId;

    @Builder.Default
    @Column(name = "like_count", nullable = false, insertable = false, updatable = false)
    private Long likeCount = 0L;

    @Builder.Default
    @Column(name = "reply_count", nullable = false, insertable = false, updatable = false)
    private Long replyCount = 0L;
}
