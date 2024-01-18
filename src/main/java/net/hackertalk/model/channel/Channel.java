package net.hackertalk.model.channel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import jakarta.persistence.*;
import lombok.*;
import net.hackertalk.model.client.User;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "application", name = "channel")
public class Channel implements Serializable {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @JsonDeserialize(as = Long.class)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    @Column(name = "from_id", nullable = false, updatable = false)
    @JsonDeserialize(as = Long.class)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long fromId;

    @Column(name = "icon", nullable = false, length = 64)
    private String icon;

    @Column(name = "name", nullable = false, length = 64)
    private String name;

    @Column(name = "description", nullable = false, length = 256)
    private String description;

    @Column(name = "permissions", nullable = false)
    @JsonDeserialize(as = Long.class)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long permissions;

    @Column(name = "max_members", nullable = false)
    private Integer maxMembers;

    @Column(name = "deleted", nullable = false)
    private Boolean deleted;

    @Column(name = "blocked", nullable = false)
    private Boolean blocked;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Long createdAt;

    @Column(name = "updated_at", nullable = false)
    private Long updatedAt;

    @Column(name = "deleted_at", nullable = false, updatable = false)
    private Long deletedAt;

    @ManyToOne
    @JoinColumn(name = "from_id", referencedColumnName = "id", updatable = false, insertable = false)
    private User from;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "channel_id", insertable = false, updatable = false)
    private ChannelMetrics metrics;

    @Transient
    @JsonProperty
    private Boolean joined;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Channel channel = (Channel) o;
        return id != null && Objects.equals(id, channel.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
