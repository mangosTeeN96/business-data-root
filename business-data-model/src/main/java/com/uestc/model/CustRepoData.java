package com.uestc.model;

public class CustRepoData {
    private String billmouth;
    private Integer num_amt;
    private Integer num_repo;
    private String repo_rate;

    public String getBillmouth() {
        return billmouth;
    }

    public void setBillmouth(String billmouth) {
        this.billmouth = billmouth;
    }

    public Integer getNum_amt() {
        return num_amt;
    }

    public void setNum_amt(Integer num_amt) {
        this.num_amt = num_amt;
    }

    public Integer getNum_repo() {
        return num_repo;
    }

    public void setNum_repo(Integer num_repo) {
        this.num_repo = num_repo;
    }

    public String getRepo_rate() {
        return repo_rate;
    }

    public void setRepo_rate(String repo_rate) {
        this.repo_rate = repo_rate;
    }
}
