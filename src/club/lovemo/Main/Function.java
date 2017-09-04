package club.lovemo.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import club.lovemo.Biz.AppointmentBiz;
import club.lovemo.Biz.BookBiz;
import club.lovemo.Biz.BookinfoBiz;
import club.lovemo.Biz.CommentsBiz;
import club.lovemo.Biz.FrozenBiz;
import club.lovemo.Biz.RecordBiz;
import club.lovemo.Biz.UserBiz;
import club.lovemo.Biz.Impl.AppointmentBizImpl;
import club.lovemo.Biz.Impl.BookBizImpl;
import club.lovemo.Biz.Impl.BookinfoBizImpl;
import club.lovemo.Biz.Impl.CommentsBizImpl;
import club.lovemo.Biz.Impl.FrozenBizImpl;
import club.lovemo.Biz.Impl.RecordBizImpl;
import club.lovemo.Biz.Impl.Tools;
import club.lovemo.Biz.Impl.UserBizImpl;
import club.lovemo.Dao.UserDao;
import club.lovemo.Dao.Impl.UserDaoImpl;
import club.lovemo.Entity.Appointment;
import club.lovemo.Entity.Appointment2;
import club.lovemo.Entity.Book;
import club.lovemo.Entity.Bookinfo;
import club.lovemo.Entity.Bookinfo2;
import club.lovemo.Entity.Comments;
import club.lovemo.Entity.Comments2;
import club.lovemo.Entity.Frozen;
import club.lovemo.Entity.Record;
import club.lovemo.Entity.Record2;
import club.lovemo.Entity.User;
import club.lovemo.View.SystemView;

public class Function extends Tools {
	private Scanner input;
	private UserBiz userBiz;
	private CommentsBiz commentsBiz;
	private FrozenBiz frozenBiz;
	private BookinfoBiz bookinfoBiz;
	private BookBiz bookBiz;
	private AppointmentBiz appointBiz;
	private RecordBiz recordBiz;
	private UserDao userDao;
	User user = null;// 保存登录用户信息

	public Function() {
		input = new Scanner(System.in);
		userBiz = new UserBizImpl();
		commentsBiz = new CommentsBizImpl();
		frozenBiz = new FrozenBizImpl();
		bookinfoBiz = new BookinfoBizImpl();
		bookBiz = new BookBizImpl();
		appointBiz = new AppointmentBizImpl();
		recordBiz = new RecordBizImpl();
		userDao = new UserDaoImpl();
	}

	public void mainMenu() {
		SystemView.mainView();
		while (true) {
			System.out.print("选择:");
			int key = InputInt();
			switch (key) {
			case 0:
				System.out.println("输入错误，请重新输入！");
				break;
			case 1:
				loginMenu();
				break;
			case 2:
				registerUser();
				break;
			default:
				System.out.println("输入错误，请重新输入！");
				break;
			}
		}
	}

	public void registerUser() {
		String uName;
		String uPass1;
		String uPass2;
		System.out.println("只能由数字、字母、汉字、下划线组成！！！");
		System.out.print("请输入用户名：");
		uName = InputName();
		// uName=input.nextLine();
		while (true) {
			System.out.println("只能由数字、字母组成！！！");
			System.out.print("请输入密码：");
			uPass1 = InputPass();
			System.out.print("请再次输入确认密码:");
			uPass2 = InputPass();
			if (!uPass1.equals(uPass2)) {
				System.out.println("两次密码不一致");
				continue;
			} else {
				user = new User();
				user.setuName(uName);
				user.setuPass(uPass1);
				break;
			}
		}

		int res = userBiz.registerUser(user);
		if (res == 1) {
			System.out.println("此用户名已经被注册!");
		} else if (res == 2) {
			System.out.println("注册成功!");
			System.out.println("您的账号ID为："
					+ userDao.queryUserByName(user.getuName()).getUid()
					+ "\t请牢记！！！");
			mainMenu();// 回到主菜单
		} else {
			System.out.println("注册失败!");
			mainMenu();// 回到主菜单
		}
	}

