package TreeCheckBoxes;

public class CheckBoxNode {
    final String label;
    final Status status;
    CheckBoxNode(String label) {
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