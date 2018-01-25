import java.util.ArrayList;

public class Video {
    private int size;
    private static int number_videos;
    private static ArrayList<Video> videos;
    private int id;
    public final static int LIMIT_NUMBER_VIDEOS=10000;
    public final static int LIMIT_SIZE_VIDEO=1000;

    public Video(int id,int size){
        this.id=id;
        this.size=size;
    }

    public static void addVideos(Video video){
        videos.add(video);
    }

    public int getSize() {
        return size;
    }

    public int getId() {
        return id;
    }

    public static ArrayList getVideosArray(){
        return videos;
    }

    public static Video getVideo(int i){
        return videos.get(i);
    }

    public static int getNumberVideos(){
        return number_videos;
    }

    public static void setNumberVideos(int num){
        number_videos=num;
        videos=new ArrayList<>(number_videos);
    }

}
