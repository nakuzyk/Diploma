package animals;

import lombok.*;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = "weight")
public abstract class Animal {
    private String name;
    private @Setter Double weight;
}