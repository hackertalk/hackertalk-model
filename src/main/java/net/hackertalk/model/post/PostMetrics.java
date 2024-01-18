package net.hackertalk.model.post;

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
@Table(schema = "application", name = "post_metrics")
public class PostMetrics {

    @Id
    @Column(name = "post_id", nullable = false, updatable = false, insertable = false)
    @JsonSerialize(using = ToStringSerializer.class)
    @JsonDeserialize(as = Long.class)
    private Long postId;

    @Builder.Default
    @Column(name = "like_count", nullable = false, updatable = false, insertable = false)
    private Long likeCount = 0L;

    @Builder.Default
    @Column(name = "comment_count", nullable = false, updatable = false, insertable = false)
    private Long commentCount = 0L;

    @Builder.Default
    @Column(name = "favorite_count", nullable = false, updatable = false, insertable = false)
    private Long favoriteCount = 0L;

    @Builder.Default
    @Column(name = "impression_count", nullable = false, updatable = false, insertable = false)
    private Long impressionCount = 0L;
}
