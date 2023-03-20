package net.hackertalk.model.tag;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class TagSynonymId implements Serializable {
    private Long tagId;
    private String synonym;
}
