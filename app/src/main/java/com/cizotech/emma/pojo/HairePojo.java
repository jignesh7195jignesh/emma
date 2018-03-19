package com.cizotech.emma.pojo;

/**
 * Created by Sai Infotech on 3/13/2018.
 */

public class HairePojo {
    String title;
    String Path;
    boolean selected=false;

    public HairePojo(String title, String path, boolean selected) {
        this.title = title;
        Path = path;
        this.selected = selected;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPath() {
        return Path;
    }

    public void setPath(String path) {
        Path = path;
    }
}
