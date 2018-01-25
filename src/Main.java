import java.io.IOException;



public class Main {

    public static void main (String []args) throws IOException {
        Parser parser= new Parser();
        parser.readFile();
        System.out.println("Numero di video: "+ Video.getNumberVideos() + "\n");
        System.out.println("Numero di endpoint: "+ Endpoint.getNumberEndpoint() + "\n");
        System.out.println("Numero di richieste descritte: "+ Request.getNumberRequest()+ "\n");
        System.out.println("Numero di cache "+ Cache_Server.getNumberCache()+" di dimensione pari a "+ Cache_Server.getCapacity()+ "MB \n");
        System.out.println("Stampo ID e dimensione di ogni video \n");
        for (int i=0; i<Video.getNumberVideos();i++){
            System.out.println("ID Video: "+Video.getVideo(i).getId()+ " dimensione "+Video.getVideo(i).getSize()+ "MB \n");
        }

        System.out.println("Stampo caratteristiche di ogni cache \n");
        for (int i=0; i<Cache_Server.getNumberCache();i++){
            System.out.println("ID Cache "+Cache_Server.getCacheServer(i).getId()+ " ,dimensione cache "+Cache_Server.getCacheServer(i).getActualCapacity()+ "MB \n");
        }

        System.out.println("Stampo caratteristiche di ogni endpoint \n");
        for (int i=0;i<Endpoint.getNumberEndpoint();i++){
            System.out.println("ID Endpoint "+Endpoint.getEndpoint(i).getId()+ ", numero cache connesse "+Endpoint.getEndpoint(i).getNumberOfCachesConnected()+
                    ", latenza dal datacenter "+ Endpoint.getEndpoint(i).getLatencyToDataCenter()+ "\n");
        }
        System.out.println("Stampo latenza di endpoint-->cache"+ "\n");
        for(int i=0; i<Endpoint.getNumberEndpoint();i++){
            System.out.println("Endpoint "+Endpoint.getEndpoint(i).getId() +"\n");
            Endpoint.getCachesServer(Endpoint.getEndpoint(i));
        }
        System.out.println("Stampo tutte le richieste video di ogni endpoint");
        for (int i=0; i<Endpoint.getNumberEndpoint(); i++){
            System.out.println("Endpoint "+Endpoint.getEndpoint(i).getId()+ "\n");
            Endpoint.getAllRequest(Endpoint.getEndpoint(i));
        }


    }




}

