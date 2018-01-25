public class Request {
    public final static int LIMIT_NUMBER_REQUEST_DESCRIPTION =1000000;
    public final static int LIMIT_NUMBER_REQUEST=10000;
    private static int number_request_description;
    private int frequency;


    public static void setNumberRequest(int num){
        number_request_description =num;
    }

    public static int getNumberRequest() {
        return number_request_description;
    }



    public Request(int freq){
        this.frequency=freq;
    }


}
