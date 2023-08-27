import java.io.Serializable;
import java.util.Date;
public class Album implements Serializable {
    private long id;
    private String artist;
    private String albumName;
    private float sales;
    private String[] genre;
    private Date releaseDate;
    public Album() {
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }
    public String getAlbumName() {
        return albumName;
    }
    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }
    public float getSales() {
        return sales;
    }
    public void setSales(float sales) {
        this.sales = sales;
    }
    public String[] getGenre() {
        return genre;
    }
    public void setGenre(String[] genre) {
        this.genre = genre;
    }
    public Date getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
}