	public void loginMenu() {
		String inputname = null;
		String inputpass = null;
		int count = 0;
		while (count < 3) {
			System.out.println("由数字、字母、汉字、下划线组成！！！");
			System.out.println("请输入您的用户名：");
			// inputname = InputName();
			inputname = input.nextLine();
			System.out.println("由数字、字母组成！！！");
			System.out.println("请输入您的密码：");
			// inputpass = InputPass();
			inputpass = input.nextLine();
			user = new User();
			user.setuName(inputname);
			user.setuPass(inputpass);
			int res = userBiz.login(user);
			if (res == 1) {
				LoginCheckAppointment();
				adminiMenu();
				break;
			} else if (res == 2) {
				SystemView.userFrozenView();
				LoginCheckAppointment();
				userMenu();
				break;
			} else if (res == 3) {
				LoginCheckAppointment();
				userMenu();
				break;
			} else {
				count++;
				System.out.println("登陆失败");
				if (count == 3) {
					System.out.println("系统结束");
					System.exit(0);
				}
				System.out.println("用户名或密码不正确,还有" + (3 - count) + "次机会");
			}
		}
	}

	public void userMenu() {
		SystemView.userView();
		while (true) {
			System.out.print("选择:");
			int key = InputInt();
			// boolean key;
			switch (key) {
			case 0:
				System.out.println("输入错误，请重新输入！");
				break;
			case 1:
				showAllBooks();
				break;
			case 2:
				showBooks_top_five();
				break;
			case 3:
				showMyRecords(user);
				break;
			case 4:
				lendBook();
				break;
			case 5:
				returnBook();
				break;
			case 6:
				Account_center();
				break;
			case 7:
				Reservation_center();
				break;
			case 8:
				Evaluation_certer();
				break;
			case 9:
				showAccording_To_The_Type();
				break;
			case 10:
				mainMenu();
				break;
			case 11:
				System.out.println("欢迎下次光临！");
				System.exit(0);
				break;
			default:
				System.out.println("输入错误，请重新输入！");
				break;
			}
		}
	}

	public void adminiMenu() {
		SystemView.adminView();
		while (true) {
			System.out.print("选择:");
			int key = InputInt();
			switch (key) {
			case 0:
				System.out.println("输入错误，请重新输入！");
				break;
			case 1:
				showAllBooks();
				break;
			case 2:
				showBooks_top_five();
				break;
			case 3:
				showAllRecord();
				break;
			case 4:
				lendBook();
				break;
			case 5:
				returnBook();
				break;
			case 6:
				Account_center();
				break;
			case 7:
				showAllReservation();
				break;
			case 8:
				addBook();
				break;
			case 9:
				adminiFreeze();
				break;
			case 10:
				Bookinfo_certer();
				break;
			case 11:
				Evaluation_certer();
				break;
			case 12:
				showAccording_To_The_Type();
				break;
			case 13:
				delBookByBid();
				break;
			case 14:
				mainMenu();
				break;
			case 15:
				System.out.println("欢迎下次光临！");
				System.exit(0);
				break;
			default:
				System.out.println("输入错误，请重新输入！");
				break;
			}
		}
	}

	public void Evaluation_certer() {
		SystemView.Evaluation_centerView();
		while (true) {
			System.out.print("选择:");
			int key = InputInt();
			switch (key) {
			case 0:
				System.out.println("输入错误，请重新输入！");
				break;
			case 1:
				showAllComments();
				break;
			case 2:
				showCommentsByBid();
				break;
			case 3:
				modifyComments();
				break;
			case 4:
				delCommentsByCid();
				break;
			case 5:
				if (userDao.queryUserByName(user.getuName()).isAdmini() == 1) {
					adminiMenu();
				} else {
					userMenu();
				}
				break;
			default:
				System.out.println("输入错误，请重新输入！");
				break;
			}
		}
	}

	public void Bookinfo_certer() {
		SystemView.Bookinfo_certerView();
		while (true) {
			System.out.print("选择:");
			int key = InputInt();
			switch (key) {
			case 0:
				System.out.println("输入错误，请重新输入！");
				break;
			case 1:
				showAllBookinfo2();
				break;
			case 2:
				showAllstateBookinfo();
				break;
			case 3:
				showAlllostBookinfo();
				break;
			case 4:
				delAll_lostBookinfo();
				break;
			case 5:
				delBookinfoById();
				break;
			case 6:
				adminiMenu();
				break;
			default:
				System.out.println("输入错误，请重新输入！");
				break;
			}
		}
	}

	public void adminiFreeze() {
		SystemView.Freeze_centerView();
		while (true) {
			System.out.print("选择:");
			int key = InputInt();
			switch (key) {
			case 0:
				System.out.println("输入错误，请重新输入:");
				break;
			case 1:
				showFreezeUser();
				break;
			case 2:
				modifyFreezeUser();
				break;
			case 3:
				adminiMenu();
				break;
			default:
				System.out.println("输入错误，请重新选择:");
				break;
			}
		}
	}

