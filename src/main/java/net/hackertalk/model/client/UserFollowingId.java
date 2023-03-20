package net.hackertalk.model.client;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class UserFollowingId implements Serializable {
    private Long userId;
    private Long followingId;
}
