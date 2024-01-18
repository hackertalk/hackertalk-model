package net.hackertalk.model.channel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import jakarta.persistence.*;
import lombok.*;
import net.hackertalk.model.client.User;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@IdClass(ChannelMemberId.class)
@Table(schema = "application", name = "channel_member")
public class ChannelMember implements Serializable {

    @JsonDeserialize(as = Long.class)
    @JsonSerialize(using = ToStringSerializer.class)
    @Column(name = "id", nullable = false, updatable = false, unique = true)
    private Long id;

    @Id
    @JsonDeserialize(as = Long.class)
    @JsonSerialize(using = ToStringSerializer.class)
    @Column(name = "channel_id", nullable = false, updatable = false)
    private Long channelId;

    @Id
    @JsonDeserialize(as = Long.class)
    @JsonSerialize(using = ToStringSerializer.class)
    @Column(name = "user_id", nullable = false, updatable = false)
    private Long userId;

    @Column(name = "permissions", nullable = false)
    @JsonDeserialize(as = Long.class)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long permissions;

    @Column(name = "muted_until", nullable = false)
    @JsonDeserialize(as = Long.class)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long mutedUntil; // disable community until xx timestamp

    @Column(name = "created_at", nullable = false, updatable = false)
    private Long createdAt;

    @Transient
    @JsonProperty
    private Boolean online;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, updatable = false, insertable = false)
    private User user;

    @ToString.Exclude
    @ManyToMany
    @JoinTable(
            name = "channel_member_role",
            schema = "application",
            joinColumns = {
                    @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
                    @JoinColumn(name = "channel_id", referencedColumnName = "channel_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "role_id", referencedColumnName = "id"),
            }
    )
    @OrderBy("id DESC")
    private Set<ChannelRole> roles = new LinkedHashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChannelMember that = (ChannelMember) o;
        return channelId != null && Objects.equals(channelId, that.channelId)
                && userId != null && Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(channelId, userId);
    }
}