	public void Account_center() {
		SystemView.Account_centerView();
		while (true) {
			System.out.print("选择:");
			int key = InputInt();
			switch (key) {
			case 0:
				System.out.println("输入错误，请重新输入！");
				break;
			case 1:
				System.out.println(userDao.queryUserByName(user.getuName()));
				break;
			case 2:
				updateUsernameandpass();
				break;
			case 3:
				if (userDao.queryUserByName(user.getuName()).isAdmini() == 1) {
					adminiMenu();
				} else {
					userMenu();
				}
				break;
			default:
				System.out.println("输入错误，请重新输入！");
				break;
			}
		}
	}

	public void Reservation_center() {
		SystemView.Reservation_centerView();
		while (true) {
			System.out.print("选择:");
			int key = InputInt();
			switch (key) {
			case 0:
				System.out.println("输入错误，请重新输入:");
				break;
			case 1:
				showAllReservationByUid();
				break;
			case 2:
				modifyReservation();
				break;
			case 3:
				delReservation();
				break;
			case 4:
				userMenu();
				break;
			default:
				System.out.println("输入错误，请重新选择:");
				break;
			}
		}
	}

	public void showAccording_To_The_Type() {
		SystemView.TypeView();
		User quser = userDao.queryUserByName(user.getuName());
		while (true) {
			System.out.print("选择:");
			int key = InputInt();
			if (key < 1 || key > 11) {
				System.out.println("输入错误，请重新输入:");
			} else if (key == 9) {
				if (quser.isAdmini() == 1) {
					adminiMenu();
					break;
				} else {
					userMenu();
					break;
				}
			} else if (key == 10) {
				mainMenu();
				break;
			} else if (key == 11) {
				System.out.println("欢迎下次光临！");
				System.exit(0);
			} else {
				List<Book> books = bookBiz.queryBookByType(key);
				if (books.size() > 0) {
					for (Book book : books) {
						System.out.println(book);
					}
				} else {
					System.out.println("无图书信息!");
				}
			}
		}
	}

	public void delBookByBid() {
		Book book = null;
		List<Appointment> appointment = null;
		System.out.println("请输入要删除的图书ID：");
		int inputid = InputInt();
		book = bookBiz.queryBookByBid(inputid);
		if (book != null) {
			appointment = appointBiz.queryAppoinByBid(book.getBid());
			if (book.getHasLended() == 0 && appointment.size() == 0) {
				if (bookBiz.delBook(inputid)) {
					bookinfoBiz.delBookinfoByBid(inputid);
					System.out.println("删除成功！");
				} else {
					System.out.println("删除失败！");
				}
			} else {
				System.out
						.println("该图书没有全部归还或还有用户已经预约了，不能删除，\n可到图书信息中心删除已经归还的，谢谢合作！");
			}
		} else {
			System.out.println("没有此图书，请核对后再操作，谢谢合作！");
		}
	}

	private void delCommentsByCid() {
		System.out.println("请输入您要删除的评价信息ID：");
		int inputcid = InputInt();
		int uid = userDao.queryUserByName(user.getuName()).getUid();
		Comments comm = commentsBiz.queryCommentsByCid(inputcid);
		if (comm != null) {
			int quid = comm.getUid();
			if (quid == uid) {
				if (commentsBiz.delComments(inputcid)) {
					System.out.println("删除成功！！！");
				} else {
					System.out.println("删除失败！！！");
				}
			} else {
				System.out.println("您不是删除别人的评价信息！！！");
			}
		} else {
			System.out.println("没有您要删除的评价信息，请核对后再操作！！！");
		}
	}

	public void delBookinfoById() {
		int id = 0;
		showAllBookinfo2();
		System.out.println("请输入您要删除图书信息的ID：");
		id = InputInt();
		Bookinfo qbookinfo = bookinfoBiz.queryBookinfoById(id);
		if (qbookinfo != null) {
			// TODO
			// if(appointBiz.queryAppoinByBid(qbookinfo.getBid()).size()>0){}
			if (qbookinfo.getLost() == 0) {
				if (qbookinfo.getInout() == 1) {
					if (bookinfoBiz.delBookinfoById(id)) {
						if (bookBiz.updateBook_count(qbookinfo.getBid())) {
							System.out.println("删除成功！");
						} else {
							System.out.println("图书剩余数量修改失败！");
						}

					} else {
						System.out.println("删除失败！");
					}
				} else {
					System.out.println("您不能删除未归还的图书信息！");
				}
			} else {
				if (qbookinfo.getInout() == 1) {
					if (bookinfoBiz.delBookinfoById(id)) {
						System.out.println("删除成功！");
					} else {
						System.out.println("删除失败！");
					}
				} else {
					System.out.println("您不能删除未归还的图书信息！");
				}
			}
		} else {
			System.out.println("没有您要删除的图书信息，请核对后再操作！！！");
		}
	}

