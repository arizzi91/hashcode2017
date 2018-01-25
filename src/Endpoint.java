import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class Endpoint {
    private static int number_endpoint;
    private int id;
    private  int latency_to_datacenter;
    private int number_of_caches_connected;
    public final static int LIMIT_NUMBER_ENDPOINT=1000;
    private static ArrayList<Endpoint> endpoints;
    private  Map<Integer,Integer> chaches_server;
    private Map<Integer,Integer>request_video;//id cache,latency


    public Endpoint(int id,int latency_to_datacenter,int number_of_caches_connected) {
        this.id=id;
        this.latency_to_datacenter=latency_to_datacenter;
        this.number_of_caches_connected=number_of_caches_connected;
        chaches_server=new HashMap<>(number_of_caches_connected);
        request_video=new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public int getNumberOfCachesConnected() {
        return number_of_caches_connected;
    }

    public int getLatencyToDataCenter(){
        return latency_to_datacenter;
    }

    public static void addEndpoint(Endpoint endpoint){
        endpoints.add(endpoint);
    }

    public static Endpoint getEndpoint(int i){
        return endpoints.get(i);
    }

    public static int getNumberEndpoint() {
        return number_endpoint;
    }

    public static void addCachesServer(Endpoint endpoint,int id, int latency_cache){
        endpoint.chaches_server.put(id,latency_cache);
    }

    //print all Cache Server and its latency, given an endpoint
    public static void getCachesServer(Endpoint endpoint){
        Iterator<Integer> itr_cache = endpoint.chaches_server.keySet().iterator();
        Iterator<Integer> itr_latency=endpoint.chaches_server.values().iterator();
        while (itr_cache.hasNext()){
            System.out.println("ID Cache: "+itr_cache.next()+ " con latenza "+itr_latency.next()+ "\n");
        }
    }
    //print all request of a video, given an endpoint
    public static void getAllRequest(Endpoint endpoint){
        Iterator<Integer> itr_id_video = endpoint.request_video.keySet().iterator();
        Iterator<Integer> itr_frequency_video=endpoint.request_video.values().iterator();
        while (itr_id_video.hasNext()){
            System.out.println("ID Video: "+itr_id_video.next()+ " con frequenza "+itr_frequency_video.next()+ "\n");
        }
    }

    public static void setNumberEndpoint(int number_endpoint) {
        Endpoint.number_endpoint = number_endpoint;
        endpoints= new ArrayList<>(Endpoint.number_endpoint);
    }



    public static void setRequestEndpoint(Endpoint endpoint,int number_request,int id_video){
        endpoint.request_video.put(id_video,number_request);
    }
}
