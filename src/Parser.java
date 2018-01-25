import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Parser {
    private final String FILE_NAME = "me_at_the_zoo.in";
    public void readFile() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(FILE_NAME));
        String line="";
        String parameter[];
        //line one: video,endpoint,request,cache,size cache
        line= in.readLine();
        parameter=line.split(" ");
        //set number of videos
        if(Integer.parseInt(parameter[0])<Video.LIMIT_NUMBER_VIDEOS){
            Video.setNumberVideos(Integer.parseInt(parameter[0]));
        }
        //set number of endpoints
        if(Integer.parseInt(parameter[1])<Endpoint.LIMIT_NUMBER_ENDPOINT){
            Endpoint.setNumberEndpoint(Integer.parseInt(parameter[1]));
        }
        //set number of request
        if(Integer.parseInt(parameter[2])<Request.LIMIT_NUMBER_REQUEST_DESCRIPTION){
            Request.setNumberRequest(Integer.parseInt(parameter[2]));
        }
        //set number of caches
        if(Integer.parseInt(parameter[3])<Cache_Server.LIMIT_NUMBER_CACHE_SERVER){
            Cache_Server.setNumberCache(Integer.parseInt(parameter[3]));
        }
        //set number capacity
        if(Integer.parseInt(parameter[4])<Cache_Server.LIMIT_CAPACITY_CACHE_SERVER){
            Cache_Server.setNumberCapacityCache(Integer.parseInt(parameter[4]));
            for(int i=0; i<Cache_Server.getNumberCache();i++){
                Cache_Server.addCache(new Cache_Server(i));
            }
        }
        //line two: size of videos
        line=in.readLine();
        parameter=line.split(" ");
        if(parameter.length==Video.getNumberVideos()){
            for(int i=0; i<Video.getNumberVideos();i++){
                if (Integer.parseInt(parameter[i])<Video.LIMIT_SIZE_VIDEO){
                    Video.addVideos(new Video(i,Integer.parseInt(parameter[i])));
                }
            }
        }
        //read section endpoints
        int number_endpoint=Endpoint.getNumberEndpoint();
        for(int i=0;i<number_endpoint;i++){
            line=in.readLine();
            //control constraints number: latency video in datacenter, number of cache
            parameter=line.split(" ");
            if (Integer.parseInt(parameter[0])>Datacenter.getLimit_latency_inferior() && Integer.parseInt(parameter[0])<Datacenter.getLimit_latency_superior()
                    && Integer.parseInt(parameter[1])<Cache_Server.getNumberCache()){
                Endpoint.addEndpoint(new Endpoint(i,Integer.parseInt(parameter[0]),Integer.parseInt(parameter[1])));
                if(Integer.parseInt(parameter[1]) != 0){//control if cache number is 0
                    for (int j=0; j<Integer.parseInt(parameter[1]);j++){
                        line=in.readLine();
                        String []parameter_cache = line.split(" ");
                        if(Integer.parseInt(parameter_cache[0])<Cache_Server.getNumberCache() && Integer.parseInt(parameter_cache[1])< Endpoint.getEndpoint(i).getLatencyToDataCenter()
                                && Integer.parseInt(parameter_cache[1])<Cache_Server.LIMIT_LATENCY_CACHE){
                            Endpoint.addCachesServer(Endpoint.getEndpoint(i),Integer.parseInt(parameter_cache[0]),Integer.parseInt(parameter_cache[1]));
                        }
                    }
                }

            }
        }
        //read section request
        for(int i=0; i<Request.getNumberRequest();i++){
            line=in.readLine();
            String [] parameter_request= line.split(" ");
            if(Integer.parseInt(parameter_request[0])<Video.getNumberVideos() && Integer.parseInt(parameter_request[1])<Endpoint.getNumberEndpoint()
                    && Integer.parseInt(parameter_request[2])<=Request.LIMIT_NUMBER_REQUEST){
                Endpoint.setRequestEndpoint(Endpoint.getEndpoint(Integer.parseInt(parameter_request[1])),Integer.parseInt(parameter_request[2]),Integer.parseInt(parameter_request[0]));
            }
        }
        in.close();
    }
}
