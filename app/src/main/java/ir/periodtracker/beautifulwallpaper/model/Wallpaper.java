
package ir.periodtracker.beautifulwallpaper.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Wallpaper {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("imageid")
    @Expose
    private String imageid;
    @SerializedName("downloadurl")
    @Expose
    private String downloadurl;
    @SerializedName("dimensions")
    @Expose
    private Dimensions dimensions;
    @SerializedName("authors")
    @Expose
    private List<String> authors = null;
    @SerializedName("clicks")
    @Expose
    private String clicks;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageid() {
        return imageid;
    }

    public void setImageid(String imageid) {
        this.imageid = imageid;
    }

    public String getDownloadurl() {
        return downloadurl;
    }

    public void setDownloadurl(String downloadurl) {
        this.downloadurl = downloadurl;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public String getClicks() {
        return clicks;
    }

    public void setClicks(String clicks) {
        this.clicks = clicks;
    }

}