	public void delAll_lostBookinfo() {
		if (!bookinfoBiz.delBookinfo_lost()) {
			System.out.println("没有丢失的图书要删除！！！");
		}
	}

	public void showAlllostBookinfo() {
		List<Bookinfo> bookinfos = bookinfoBiz.queryAllLostBookinfo();
		if (bookinfos.size() > 0) {
			for (Bookinfo bookinfo : bookinfos) {
				System.out.println(bookinfo);
			}
		} else {
			System.out.println("没有丢失的图书信息！");
		}
	}

	public void showAllstateBookinfo() {
		List<Bookinfo> bookinfos = bookinfoBiz.queryAllStateBookinfo();
		if (bookinfos.size() > 0) {
			for (Bookinfo bookinfo : bookinfos) {
				System.out.println(bookinfo);
			}
		} else {
			System.out.println("没有损坏的图书信息！");
		}
	}

	public void showAllBookinfo2() {
		List<Bookinfo2> bookinfos2 = bookinfoBiz.queryAllBookinfo2();
		if (bookinfos2.size() > 0) {
			for (Bookinfo2 bookinfo2 : bookinfos2) {
				System.out.println(bookinfo2);
			}
		} else {
			System.out.println("没有图书信息！");
		}
	}

	public void showAllBookinfo() {
		List<Bookinfo> bookinfos = bookinfoBiz.queryAllBookinfo();
		if (bookinfos.size() > 0) {
			for (Bookinfo bookinfo : bookinfos) {
				System.out.println(bookinfo);
			}
		} else {
			System.out.println("没有图书信息！");
		}
	}

	public void LoginCheckAppointment() {
		User quser = userDao.queryUserByName(user.getuName());
		int uid = quser.getUid();
		int bid = 0;
		List<Object> results = new ArrayList<Object>();
		Appointment appoint = null;
		List<Appointment> appoints = appointBiz.queryAppointByUid(uid);
		if (appoints.size() > 0) {
			for (int i = 0; i < appoints.size(); i++) {
				appoint = appoints.get(i);
				bid = appoint.getBid();
				Book book = bookBiz.queryBookByBid(bid);
				if (book.getCount() > 0) {
					if (appointBiz.delAppointment(appoints.get(i).getAid())) {
						results.add(book.getbName()+ " 可借！" + "已自动删除预约记录！！！");
					} else {
						results.add(book.getbName()+ " 可借！" + "自动删除预约记录失败!!!");
					}
				} else {
					results.add(bid + "\t不可借");
				}
			}
			for (Object re : results) {
				System.out.println(re);
			}
		}
	}

	public void updatePiontandFreezeUser(int rid, int lost, int state) {
		Record record = recordBiz.queryRecordByRid(rid);
		User quser = userDao.queryUserById(record.getUid());
		int res = userBiz.updatePiontandFreezeUser(rid, record, quser, lost,
				state);
		if (res == 1) {
			System.out.println("积分更新成功！");
		} else {
			System.out.println("积分更新失败！");
		}
	}

	public void showAllComments() {
		List<Comments2> comms2 = commentsBiz.queryAllComments2();
		if (comms2.size() > 0) {
			for (Comments2 comm2 : comms2) {
				System.out.println(comm2);
			}
		} else {
			System.out.println("无评价信息!");
		}
	}

	public void showCommentsByBid() {
		while (true) {
			System.out.println("请输入您要查看图书的名字：");
			String bname = input.nextLine();
			Book qbook = bookBiz.queryBookByName(bname);
			if (qbook != null) {
				List<Comments> comms = commentsBiz.queryCommentsByBid(qbook
						.getBid());
				if (comms.size() > 0) {
					for (Comments comm : comms) {
						System.out.println(comm);
					}
					break;
				} else {
					System.out.println("无评价信息!");
					break;
				}
			} else {
				System.out.println("图书馆无此图书！");
				break;
			}
		}
	}

