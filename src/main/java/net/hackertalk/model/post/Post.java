package net.hackertalk.model.post;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;
import net.hackertalk.model.client.User;
import net.hackertalk.model.tag.Tag;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "application", name = "post")
public class Post implements Serializable {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @JsonSerialize(using = ToStringSerializer.class)
    @JsonDeserialize(as = Long.class)
    private Long id;

    @Column(name = "from_id", nullable = false, updatable = false)
    @JsonSerialize(using = ToStringSerializer.class)
    @JsonDeserialize(as = Long.class)
    private Long fromId;

    @Column(name = "lang", nullable = false, length = 6)
    private String lang;

    @Column(name = "title", nullable = false, length = 128)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "ranks", nullable = false)
    @JsonSerialize(using = ToStringSerializer.class)
    @JsonDeserialize(as = Long.class)
    private Long ranks;

    @Column(name = "deleted", nullable = false)
    private Boolean deleted = false;

    @Column(name = "blocked", nullable = false)
    private Boolean blocked = false;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Long createdAt;

    @Column(name = "updated_at", nullable = false)
    private Long updatedAt;

    @Column(name = "deleted_at", nullable = false)
    private Long deletedAt;

    @ManyToOne
    @JoinColumn(name = "from_id", referencedColumnName = "id", nullable = false, updatable = false, insertable = false)
    private User from;

    @ToString.Exclude
    @ManyToMany
    @JoinTable(
            name = "post_tag",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    @OrderBy("id DESC")
    private Set<Tag> tags = new LinkedHashSet<>();

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "post_id", insertable = false, updatable = false)
    private PostMetrics metrics;

    @Transient
    @JsonProperty
    private Set<User> activeUsers = new LinkedHashSet<>();

    @Transient
    @JsonProperty
    @Builder.Default
    private Boolean liked = false;

    @Transient
    @JsonProperty
    @Builder.Default
    private Boolean favorited = false;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return id != null && Objects.equals(id, post.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
