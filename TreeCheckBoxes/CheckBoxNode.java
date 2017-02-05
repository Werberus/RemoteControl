package TreeCheckBoxes;

public class CheckBoxNode {
    public final String label;
    public final Status status;
    public CheckBoxNode(String label) {
        this.label = label;
        status = Status.INDETERMINATE;
    }
    public CheckBoxNode(String label, Status status) {
        this.label = label;
        this.status = status;
    }
    @Override public String toString() {
        return label;
    }
}