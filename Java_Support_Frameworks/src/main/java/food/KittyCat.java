package food;
import lombok.*;

@ToString(exclude = {"calorie"})
@EqualsAndHashCode(doNotUseGetters = true)
@RequiredArgsConstructor
public class KittyCat {

    private @NonNull String title;
    private @NonNull @Getter @Setter int weight;
    private @Getter @Setter Double calorie;
}