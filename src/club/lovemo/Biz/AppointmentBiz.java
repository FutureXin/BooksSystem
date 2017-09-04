package club.lovemo.Biz;

import java.util.List;

import club.lovemo.Entity.Appointment;
import club.lovemo.Entity.Appointment2;

public interface AppointmentBiz {
	public boolean addAppointment(int uid, int bid);// ���ԤԼ

	public boolean delAppointment(int aid);// ����IDɾ��ԤԼ��¼

	public boolean delAppointmentByUid(int uid);// �����û�IDɾ�����û���ԤԼ��¼

	public boolean delAppointmentByUid_Bid(int uid, int bid);// �����û�ID��ͼ��IDɾ��ԤԼ��¼

	public boolean modifyAppointmentByAid(int aid, int bid);// ����ԤԼ��¼�����

	public List<Appointment> queryAppointByUid(int uid);// ��ѯָ���û���ԤԼ��¼

	public List<Appointment> queryAppoinByBid(int bid);// ��ѯָ��ͼ���ԤԼ��¼

	public List<Appointment> queryAllAppoin();// ��ѯ���м�¼�����޹���Ա�鿴
	
	public Appointment queryAppoinByAid(int aid);//����ԤԼ��ID��ѯ��¼
	
	public List<Appointment2> queryAllAppoin2();
}
