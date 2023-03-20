package net.hackertalk.model.topic;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@IdClass(TopicTagId.class)
@Table(schema = "application", name = "topic_tag")
public class TopicTag {

    @Id
    @Column(name = "topic_id", nullable = false)
    @JsonDeserialize(as = Long.class)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long topicId;

    @Id
    @Column(name = "tag_id", nullable = false)
    @JsonDeserialize(as = Long.class)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long tagId;
}
