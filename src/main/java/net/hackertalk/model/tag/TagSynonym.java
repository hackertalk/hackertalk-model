package net.hackertalk.model.tag;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@IdClass(TagSynonymId.class)
@Table(schema = "application", name = "tag_synonym")
public class TagSynonym implements Serializable {

    @Id
    @Column(name = "tag_id", nullable = false, updatable = false)
    @JsonDeserialize(as = Long.class)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long tagId;

    @Id
    @Column(name = "synonym", nullable = false, updatable = false, length = 35)
    private String synonym;
}
