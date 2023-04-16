package net.hackertalk.model.post;

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
@Table(schema = "application", name = "post_commenter")
public class PostCommenter {

    @Id
    @Column(name = "post_id", nullable = false, updatable = false)
    @JsonSerialize(using = ToStringSerializer.class)
    @JsonDeserialize(as = Long.class)
    private Long postId;

    @Column(name = "from_id", nullable = false, updatable = false)
    @JsonSerialize(using = ToStringSerializer.class)
    @JsonDeserialize(as = Long.class)
    private Long fromId;

    @Column(name = "first_comment_id", nullable = false, updatable = false)
    @JsonSerialize(using = ToStringSerializer.class)
    @JsonDeserialize(as = Long.class)
    private Long firstCommentId;

    @Column(name = "last_comment_id", nullable = false, updatable = false)
    @JsonSerialize(using = ToStringSerializer.class)
    @JsonDeserialize(as = Long.class)
    private Long lastCommentId;
}
