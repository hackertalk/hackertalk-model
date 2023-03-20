package net.hackertalk.model.topic;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;
import net.hackertalk.data.tag.Tag;

import javax.persistence.*;
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
@Table(schema = "application", name = "topic")
public class Topic {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @JsonDeserialize(as = Long.class)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    @Column(name = "topic_name", unique = true, nullable = false, length = 32)
    private String topicName;

    @Column(name = "title", nullable = false, length = 64)
    private String title;

    @Column(name = "image", nullable = false, length = 64)
    private String image;

    @Column(name = "description", nullable = false, length = 256)
    private String description;

    @Column(name = "ranks", nullable = false)
    @JsonDeserialize(as = Long.class)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long ranks;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Long createdAt;

    @ToString.Exclude
    @ManyToMany
    @JoinTable(
            name = "topic_tag",
            joinColumns = @JoinColumn(name = "topic_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    @OrderBy("id DESC")
    private Set<Tag> tags = new LinkedHashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Topic topic = (Topic) o;
        return id != null && Objects.equals(id, topic.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
