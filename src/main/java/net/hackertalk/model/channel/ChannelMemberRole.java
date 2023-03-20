package net.hackertalk.model.channel;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@IdClass(ChannelMemberRoleId.class)
@Table(schema = "application", name = "channel_member_role")
public class ChannelMemberRole implements Serializable {

    @Id
    @Column(name = "channel_id", nullable = false, updatable = false)
    private Long channelId;

    @Id
    @Column(name = "user_id", nullable = false, updatable = false)
    private Long userId;

    @Id
    @Column(name = "role_id", nullable = false, updatable = false)
    private Long roleId;

    @Column(name = "created_at", nullable = false)
    private Long createdAt;
}
