package cn.edu.nju.model;

import java.util.List;

/**
 * Created by 11946 on 2017/6/5.
 */
public class MovieInfo {

    private String name;
    private List<Mark> mark;
    private Cinema cinema;
    private List<Price> priceList;

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Mark> getMark() {
        return mark;
    }

    public void setMark(List<Mark> mark) {
        this.mark = mark;
    }

    public List<Price> getPriceList() {
        return priceList;
    }

    public void setPriceList(List<Price> priceList) {
        this.priceList = priceList;
    }
}