	public void modifyComments() {
		User quser = userDao.queryUserByName(user.getuName());
		System.out.println("请输入您要修改的评论记录ID：");
		int key = InputInt();
		Comments comm = commentsBiz.queryCommentsByCid(key);
		if (comm != null) {
			int cuid = comm.getUid();
			if (quser.getUid() == cuid) {
				System.out.println("请输入评分（评分最高100分）：");
				comm.setScore(InputInt());
				System.out.println("请输入评语（100字内）：");
				comm.setComments(input.nextLine());
				if (commentsBiz.modifyComments(comm)) {
					System.out.println("修改评价成功！！！");
					Evaluation_certer();
				} else {
					System.out.println("修改评论失败！！！");
					Evaluation_certer();
				}
			} else {
				System.out.println("您不能修改别人的评价记录！！！");
				Evaluation_certer();
			}
		} else {
			System.out.println("无此评价信息，请核对后再进行操作！！！");
		}
	}

	public void addComments(Bookinfo bookinfo) {
		User quser = userDao.queryUserByName(user.getuName());
		Comments comm = null;
		System.out.println("是否进行评价（1.是-2.否）：");
		while (true) {
			int key = InputInt();
			if (key == 2) {
				if (quser.isAdmini() == 0) {
					userMenu();
				} else {
					adminiMenu();
				}
			} else if (key == 1) {
				if (quser.isAdmini() == 0) {
					int bid = bookinfoBiz.queryBookinfoById(bookinfo.getId())
							.getBid();
					comm = new Comments();
					comm.setBid(bid);
					comm.setUid(quser.getUid());
					System.out.println("请输入评分（只能为整数；评分最高100分，最低0分）：");
					while (true) {
						int score = InputInt();
						if (score >= 0 && score <= 100) {
							comm.setScore(score);
							break;
						} else {
							System.out.println("抱歉，评分要小于或等于100，大于或等于0，请重新输入：");
						}
					}
					System.out.println("请输入评语（50字内，超出部分自动去除！）：");
					String commy = input.nextLine();
					if (commy.length() > 150) {
						commy = commy.substring(0, 100);
					}
					comm.setComments(commy);
					if (commentsBiz.addComments(comm)) {
						System.out.println("评价成功！！");
						userMenu();
						break;
					} else {
						System.out.println("评论失败！！");
						userMenu();
						break;
					}
				} else {
					System.out.println("抱歉您是管理员不能评价！");
					adminiMenu();
					break;
				}
			} else {
				System.out.println("请输入1或2：");
			}
		}
	}

	public void showAllRecord() {
		List<Record2> records2 = recordBiz.queryAllRecord2();
		if (records2.size() > 0) {
			for (Record2 record2 : records2) {
				System.out.println(record2);
			}
		} else {
			System.out.println("无借书记录!");
		}
	}

	public void showAllBooks() {
		List<Book> books = bookBiz.queryAllBooks();
		if (books.size() > 0) {
			for (Book book : books) {
				System.out.println(book);
			}
		} else {
			System.out.println("无图书信息!");
		}
	}

	public void showBooks_top_five() {
		int number = 0;
		int count = bookBiz.queryAllBooks().size();
		if (count == 0) {
			System.out.println("无图书信息!");
			return;
		} else if (count < 5) {
			number = count;
		} else {
			number = 5;
		}
		// System.out.println(count+":"+number);
		List<Book> books = bookBiz.ranking_top_five(number);
		if (books.size() > 0) {
			for (Book book : books) {
				System.out.println(book);
			}
		} else {
			System.out.println("无图书信息！");
		}
	}

	public void showMyRecords(User user) {
		List<Record> records = recordBiz.queryUserRecords(user.getuName());
		if (records.size() > 0) {
			for (Record record : records) {
				System.out.println(record);
			}
		} else {
			System.out.println("无记录信息!");
		}
	}

