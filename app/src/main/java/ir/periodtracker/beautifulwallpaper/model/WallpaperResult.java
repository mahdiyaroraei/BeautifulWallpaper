
package ir.periodtracker.beautifulwallpaper.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WallpaperResult {

    @SerializedName("search_tags")
    @Expose
    private List<Object> searchTags = null;
    @SerializedName("amount")
    @Expose
    private Integer amount;
    @SerializedName("offset")
    @Expose
    private Integer offset;
    @SerializedName("search_total")
    @Expose
    private Integer searchTotal;
    @SerializedName("result")
    @Expose
    private List<Wallpaper> result = null;

    public List<Object> getSearchTags() {
        return searchTags;
    }

    public void setSearchTags(List<Object> searchTags) {
        this.searchTags = searchTags;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getSearchTotal() {
        return searchTotal;
    }

    public void setSearchTotal(Integer searchTotal) {
        this.searchTotal = searchTotal;
    }

    public List<Wallpaper> getResult() {
        return result;
    }

    public void setResult(List<Wallpaper> result) {
        this.result = result;
    }

}
