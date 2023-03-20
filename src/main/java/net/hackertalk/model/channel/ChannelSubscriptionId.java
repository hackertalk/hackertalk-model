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
public class ChannelSubscriptionId implements Serializable {
    private Long channelId;
    private String sessionId;
}