	public void lendBook() {
		int yon = 0;
		boolean type = true;
		showAllBooks();
		System.out
				.println("为了让大家都能借到想要的书，且不必等待太久，\n图书馆规定每个人手中同时最多只能有四本未归还的书！！！");
		User quser = userDao.queryUserByName(user.getuName());
		if (quser.isAdmini() == 1) {
			System.out.println("请输入用户名：");
			String uname = input.nextLine();
			quser = userDao.queryUserByName(uname);
			if (quser != null) {
				if (quser.isFrozen() == 1) {
					SystemView.userFrozenView();
					type = false;
				} else {
				}
			} else {
				System.out.println("抱歉，这个用户没有注册，请核对后再进行操作！！！");
				type = false;
				return;
			}
		} else {
			if (quser.isFrozen() == 1) {
				SystemView.userFrozenView();
				type = false;
			} else {
				type = true;
			}
		}
		int i = 0;
		int number = 0;
		Record record = null;
		List<Record> records = recordBiz.queryUserRecords(quser.getuName());
		for (i = 0; i < records.size(); i++) {
			record = records.get(i);
			if (record.getReturnTime() == null) {
				number++;
			}
		}
		if (number == 4) {
			System.out.println("抱歉，您已经借了四本书，且还未归还，\n所有再为归还其中的任意一本前您不能再借书！");
			return;
		}
		if (type) {
			System.out.println("请输入您要借的书名：");
			while (true) {
				String bName = input.nextLine();
				Book book = bookBiz.queryBookByName(bName);
				if (book != null) {
					int bid = book.getBid();
					int res = bookinfoBiz.lendBook(bName, quser.getUid());
					if (res == 1) {
						if(userDao.queryUserByName(user.getuName()).isAdmini()==0){
							System.out.println("不可以借，已经全部借出，或被预约了");
							// System.out.println("您可到预约中心进行预约，如预约成功我们将会在您下次登陆时提醒您是否可借！");
							boolean t=false;
							List<Appointment> appoints=appointBiz.queryAppointByUid(quser.getUid());
							if(appoints==null){
								t=true;
							}else{
								for(int j=0;j<appoints.size();j++){
									if(appoints.get(j).getBid()==bid){
										t=false;
									}else{
										t=true;
										break;
									}
								}
							}
							if(t){
								System.out.println("输入1进行预约。输入其他数字退出。");
								yon = InputInt();
								if (yon == 1) {
									Reservation(book);
								}
						}else{
							System.out.println("您已经预约了这本书！");
						}
					}else{
						System.out.println("您不能帮用户预约！");
					}
						break;
					} else if (res == 2) {
						System.out.println("借出成功！");
						appointBiz.delAppointmentByUid_Bid(quser.getUid(), bid);
						break;
					} else if (res == 3) {
						System.out.println("借出失败！");
						break;
					} else {
						System.out.println("没有图书信息");
						break;
					}
				} else {
					System.out.println("图书馆没有这本图书！");
					System.out.println("重新输入请输1，输入其他数字退出：");
					String key = input.nextLine();
					if (!key.equals("1")) {
						break;
					}
				}
			}
		}
	}

	public void returnBook() {
		User quser = null;
		quser = userDao.queryUserByName(user.getuName());
		if (quser.isAdmini() == 1) {
			System.out.println("请输入要归还书借出时记录的用户名:");
			// String uname = InputName();
			String uname = input.nextLine();
			quser = userDao.queryUserByName(uname);
			if (quser == null) {
				System.out.println("输入的用户名有误,请核对后进行操作，谢谢合作！");
				return;
			}
		}
		System.out.println("用户" + quser.getuName() + "所有借还记录如下:");
		showMyRecords(quser);
		System.out.println("请输入要归还书籍的记录信息ID:");
		int rid = InputInt();
		Record qrecord = recordBiz.queryRecordByRid(rid);
		if (qrecord == null) {
			System.out.println("无此记录信息");
		} else {
			if (qrecord.getReturnTime() != null) {
				System.out.println("图书已经归还，不能再次归还！");
			} else {
				qrecord.setUid(quser.getUid());// 根据登录账户查询出的uid
				Bookinfo bookinfo = bookinfoBiz.queryBookinfoById(qrecord
						.getId());
				System.out.println("请输入是否丢失（0-没有丢失，1-丢失）:");
				int Lost = InputInt();
				if (Lost == 0) {
					bookinfo.setLost(Lost);
					System.out.println("请输入是否在你手中损坏（0-没有损坏，1-损坏）:");
					while (true) {
						int State = InputInt();
						if (State != 0 && State != 1) {
							System.out.println("输入错误，请输入0或1:");
						} else {
							bookinfo.setState(State);
							break;
						}
					}
					int res = bookinfoBiz.returnBook(qrecord, bookinfo);
					if (res == 1) {
						System.out.println("书名输入不正确:");
					} else if (res == 2) {
						System.out.println("已经归还!");
					} else if (res == 3) {
						System.out.println("归还成功!");
						updatePiontandFreezeUser(rid, 0, bookinfo.getState());// 修改积分
						System.out.println("剩余积分："
								+ userDao.queryUserByName(quser.getuName())
										.getPoint());
						if (userDao.queryUserByName(user.getuName()).isAdmini() == 0) {
							addComments(bookinfo);// 为什么反过来没有用.评价
						} else {
							System.out.println("因为您是管理员所以不能进行评价！！！");
							adminiMenu();
						}
					} else if (res == 4) {
						System.out.println("归还失败!");
					} else {
						System.out.println("抱歉您不能还别人的书!");
					}
				} else if (Lost == 1) {
					bookinfo.setLost(Lost);
					bookinfo.setInout(1);
					bookinfoBiz.returnBook(qrecord, bookinfo);
					updatePiontandFreezeUser(rid, 1, bookinfo.getState());// 修改积分
					System.out.println("记录成功!");
				} else {
					System.out.println("输入错误！");
				}
			}
		}
	}

