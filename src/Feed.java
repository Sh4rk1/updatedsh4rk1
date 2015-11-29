import java.util.ArrayList;

/**
 * Created by Maciek on 2015-11-29.
 */
public class Feed {
    String title;
    String description;
    String link;
    String pubDate;

    public ArrayList<String> NewsList = new ArrayList<String>();

    public void setTitle(String title){
        this.title = title;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setLink(String link){
        this.link = link;
    }
    public void setPubDate(String pubDate){
        this.pubDate = pubDate;
    }
    public String toString(){
        return "Tytul: " + title + "\n"+ "Description: " + description + "\n"+ "Link: " + link + "\n";
    }
}
