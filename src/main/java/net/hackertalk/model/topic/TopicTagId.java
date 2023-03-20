package net.hackertalk.model.topic;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class TopicTagId implements Serializable {

    private Long topicId;

    private Long tagId;
}
