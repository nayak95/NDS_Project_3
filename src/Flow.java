public class Flow {
    private String flowID;
    private String flowSize; // number of packets in the flow
    private String estimatedSize;

    public String getEstimatedSize() {
        return estimatedSize;
    }

    public void setEstimatedSize(String estimatedSize) {
        this.estimatedSize = estimatedSize;
    }

    public String getFlowID() {
        return flowID;
    }

    public void setFlowID(String flowID) {
        this.flowID = flowID;
    }

    public String getFlowSize() {
        return flowSize;
    }

    public void setFlowSize(String flowSize) {
        this.flowSize = flowSize;
    }

    public Flow() {
        this.flowID = "0";
        this.flowSize = "0";
        this.estimatedSize = "0";
    }

    @Override
    public String toString() {
        return flowID + " " + estimatedSize + " " + flowSize;
    }
}
