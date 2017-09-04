package club.lovemo.Biz.Impl;

import java.util.List;

import club.lovemo.Biz.AppointmentBiz;
import club.lovemo.Dao.AppointmentDao;
import club.lovemo.Dao.Impl.AppointmentDaoImpl;
import club.lovemo.Entity.Appointment;
import club.lovemo.Entity.Appointment2;
//ÓAºs
public class AppointmentBizImpl implements AppointmentBiz {
	private AppointmentDao appointDao=null;
	public AppointmentBizImpl(){
		appointDao=new AppointmentDaoImpl();
	}
	@Override
	public boolean addAppointment(int uid, int bid) {
		return appointDao.addAppointment(uid, bid);
	}

	@Override
	public boolean delAppointment(int aid) {
		return appointDao.deleteAppointment(aid);
	}

	@Override
	public boolean delAppointmentByUid(int uid) {
		return appointDao.deleteAppointmentByUid(uid);
	}

	@Override
	public boolean delAppointmentByUid_Bid(int uid, int bid) {
		return appointDao.deleteAppointmentByUid_Bid(uid, bid);
	}

	@Override
	public boolean modifyAppointmentByAid(int aid, int bid) {
		return appointDao.updateAppointmentByAid(aid, bid);
	}

	@Override
	public List<Appointment> queryAppointByUid(int uid) {
		return appointDao.queryAppointByUid(uid);
	}

	@Override
	public List<Appointment> queryAppoinByBid(int bid) {
		return appointDao.queryAppoinByBid(bid);
	}

	@Override
	public List<Appointment> queryAllAppoin() {
		return appointDao.queryAllAppoin();
	}
	@Override
	public Appointment queryAppoinByAid(int aid) {
		return appointDao.queryAppoinByAid(aid);
	}
	@Override
	public List<Appointment2> queryAllAppoin2() {
		return appointDao.queryAllAppoin2();
	}

}
