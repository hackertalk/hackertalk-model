package net.hackertalk.model.talk;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;
import net.hackertalk.model.client.User;

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
@Table(schema = "application", name = "short")
public class Talk implements Serializable, Comparable<Talk> {

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

    @Column(name = "content", nullable = false, length = 1024)
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

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "talk_id", insertable = false, updatable = false)
    private TalkMetrics metrics;

    @Transient
    @JsonProperty
    @Builder.Default
    private Boolean liked = false;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Talk aTalk = (Talk) o;
        return getId() != null && Objects.equals(getId(), aTalk.getId());
    }

    @Override
    public final int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public int compareTo(Talk o) {
        return this.getId().compareTo(o.getId());
    }
}
