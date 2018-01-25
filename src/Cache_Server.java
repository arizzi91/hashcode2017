import java.util.ArrayList;

public class Cache_Server {
    private int actual_capacity;
    private static int capacity;
    private int id;
    private static int number_cache;
    public static final int LIMIT_CAPACITY_CACHE_SERVER =500000;
    public static final int LIMIT_NUMBER_CACHE_SERVER =1000;
    public static final int LIMIT_LATENCY_CACHE=500;
    private static ArrayList<Cache_Server> cache_servers;


    public Cache_Server(int id) {
        this.id= id;
        this.actual_capacity=capacity;
    }

    public int getActualCapacity() {
        return actual_capacity;
    }

    public int getId() {
        return id;
    }

    public static int getCapacity(){
        return capacity;
    }

    //restituisci oggetto cache server dall'array dato un indice
    public static Cache_Server getCacheServer(int i){
        return cache_servers.get(i);
    }


    public static void setNumberCache(int num) {
        number_cache=num;
        cache_servers=new ArrayList<>(number_cache);
    }

    public static int getNumberCache(){
        return number_cache;
    }


    public static void setNumberCapacityCache(int num) {
        capacity=num;
    }

    public static void addCache(Cache_Server cache_server) {
        cache_servers.add(cache_server);
    }
}
