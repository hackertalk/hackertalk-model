package net.hackertalk.model.talk;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@IdClass(TalkLikeId.class)
@Table(schema = "application", name = "talk_like")
public class TalkLike {

    @Id
    @Column(name = "talk_id", nullable = false)
    @JsonSerialize(using = ToStringSerializer.class)
    @JsonDeserialize(as = Long.class)
    private Long talkId;

    @Id
    @Column(name = "from_id", nullable = false, updatable = false)
    @JsonSerialize(using = ToStringSerializer.class)
    @JsonDeserialize(as = Long.class)
    private Long fromId;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Long createdAt;
}
