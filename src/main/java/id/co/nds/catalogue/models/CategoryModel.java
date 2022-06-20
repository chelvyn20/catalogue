package id.co.nds.catalogue.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CategoryModel extends RecordModel {
    // main
    @Size(min = 6, max = 6, message = "category id must contain 6 digits")
    @Pattern(regexp = "^(PC)[0-9]{4}$", message = "category id must start with 'PC' and followed by 4 digits number")
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
