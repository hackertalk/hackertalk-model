package net.hackertalk.model.client;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@IdClass(UserFollowingId.class)
@Table(schema = "application", name = "user_following")
public class UserFollowing {

    @Column(name = "id", nullable = false, updatable = false, unique = true)
    private Long id;

    @Id
    @Column(name = "user_id", nullable = false, updatable = false)
    private Long userId;

    @Id
    @Column(name = "following_id", nullable = false, updatable = false)
    private Long followingId;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Long createdAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserFollowing that = (UserFollowing) o;
        return userId != null && Objects.equals(userId, that.userId)
                && followingId != null && Objects.equals(followingId, that.followingId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, followingId);
    }
}
