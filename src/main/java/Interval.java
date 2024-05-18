import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Interval {
    Pair<UUID, UUID> low;
    Pair<UUID, UUID> high;

    public boolean isEmpty() {
        return low == null && high == null;
    }

}
