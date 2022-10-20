
package in.nareshtechnologies.inshortnews;

import java.util.List;

public class SourceData {

    public String category;
    public List<Datum> data = null;
    public boolean success;

    public SourceData(String category, List<Datum> data, boolean success) {
        this.category = category;
        this.data = data;
        this.success = success;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
