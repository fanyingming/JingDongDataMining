package JDAnalysis;

import java.util.HashMap;

public class Analysis_base_price {
	//3000以下
	//3000-5000
	//5000-8000
	//8000-15000
	//15000-30000
	//30000以上
	String qujian="";
	int modelamount;
	int sellamount;
	HashMap<String, Analysis_base_brand> hmp;
	public Analysis_base_price()
	{
		hmp=new HashMap<String, Analysis_base_brand>();
		String []name={"三星","海尔","Thinkpad","东芝","联想","戴尔","苹果","宏碁","富士通","未来人类","华硕","外星人","清华同方","Gateway","惠普","雷蛇","神舟","七喜","优派","null","微星","索尼","技嘉"};
		for(int i=0;i<name.length;i++)
		{
			hmp.put(name[i], new Analysis_base_brand());
		}
	}
}