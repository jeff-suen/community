package com.around.community.entity;

public class Page {

    // current page
    private int current = 1;
    // post limit for each page
    private int limit = 10;
    // total records (for cal. total number of pages)
    private int rows;
    // Querying path
    private String path;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        if (current>=1) {
            this.current = current;
        }
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if (limit>=1 && limit <= 100){
            this.limit = limit;
        }
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        if (rows>=0) {
            this.rows = rows;
        }

    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Retrieve the starting row number in the current page
     * @return
     */
    public int getOffset() {
        return (current - 1) * limit;
    }

    /**
     * Retrieve the total page number
     * @return
     */
    public int getTotal() {
        if (rows % limit == 0) {
            return rows / limit;
        } else {
            return rows / limit + 1;
        }
    }

    /**
     * retrieve the starting page number
     * @return
     */
    public int getFrom() {
        int from = current - 2;
        return from < 1 ? 1:from;
    }

    /**
     * retrieving the end page numebr
     * @return
     */
    public int getTo() {
        int to = current + 2;
        int total = getTotal();
        return to > total ? total:to;
    }
}
