package club.lovemo.Biz.Impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import club.lovemo.Biz.FrozenBiz;
import club.lovemo.Biz.UserBiz;
import club.lovemo.Dao.UserDao;
import club.lovemo.Dao.Impl.UserDaoImpl;
import club.lovemo.Entity.Frozen;
import club.lovemo.Entity.Record;
import club.lovemo.Entity.User;
import club.lovemo.View.SystemView;

public class UserBizImpl extends Tools implements UserBiz {
	// �û�
	private UserDao userDao = null;
	private FrozenBiz frozenBiz = null;
	User quser = null;

	public UserBizImpl() {
		userDao = new UserDaoImpl();
		frozenBiz = new FrozenBizImpl();
	}

	@Override
	public int login(User user) {
		quser = userDao.queryUserByName(user.getuName());
		if (quser != null) {
			if (quser.getuName().equals(user.getuName())
					&& quser.getuPass().equals(user.getuPass())) {
				if (quser.isAdmini() == 1) {
					return 1;// ��¼���ǹ���Ա
				} else {
					if (quser.isFrozen() == 1) {
						return 2;// �˺ű�����
					} else {
						return 3;// ��ͨ�û���¼�ɹ����ҿ�����ʹ��
					}
				}
			} else {
				return 0;// ��¼ʧ��
			}
		} else {
			return 0;// ��¼ʧ��
		}
	}

	@Override
	public int registerUser(User user) {
		if (userDao.queryUserByName(user.getuName()) != null) {
			return 1;// ���û��Ѵ���
		} else {
			boolean res = userDao.addUser(user);
			if (res) {
				return 2;// ע��ɹ�
			} else {
				return 0;// ע��ʧ��
			}
		}
	}

	@Override
	public int updatePiontandFreezeUser(int rid, Record record, User quser,
			int lost, int state) {
		int number = 0;
		int integral = 1;
		int Fr = 0;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date now = null;
		java.util.Date date = null;
		try {
			now = df.parse(record.getReturnTime().substring(0, 19));
			date = df.parse(record.getLendTime().substring(0, 19));
		} catch (ParseException e) {
		}
		long l = now.getTime() - date.getTime();
		long day = l / (24 * 60 * 60 * 1000);
		int day1 = new Long(day).intValue();
		if (day < 1) {
			day1 = 1;
		}
		// long a = 10L;int b = new Long(a).intValue();
		// long hour=(l/(60*60*1000)-day*24);
		// long min=((l/(60*1000))-day*24*60-hour*60);
		// long s=(l/1000-day*24*60*60-hour*60*60-min*60);
		// System.out.println(""+day+"��"+hour+"Сʱ"+min+"��"+s+"��");
		int poorday = day1 - 7;
//		System.out.println("����:" + poorday);
		if (poorday > 0) {
			if (lost == 1) {
				poorday = poorday - 5;
			}
			if (state == 1) {
				poorday = poorday - 1;
			}
			int Point = quser.getPoint() - poorday;
			if (Point <= 0) {
				if (userDao.updateUserPoint(quser.getUid(), Point, 1)) {
					// TODO
					// �Ȳ�ѯԤԼ�����޴��û�û�нⶳ�Ķ����¼���еĻ�ֻ�ı����������������һ�������¼
					FrozenTool(quser);
					SystemView.userFrozenView();
					// System.out.println("���ָ��³ɹ���");
					number = 1;
				}
			} else {
				if (userDao.updateUserPoint(quser.getUid(), Point, 0)) {
					// System.out.println("���ָ��³ɹ���");
					number = 1;
				}
			}
		} else {
			if (lost == 1) {
				integral = integral - 6;
			}
			if (state == 1) {
				integral = integral - 2;
			}
			int Point = quser.getPoint() + integral;
			// TODO�жϽ��
			if (Point <= 0) {
				FrozenTool(quser);
			}
			if (Point > 0) {
				Fr = 0;
			}else{
				Fr = 1;
			}
			if (userDao.updateUserPoint(quser.getUid(), Point, Fr)) {
				// �黹��������Һ����жϽ�������Ƿ����0���������0�Ļ��ⶳ�����򲻽ⶳ
				// TODO
				// System.out.println("���ָ��³ɹ���");
				number = 1;
			} else {
				// System.out.println("���ָ���ʧ�ܣ�");
				number = 2;
			}
		}
		return number;
	}

	public void FrozenTool(User quser) {
		List<Frozen> frozens = frozenBiz.queryFrozenByUid(quser.getUid());
		if(frozens.size()==0){
			return;
		}else{
			Frozen frozne = null;
			boolean bool = true;
			int i = 0;
			for (i = 0; i < frozens.size(); i++) {
				frozne = frozens.get(i);
				if (frozne.getUnfrozentime() == null) {
					bool = false;
					break;
				} else {
					bool = true;
				}
			}
			if (bool) {
				frozne = frozens.get(i);
				frozne.setFrozentime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a").format(new Date()));
				frozenBiz.addFrozen(frozne);
				
			}
		}
	}
}
