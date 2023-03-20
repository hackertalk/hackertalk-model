package net.hackertalk.model.comment;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;
import net.hackertalk.data.client.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "application", name = "comment")
public class Comment implements Serializable {

    @Id
    @Column(nullable = false, unique = true, updatable = false)
    @JsonSerialize(using = ToStringSerializer.class)
    @JsonDeserialize(as = Long.class)
    private Long id;

    @Column(name = "post_id", nullable = false, updatable = false)
    @JsonSerialize(using = ToStringSerializer.class)
    @JsonDeserialize(as = Long.class)
    private Long postId;

    @Column(name = "from_id", nullable = false, updatable = false)
    @JsonSerialize(using = ToStringSerializer.class)
    @JsonDeserialize(as = Long.class)
    private Long fromId;

    @Column(name = "parent_id", nullable = false, updatable = false)
    @JsonSerialize(using = ToStringSerializer.class)
    @JsonDeserialize(as = Long.class)
    private Long parentId;

    @Column(nullable = false, length = 6)
    private String lang;

    @Column(nullable = false, length = 2048)
    private String content;

    @Column(nullable = false)
    private Boolean blocked = false;

    @Column(nullable = false)
    private Boolean deleted = false;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Long createdAt;

    @Column(name = "updated_at", nullable = false)
    private Long updatedAt;

    @ManyToOne
    @JoinColumn(name = "from_id", referencedColumnName = "id", updatable = false, insertable = false)
    private User from;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "comment_id", insertable = false, updatable = false)
    private CommentMetrics metrics;

    @Transient
    @JsonProperty
    @Builder.Default
    private Boolean liked = false;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return id != null && Objects.equals(id, comment.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
