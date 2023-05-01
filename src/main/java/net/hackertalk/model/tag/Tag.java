package net.hackertalk.model.tag;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;

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
@Table(schema = "application", name = "tag")
public class Tag implements Serializable {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @JsonSerialize(using = ToStringSerializer.class)
    @JsonDeserialize(as = Long.class)
    private Long id;

    @Column(name = "tag_name", nullable = false, length = 35, unique = true)
    private String tagName;

    @Column(name = "image", nullable = false, length = 32)
    private String image;

    @Column(name = "excerpt", nullable = false, length = 256)
    private String excerpt;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Long createdAt;

    @ToString.Exclude
    @ElementCollection
    @Column(name = "synonym")
    @CollectionTable(schema = "application", name = "tag_synonym", joinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id"))
    private Set<String> synonyms = new LinkedHashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var tag = (Tag) o;
        return id != null && Objects.equals(id, tag.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
