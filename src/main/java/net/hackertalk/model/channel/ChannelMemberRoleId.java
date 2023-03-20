package net.hackertalk.model.channel;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ChannelMemberRoleId implements Serializable {
    private Long channelId;
    private Long userId;
    private Long roleId;
}
