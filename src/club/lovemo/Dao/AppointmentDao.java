package club.lovemo.Dao;

import java.util.List;

import club.lovemo.Entity.Appointment;
import club.lovemo.Entity.Appointment2;

public interface AppointmentDao {
	public boolean addAppointment(int uid, int bid);// ���ԤԼ

	public boolean deleteAppointment(int aid);// ����IDɾ��ԤԼ��¼

	public boolean deleteAppointmentByUid(int uid);// �����û�IDɾ�����û���ԤԼ��¼

	public boolean deleteAppointmentByUid_Bid(int uid, int bid);// �����û�ID��ͼ��IDɾ��ԤԼ��¼

	public boolean updateAppointmentByAid(int aid, int bid);// ����ԤԼ��¼�����

	public List<Appointment> queryAppointByUid(int uid);// ��ѯָ���û���ԤԼ��¼

	public List<Appointment> queryAppoinByBid(int bid);// ��ѯָ��ͼ���ԤԼ��¼

	public List<Appointment> queryAllAppoin();// ��ѯ���м�¼�����޹���Ա�鿴
	
	public Appointment queryAppoinByAid(int aid);//����ԤԼ��¼ID��ѯ��¼
	
	public List<Appointment2> queryAllAppoin2();//
	
}
