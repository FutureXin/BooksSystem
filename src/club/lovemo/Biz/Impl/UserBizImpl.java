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
	// 用户
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
					return 1;// 登录的是管理员
				} else {
					if (quser.isFrozen() == 1) {
						return 2;// 账号被冻结
					} else {
						return 3;// 普通用户登录成功，且可正常使用
					}
				}
			} else {
				return 0;// 登录失败
			}
		} else {
			return 0;// 登录失败
		}
	}

	@Override
	public int registerUser(User user) {
		if (userDao.queryUserByName(user.getuName()) != null) {
			return 1;// 此用户已存在
		} else {
			boolean res = userDao.addUser(user);
			if (res) {
				return 2;// 注册成功
			} else {
				return 0;// 注册失败
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
		// System.out.println(""+day+"天"+hour+"小时"+min+"分"+s+"秒");
		int poorday = day1 - 7;
//		System.out.println("积分:" + poorday);
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
					// 先查询预约表刊有无此用户没有解冻的冻结记录，有的话只改变金币数量，否则添加一条冻结记录
					FrozenTool(quser);
					SystemView.userFrozenView();
					// System.out.println("积分更新成功！");
					number = 1;
				}
			} else {
				if (userDao.updateUserPoint(quser.getUid(), Point, 0)) {
					// System.out.println("积分更新成功！");
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
			// TODO判断金币
			if (Point <= 0) {
				FrozenTool(quser);
			}
			if (Point > 0) {
				Fr = 0;
			}else{
				Fr = 1;
			}
			if (userDao.updateUserPoint(quser.getUid(), Point, Fr)) {
				// 归还后添加完金币后先判断金币数量是否大于0，如果大于0的话解冻，否则不解冻
				// TODO
				// System.out.println("积分更新成功！");
				number = 1;
			} else {
				// System.out.println("积分更新失败！");
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
