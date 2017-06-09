package cn.edu.nju.model;

import java.util.List;

/**
 * Created by 11946 on 2017/6/5.
 */
public class MovieInfo {

    private String name;
    private String mark;
    private Cinema cinema;
    private List<Price> priceList;
    private String price1;
    private String price2;
    private String price3;

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

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public List<Price> getPriceList() {
        return priceList;
    }

    public void setPriceList(List<Price> priceList) {
        this.priceList = priceList;
        this.price1 = priceList.get(0).getPrice()+"元起";
        this.price2 = priceList.get(1).getPrice()+"元起";
        this.price3 = priceList.get(2).getPrice()+"元起";
    }

	public String getPrice1() {
		return price1;
	}

	public void setPrice1(String price1) {
		this.price1 = price1;
	}

	public String getPrice2() {
		return price2;
	}

	public void setPrice2(String price2) {
		this.price2 = price2;
	}

	public String getPrice3() {
		return price3;
	}

	public void setPrice3(String price3) {
		this.price3 = price3;
	}
    
    
}
