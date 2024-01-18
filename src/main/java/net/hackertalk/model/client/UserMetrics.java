package net.hackertalk.model.client;

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
@Table(schema = "application", name = "user_metrics")
public class UserMetrics {

    @Id
    @Column(name = "user_id", unique = true, nullable = false, updatable = false, insertable = false)
    @JsonDeserialize(as = Long.class)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;

    @Column(name = "post_count", nullable = false, updatable = false, insertable = false)
    private Long postCount;

    @Column(name = "followers_count", nullable = false, updatable = false, insertable = false)
    private Long followersCount;

    @Column(name = "following_count", nullable = false, updatable = false, insertable = false)
    private Long followingCount;
}
