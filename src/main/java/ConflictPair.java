import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class ConflictPair {
    Interval left;
    Interval right;

    public void swapIntervals() {
        var tmp = this.left;
        this.left = this.right;
        this.right = tmp;
    }
}
