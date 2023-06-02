package net.hackertalk.model.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "application", name = "user")
public class User {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @JsonSerialize(using = ToStringSerializer.class)
    @JsonDeserialize(as = Long.class)
    private Long id;

    @Column(name = "nickname", nullable = false, length = 64)
    private String nickname;

    @Column(name = "username", nullable = false, length = 16)
    private String username;

    @Column(name = "bio", nullable = false, length = 256)
    private String bio;

    @Column(name = "avatar", nullable = false, length = 64)
    private String avatar;

    @Column(name = "cover", nullable = false, length = 64)
    private String cover;

    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "website", nullable = false, length = 64)
    private String website;

    @Column(name = "location", nullable = false, length = 32)
    private String location;

    @Column(name = "birthday", nullable = false, length = 10)
    private String birthday; // MM/DD/YYYY

    @Column(name = "verified", nullable = false)
    private Boolean verified;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Long createdAt;

    @Column(name = "updated_at", nullable = false)
    private Long updatedAt;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "user_id", insertable = false, updatable = false)
    private UserMetrics metrics;

    @Transient
    @JsonProperty
    private Boolean isInternalTestUser;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