	public void updateUsernameandpass() {
		User quser = userDao.queryUserByName(user.getuName());
		System.out.println("只能包含中文，英文，数字和下划线。！");
		System.out.println("请输入修改后的用户名：");
		// String name = InputName();
		String name = input.nextLine();
		// TODO
		User quser1 = userDao.queryUserByName(name);
		if (quser1 != null) {
			System.out.println("该用户名已经被注册了！");
		} else {
			System.out.println("只能包含英文和数字。！");
			System.out.println("请输入修改后的密码:");
			// String pass = InputPass();
			String pass = input.nextLine();
			if (name.matches("^[\u4e00-\u9fa5\\w]+$")
					&& pass.matches("^[a-zA-Z0-9]+$")) {
				quser.setuName(name);
				quser.setuPass(pass);
			} else {
				System.out.println("用户名或密码格式不对！！！");
				System.out.println("请看提示，谢谢合作！！！");
				System.out.println("用户名只能包含中文，英文，数字和下划线。！");
				System.out.println("密码只能包含英文和数字。！");
				Account_center();
			}
			if (userDao.updateUser(quser)) {
				user.setuName(name);
				user.setuPass(pass);
				System.out.println("修改成功!");
			} else {
				System.out.println("修改失败!");
			}
		}
	}

	public void addBook() {// 添加图书时先判断是否已经存在这本书，如果存在只添加数量
		Book book = new Book();
		Bookinfo boin = null;
		int cunt = 0;
		int ty = 0;
		int count;
		String bname;
		System.out.println("请输入书名:");
		bname = input.nextLine();
		Book qbook = bookBiz.queryBookByName(bname);
		if (qbook != null) {
			System.out.println("这本书已经存在图书馆了，请输入您要添加的数量:");
			int number = InputInt();
			boin = new Bookinfo(qbook.getBid(), 1, 0, 0);
			qbook.setCount(qbook.getCount() + number);
			for (int i = 0; i < number; i++) {
				if (bookinfoBiz.addBookinfo(boin) && bookBiz.modifyBook(qbook)) {
					cunt++;
				}
			}
			if (cunt == number) {
				System.out.println("图书馆信息表已经更新！");
			} else {
				System.out.println("图书馆信息表更新失败！");
			}
		} else {
			System.out.println("请输入数量:");
			while (true) {
				count = InputInt();
				if (count > 0) {
					break;
				} else {
					System.out.println("请输入正确的数量，重新输入：");
				}
			}
			SystemView.showTypeView();
			System.out.println("请输入所属类型:");
			while (true) {
				int type = InputInt();
				if (type > 0 && type < 9) {
					ty = type;
					break;
				} else {
					System.out.println("没有您输入的这个类型，请重新输入：");
				}
			}
			System.out.println("请输入作者名称:");
			String author = input.nextLine();
			book.setbName(bname);
			book.setCount(count);
			book.setType(ty);
			book.setAuthor(author);
			boolean bo = bookBiz.addBook(book);
			// System.out.println(bo);
			Book qbook1 = bookBiz.queryBookByName(bname);
			// System.out.println(qbook1);
			boin = new Bookinfo(qbook1.getBid(), 1, 0, 0);
			for (int i = 0; i < count; i++) {
				if (bookinfoBiz.addBookinfo(boin)) {
					cunt++;
				}
			}
			if (bo && cunt == count) {
				System.out.println("图书馆信息表已经更新！");
			} else {
				System.out.println("图书馆信息表更新失败！");
			}
		}
	}

