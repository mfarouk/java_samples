package hello;

/**
 * Created by farouk on 4/30/17.
 */
public class Bean {
    private final long id;
    private final String[] content;

    public Bean(long id, String[] content){
        this.id = id;
        this.content = content;
    }
    public long getId(){
        return id;
    }
    public String[] getContent(){
        return content;
    }
}
