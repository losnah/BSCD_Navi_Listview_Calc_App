package com.gkskfhdlstmapk.hanpinetree.bcsd_navi_listview_calc;

public class ListItem {
    String name;

    public ListItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ListItem{" +
                "name='" + name + '\'' +
                '}';
    }
}
