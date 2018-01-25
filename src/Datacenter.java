public class Datacenter {
    private final static int limit_latency_inferior=2;
    private final static int limit_latency_superior=4000;

    public static int getLimit_latency_inferior() {
        return limit_latency_inferior;
    }

    public static int getLimit_latency_superior() {
        return limit_latency_superior;
    }
}
