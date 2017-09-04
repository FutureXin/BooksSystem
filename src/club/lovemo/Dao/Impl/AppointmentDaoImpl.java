package club.lovemo.Dao.Impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import club.lovemo.Dao.AppointmentDao;
import club.lovemo.Entity.Appointment;
import club.lovemo.Entity.Appointment2;

public class AppointmentDaoImpl extends BaseDao implements AppointmentDao {

	@Override
	public boolean addAppointment(int uid, int bid) {
		String sql="insert into appointment(uid,bid,AppointTime) values(?,?,?)";
		List<Object> params=new ArrayList<Object>();
		params.add(uid);
		params.add(bid);
		params.add(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a").format(new Date()));
		return this.operUpdate(sql, params);
	}

	@Override
	public boolean deleteAppointment(int aid) {
		String sql="delete from appointment where aid=?";
		List<Object> params=new ArrayList<Object>();
		params.add(aid);
		return this.operUpdate(sql, params);
	}

	@Override
	public boolean deleteAppointmentByUid(int uid) {
		String sql="delete from appointment where uid=?";
		List<Object> params=new ArrayList<Object>();
		params.add(uid);
		return this.operUpdate(sql,params);
	}

	@Override
	public boolean deleteAppointmentByUid_Bid(int uid,int bid) {
		String sql="delete from appointment where uid=? and bid=?";
		List<Object> params=new ArrayList<Object>();
		params.add(uid);
		params.add(bid);
		return this.operUpdate(sql, params);
	}

	@Override
	public boolean updateAppointmentByAid(int aid,int bid) {
		String sql="update appointment set bid=?,appoint=? where aid=?";
		List<Object> params=new ArrayList<Object>();
		params.add(bid);
		params.add(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a").format(new Date()));
		params.add(aid);
		return this.operUpdate(sql, params);
	}

	@Override
	public List<Appointment> queryAppointByUid(int uid) {
		String sql="select * from appointment where uid=?";
		List<Object> params = new ArrayList<Object>();
		List<Appointment> aList=null;
		params.add(uid);
		try {
			aList=this.operQuery(sql, params,Appointment.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return aList;
	}

	@Override
	public List<Appointment> queryAppoinByBid(int bid) {
		String sql="select * from appointment where bid=?";
		List<Object> params = new ArrayList<Object>();
		List<Appointment> aList=null;
		params.add(bid);
		try {
			aList=this.operQuery(sql, params,Appointment.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return aList;
	}

	@Override
	public List<Appointment> queryAllAppoin() {
		String sql="select * from appointment";
		List<Appointment> aList=null;
		try {
			aList=this.operQuery(sql, null,Appointment.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return aList;
	}

	@Override
	public Appointment queryAppoinByAid(int aid) {
		String sql="select * from appointment where aid=?";
		List<Object> params = new ArrayList<Object>();
		List<Appointment> aList=null;
		params.add(aid);
		try {
			aList=this.operQuery(sql, params,Appointment.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(aList.size()>0){
			return aList.get(0);
		}
		return null;
	}

	@Override
	public List<Appointment2> queryAllAppoin2() {
		String sql="select a.aid,u.uid,u.uname,b.bid,b.bname,a.appointTime from appointment a,users u,books b where a.uid=u.uid and b.bid=a.bid";
		//TODO ‘› ±À„–¥ÕÍ
		List<Appointment2> aList2=null;
		try {
			aList2=this.operQuery(sql, null,Appointment2.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return aList2;
	}

}
