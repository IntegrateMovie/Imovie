package cn.edu.nju.vo;

public class RfmAnalysis {
	//策略等级
	private int key;
	//客户人数
	private int numOfCus;
	//总金额
	private double profit;
	
	public RfmAnalysis(int key, int numOfCus, double profit) {
		super();
		this.key = key;
		this.numOfCus = numOfCus;
		this.profit = profit;
	}
	
	

}