	public void showFreezeUser() {
		List<Frozen> frozens = frozenBiz.queryAllFrozen();
		if (frozens.size() > 0) {
			for (Frozen frozen : frozens) {
				System.out.println(frozen);
			}
		} else {
			System.out.println("没有记录！！！");
		}
	}

	public void modifyFreezeUser() {
		System.out.println("请输入要解冻记录的ID：");
		int fid = InputInt();
		Frozen frozen = frozenBiz.queryFrozenByFid(fid);
		if (frozen != null) {
			if (frozenBiz.modifyFrozen(fid)) {
				if (userDao.updateUserPoint(frozen.getUid(), 10, 0)) {
					System.out.println("解冻成功！");
				} else {
					System.out.println("解冻失败！");
				}
			} else {
				System.out.println("解冻失败，请检查记录ID是否正确！！！");
			}
		} else {
			System.out.println("没有此记录，请核对后再操作！");
		}
	}

	public void Reservation(Book book) {
		User quser = userDao.queryUserByName(user.getuName());
//		System.out.println("请输入预约图书名字：");
//		String bname = input.nextLine();
//		Book qbook = null;
//		qbook = bookBiz.queryBookByName(bname);
		if (book != null) {
			int bid = book.getBid();
			if ((book.getCount() + book.getHasLended())
					- appointBiz.queryAppoinByBid(bid).size() > 0) {
				if (appointBiz.addAppointment(quser.getUid(), bid)) {
					System.out.println("预约成功!");
				} else {
					System.out.println("预约失败！");
				}
			} else {
				System.out.println("没有多余的图书可以预约！");
			}
		} else {
			System.out.println("没有此图书！！！");
		}
	}

	public void modifyReservation() {
		Book book = null;
		User quser = userDao.queryUserByName(user.getuName());
		System.out.println("请输入要修改的预约记录ID：");
		int aid = InputInt();
		Appointment appoint = appointBiz.queryAppoinByAid(aid);
		if (appoint != null) {
			System.out.println("请输入要修改后的图书名：");
			String bname = input.nextLine();
			book = bookBiz.queryBookByName(bname);
			if (book != null) {
				int uid = quser.getUid();
				int bid = book.getBid();
				if ((book.getCount()+book.getHasLended()) - appointBiz.queryAppoinByBid(bid).size() > 0) {
					if (appoint.getUid() == uid) {
						if (appointBiz.modifyAppointmentByAid(aid, bid)) {
							System.out.println("修改成功！");
						} else {
							System.out.println("修改失败！");
						}
					} else {
						System.out.println("你不能修改别人的预约记录！");
					}
				} else {
					System.out.println("你要预约的图书没有预约名额了!");
				}
			} else {
				System.out.println("图书馆无此图书！");
			}
		} else {
			System.out.println("没有这条预约记录，请核对后再操作！");
		}
	}

	public void delReservation() {
		int uid = userDao.queryUserByName(user.getuName()).getUid();
		List<Appointment> appoints = appointBiz.queryAppointByUid(uid);
		if(appoints==null){
			System.out.println("您没有预约记录！");
			return;
		}else{
			showAllReservationByUid();
			System.out.println("请输入你要删除的预约记录ID:");
			int aid = InputInt();
			Appointment appoint = appointBiz.queryAppoinByAid(aid);
			if (appoint != null) {
				int quid = appoint.getUid();
				if (uid == quid) {
					if (appointBiz.delAppointment(aid)) {
						System.out.println("删除成功！");
					} else {
						System.out.println("删除失败！");
					}
				} else {
					System.out.println("您不能删除别人的预约记录！");
				}
			} else {
				System.out.println("无此预约记录，请核对后再操作！");
			}
		}
	}

	public void showAllReservationByUid() {
		int uid = userDao.queryUserByName(user.getuName()).getUid();
		List<Appointment> appoints = appointBiz.queryAppointByUid(uid);
		if (appoints.size() > 0) {
			for (Appointment appoint : appoints) {
				System.out.println(appoint);
			}
		} else {
			System.out.println("您没有预约记录！");
		}
	}

	public void showAllReservation() {
		List<Appointment2> appoints2 = appointBiz.queryAllAppoin2();
		if (appoints2.size() > 0) {
			for (Appointment2 appoint2 : appoints2) {
				System.out.println(appoint2);
			}
		} else {
			System.out.println("没有预约记录！");
		}
	}
}
