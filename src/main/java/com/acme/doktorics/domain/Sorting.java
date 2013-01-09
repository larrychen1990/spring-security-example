package com.acme.doktorics.domain;

public enum Sorting {
    
    ASC("ASC"),
    DESC("DESC");
    
    
    private String sorter;
    
    private Sorting(String sorter)
    {
        this.sorter=sorter;
    }

    public String getSorter() {
        return sorter;
    }

    public void setSorter(String sorter) {
        this.sorter = sorter;
    }
    
    
}
