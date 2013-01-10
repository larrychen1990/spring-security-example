package com.acme.doktorics.domain;




public enum UserRight {
    
    
    ADMIN_ROLE("ADMIN_ROLE"),USER_ROLE("USER_ROLE");
    
    private String right;
    
    private UserRight(String right)
    {
        this.right=right;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }
    
    
}
