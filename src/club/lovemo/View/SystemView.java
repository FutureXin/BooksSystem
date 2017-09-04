package club.lovemo.View;

public class SystemView {
	public static void mainView() {
		System.out.println("***********欢迎使用图书管理系统************");
		System.out.println("系统使用规则说明：");
		System.out.println("1、用户注册默认为普通用户，默认为积分为10分，");
		System.out.println("积分规则为:\n\t(1).默认图书借阅期为7天，超过天数按一天一分扣除。\n\t(2).如丢失，则扣除5分，如超期则一样扣除积分。\n\t(3).如损坏则扣除1分，如超期则一样扣除积分。\n\t(4).如积分扣除后，小于或等于0，则冻结账户，\n\t用户将不能正常使用借书功能，用户需到管理员处进行解冻。");
		System.out.println("2、借书规则，每个用户同时最多可借4本。");
		System.out.println("3、还书规则，普通用户除自行归还图书为，\n\t还可到管理员处由管理员输入用户名进行归还，\n\t这样用户则不能评价此次所借之图书。");
		System.out.println("***********主窗口***********");
		System.out.println("1、用户登陆");
		System.out.println("2、用户注册");
		System.out.println("****************************");
	}
	public static void userFrozenView(){
		System.out.println("***********提示***********");
		System.out.println("1.抱歉您的账号已经被冻结，您将不可以正常使用借书功能！");
		System.out.println("2.请尽快到图书馆管理员处说明情况并请求解除冻结，谢谢合作！");
		System.out.println("****************************");
	}

	public static void userView() {
		System.out.println("**********普通用户界面*********");
		System.out.println("1.查看所有图书");
		System.out.println("2.查看比较受欢迎的图书");
		System.out.println("3.查看自己的借还记录");
		System.out.println("4.借书");
		System.out.println("5.还书");
		System.out.println("6.账号中心");
		System.out.println("7.预约中心");
		System.out.println("8.评价中心");
		System.out.println("9.按类型查看图书");
		System.out.println("10.退出登录");
		System.out.println("11.退出系统");
		System.out.println("****************************");
	}
	public static void Account_centerView(){
		System.out.println("***********账号中心***********");
		System.out.println("1.查看账号信息");
		System.out.println("2.修改账号信息");
		System.out.println("3.返回上层");
		System.out.println("****************************");
	}
	public static void Reservation_centerView(){
		System.out.println("***********预约中心***********");
		System.out.println("1.查看自己的所有预约记录");
		System.out.println("2.修改预约图书名");
		System.out.println("3.删除预约");
		System.out.println("4.返回上层");
		System.out.println("****************************");
	}
	public static void admini_Reservation_centerView(){
		System.out.println("********管理员版预约中心********");
		System.out.println("1.查看所有预约记录");
		System.out.println("2.返回上层");
		System.out.println("****************************");
	}
	public static void adminView() {
		System.out.println("**********管理员界面*********");
		System.out.println("1.查看所有图书");
		System.out.println("2.查看受欢迎的图书");
		System.out.println("3.查看所有借还记录");
		System.out.println("4.借书");
		System.out.println("5.还书");
		System.out.println("6.账号中心");
		System.out.println("7.查看所有预约");
		System.out.println("8.添加图书");
		System.out.println("9.冻结中心");
		System.out.println("10.图书信息中心");
		System.out.println("11.评价中心");
		System.out.println("12.按类型查看图书");
		System.out.println("13.删除图书");//删除前先判断是否全部归还
		System.out.println("14.退出登录");
		System.out.println("15.退出系统");
		System.out.println("****************************");
	}
	public static void Evaluation_centerView(){
		System.out.println("***********评价中心***********");
		System.out.println("1.查看所有图书评价");
		System.out.println("2.查看指定图书评价");
		System.out.println("3.修改指定评价信息");
		System.out.println("4.删除指定评价信息");
		System.out.println("5.返回上层");
		System.out.println("****************************");
	}
	public static void Freeze_centerView(){
		System.out.println("***********冻结中心***********");
		System.out.println("1.查看冻结账号");
		System.out.println("2.解冻账号");
		System.out.println("3.返回上层");
		System.out.println("****************************");
	}
	public static void TypeView(){
		System.out.println("**********图书类型如下*********");
		System.out.println("1.政治、法律");
		System.out.println("2.文化、科学、教育、体育");
		System.out.println("3.农业科学");
		System.out.println("4.历史、地理");
		System.out.println("5.交通运输");
		System.out.println("6.工业技术");
		System.out.println("7.社会科学总论");
		System.out.println("8.其他");
		System.out.println("9.返回上层");
		System.out.println("10.退出登录");
		System.out.println("11.退出系统");
		System.out.println("****************************");
	}
	public static void Bookinfo_certerView(){
		System.out.println("************图书信息中心**********");
		System.out.println("1.查看所有图书信息");
		System.out.println("2.查看所有损坏图书");
		System.out.println("3.查看所有丢失图书");
		System.out.println("4.删除所有丢失图书");//删除时同时要去Books表更改相应图书剩余数量，不用了，因为丢失的图书归还时没有添加剩余数量
		System.out.println("5.删除指定图书信息");
		System.out.println("6.返回上层");
		System.out.println("****************************");
	}
	public static void showTypeView(){
		System.out.println("**********图书类型如下*********");
		System.out.println("1.政治、法律");
		System.out.println("2.文化、科学、教育、体育");
		System.out.println("3.农业科学");
		System.out.println("4.历史、地理");
		System.out.println("5.交通运输");
		System.out.println("6.工业技术");
		System.out.println("7.社会科学总论");
		System.out.println("8.其他");
		System.out.println("****************************");
	}
}
