package net.hackertalk.model.talk;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class TalkLikeId implements Serializable {
    private Long talkId;
    private Long fromId;
}
