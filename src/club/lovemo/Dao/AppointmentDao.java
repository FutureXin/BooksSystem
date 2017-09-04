package club.lovemo.Dao;

import java.util.List;

import club.lovemo.Entity.Appointment;
import club.lovemo.Entity.Appointment2;

public interface AppointmentDao {
	public boolean addAppointment(int uid, int bid);// 添加预约

	public boolean deleteAppointment(int aid);// 根据ID删除预约记录

	public boolean deleteAppointmentByUid(int uid);// 根据用户ID删除该用户的预约记录

	public boolean deleteAppointmentByUid_Bid(int uid, int bid);// 根据用户ID和图书ID删除预约记录

	public boolean updateAppointmentByAid(int aid, int bid);// 更新预约记录书表名

	public List<Appointment> queryAppointByUid(int uid);// 查询指点用户的预约记录

	public List<Appointment> queryAppoinByBid(int bid);// 查询指点图书的预约记录

	public List<Appointment> queryAllAppoin();// 查询所有记录，仅限管理员查看
	
	public Appointment queryAppoinByAid(int aid);//根据预约记录ID查询记录
	
	public List<Appointment2> queryAllAppoin2();//
	
}
