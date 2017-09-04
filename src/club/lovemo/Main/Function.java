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
	User user = null;// �����¼�û���Ϣ

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
			System.out.print("ѡ��:");
			int key = InputInt();
			switch (key) {
			case 0:
				System.out.println("����������������룡");
				break;
			case 1:
				loginMenu();
				break;
			case 2:
				registerUser();
				break;
			default:
				System.out.println("����������������룡");
				break;
			}
		}
	}

	public void registerUser() {
		String uName;
		String uPass1;
		String uPass2;
		System.out.println("ֻ�������֡���ĸ�����֡��»�����ɣ�����");
		System.out.print("�������û�����");
		uName = InputName();
		// uName=input.nextLine();
		while (true) {
			System.out.println("ֻ�������֡���ĸ��ɣ�����");
			System.out.print("���������룺");
			uPass1 = InputPass();
			System.out.print("���ٴ�����ȷ������:");
			uPass2 = InputPass();
			if (!uPass1.equals(uPass2)) {
				System.out.println("�������벻һ��");
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
			System.out.println("���û����Ѿ���ע��!");
		} else if (res == 2) {
			System.out.println("ע��ɹ�!");
			System.out.println("�����˺�IDΪ��"
					+ userDao.queryUserByName(user.getuName()).getUid()
					+ "\t���μǣ�����");
			mainMenu();// �ص����˵�
		} else {
			System.out.println("ע��ʧ��!");
			mainMenu();// �ص����˵�
		}
	}

	public void loginMenu() {
		String inputname = null;
		String inputpass = null;
		int count = 0;
		while (count < 3) {
			System.out.println("�����֡���ĸ�����֡��»�����ɣ�����");
			System.out.println("�����������û�����");
			// inputname = InputName();
			inputname = input.nextLine();
			System.out.println("�����֡���ĸ��ɣ�����");
			System.out.println("�������������룺");
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
				System.out.println("��½ʧ��");
				if (count == 3) {
					System.out.println("ϵͳ����");
					System.exit(0);
				}
				System.out.println("�û��������벻��ȷ,����" + (3 - count) + "�λ���");
			}
		}
	}

	public void userMenu() {
		SystemView.userView();
		while (true) {
			System.out.print("ѡ��:");
			int key = InputInt();
			// boolean key;
			switch (key) {
			case 0:
				System.out.println("����������������룡");
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
				System.out.println("��ӭ�´ι��٣�");
				System.exit(0);
				break;
			default:
				System.out.println("����������������룡");
				break;
			}
		}
	}

	public void adminiMenu() {
		SystemView.adminView();
		while (true) {
			System.out.print("ѡ��:");
			int key = InputInt();
			switch (key) {
			case 0:
				System.out.println("����������������룡");
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
				System.out.println("��ӭ�´ι��٣�");
				System.exit(0);
				break;
			default:
				System.out.println("����������������룡");
				break;
			}
		}
	}

	public void Evaluation_certer() {
		SystemView.Evaluation_centerView();
		while (true) {
			System.out.print("ѡ��:");
			int key = InputInt();
			switch (key) {
			case 0:
				System.out.println("����������������룡");
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
				System.out.println("����������������룡");
				break;
			}
		}
	}

	public void Bookinfo_certer() {
		SystemView.Bookinfo_certerView();
		while (true) {
			System.out.print("ѡ��:");
			int key = InputInt();
			switch (key) {
			case 0:
				System.out.println("����������������룡");
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
				System.out.println("����������������룡");
				break;
			}
		}
	}

	public void adminiFreeze() {
		SystemView.Freeze_centerView();
		while (true) {
			System.out.print("ѡ��:");
			int key = InputInt();
			switch (key) {
			case 0:
				System.out.println("�����������������:");
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
				System.out.println("�������������ѡ��:");
				break;
			}
		}
	}

	public void Account_center() {
		SystemView.Account_centerView();
		while (true) {
			System.out.print("ѡ��:");
			int key = InputInt();
			switch (key) {
			case 0:
				System.out.println("����������������룡");
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
				System.out.println("����������������룡");
				break;
			}
		}
	}

	public void Reservation_center() {
		SystemView.Reservation_centerView();
		while (true) {
			System.out.print("ѡ��:");
			int key = InputInt();
			switch (key) {
			case 0:
				System.out.println("�����������������:");
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
				System.out.println("�������������ѡ��:");
				break;
			}
		}
	}

	public void showAccording_To_The_Type() {
		SystemView.TypeView();
		User quser = userDao.queryUserByName(user.getuName());
		while (true) {
			System.out.print("ѡ��:");
			int key = InputInt();
			if (key < 1 || key > 11) {
				System.out.println("�����������������:");
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
				System.out.println("��ӭ�´ι��٣�");
				System.exit(0);
			} else {
				List<Book> books = bookBiz.queryBookByType(key);
				if (books.size() > 0) {
					for (Book book : books) {
						System.out.println(book);
					}
				} else {
					System.out.println("��ͼ����Ϣ!");
				}
			}
		}
	}

	public void delBookByBid() {
		Book book = null;
		List<Appointment> appointment = null;
		System.out.println("������Ҫɾ����ͼ��ID��");
		int inputid = InputInt();
		book = bookBiz.queryBookByBid(inputid);
		if (book != null) {
			appointment = appointBiz.queryAppoinByBid(book.getBid());
			if (book.getHasLended() == 0 && appointment.size() == 0) {
				if (bookBiz.delBook(inputid)) {
					bookinfoBiz.delBookinfoByBid(inputid);
					System.out.println("ɾ���ɹ���");
				} else {
					System.out.println("ɾ��ʧ�ܣ�");
				}
			} else {
				System.out
						.println("��ͼ��û��ȫ���黹�����û��Ѿ�ԤԼ�ˣ�����ɾ����\n�ɵ�ͼ����Ϣ����ɾ���Ѿ��黹�ģ�лл������");
			}
		} else {
			System.out.println("û�д�ͼ�飬��˶Ժ��ٲ�����лл������");
		}
	}

	private void delCommentsByCid() {
		System.out.println("��������Ҫɾ����������ϢID��");
		int inputcid = InputInt();
		int uid = userDao.queryUserByName(user.getuName()).getUid();
		Comments comm = commentsBiz.queryCommentsByCid(inputcid);
		if (comm != null) {
			int quid = comm.getUid();
			if (quid == uid) {
				if (commentsBiz.delComments(inputcid)) {
					System.out.println("ɾ���ɹ�������");
				} else {
					System.out.println("ɾ��ʧ�ܣ�����");
				}
			} else {
				System.out.println("������ɾ�����˵�������Ϣ������");
			}
		} else {
			System.out.println("û����Ҫɾ����������Ϣ����˶Ժ��ٲ���������");
		}
	}

	public void delBookinfoById() {
		int id = 0;
		showAllBookinfo2();
		System.out.println("��������Ҫɾ��ͼ����Ϣ��ID��");
		id = InputInt();
		Bookinfo qbookinfo = bookinfoBiz.queryBookinfoById(id);
		if (qbookinfo != null) {
			// TODO
			// if(appointBiz.queryAppoinByBid(qbookinfo.getBid()).size()>0){}
			if (qbookinfo.getLost() == 0) {
				if (qbookinfo.getInout() == 1) {
					if (bookinfoBiz.delBookinfoById(id)) {
						if (bookBiz.updateBook_count(qbookinfo.getBid())) {
							System.out.println("ɾ���ɹ���");
						} else {
							System.out.println("ͼ��ʣ�������޸�ʧ�ܣ�");
						}

					} else {
						System.out.println("ɾ��ʧ�ܣ�");
					}
				} else {
					System.out.println("������ɾ��δ�黹��ͼ����Ϣ��");
				}
			} else {
				if (qbookinfo.getInout() == 1) {
					if (bookinfoBiz.delBookinfoById(id)) {
						System.out.println("ɾ���ɹ���");
					} else {
						System.out.println("ɾ��ʧ�ܣ�");
					}
				} else {
					System.out.println("������ɾ��δ�黹��ͼ����Ϣ��");
				}
			}
		} else {
			System.out.println("û����Ҫɾ����ͼ����Ϣ����˶Ժ��ٲ���������");
		}
	}

	public void delAll_lostBookinfo() {
		if (!bookinfoBiz.delBookinfo_lost()) {
			System.out.println("û�ж�ʧ��ͼ��Ҫɾ��������");
		}
	}

	public void showAlllostBookinfo() {
		List<Bookinfo> bookinfos = bookinfoBiz.queryAllLostBookinfo();
		if (bookinfos.size() > 0) {
			for (Bookinfo bookinfo : bookinfos) {
				System.out.println(bookinfo);
			}
		} else {
			System.out.println("û�ж�ʧ��ͼ����Ϣ��");
		}
	}

	public void showAllstateBookinfo() {
		List<Bookinfo> bookinfos = bookinfoBiz.queryAllStateBookinfo();
		if (bookinfos.size() > 0) {
			for (Bookinfo bookinfo : bookinfos) {
				System.out.println(bookinfo);
			}
		} else {
			System.out.println("û���𻵵�ͼ����Ϣ��");
		}
	}

	public void showAllBookinfo2() {
		List<Bookinfo2> bookinfos2 = bookinfoBiz.queryAllBookinfo2();
		if (bookinfos2.size() > 0) {
			for (Bookinfo2 bookinfo2 : bookinfos2) {
				System.out.println(bookinfo2);
			}
		} else {
			System.out.println("û��ͼ����Ϣ��");
		}
	}

	public void showAllBookinfo() {
		List<Bookinfo> bookinfos = bookinfoBiz.queryAllBookinfo();
		if (bookinfos.size() > 0) {
			for (Bookinfo bookinfo : bookinfos) {
				System.out.println(bookinfo);
			}
		} else {
			System.out.println("û��ͼ����Ϣ��");
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
						results.add(book.getbName()+ " �ɽ裡" + "���Զ�ɾ��ԤԼ��¼������");
					} else {
						results.add(book.getbName()+ " �ɽ裡" + "�Զ�ɾ��ԤԼ��¼ʧ��!!!");
					}
				} else {
					results.add(bid + "\t���ɽ�");
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
			System.out.println("���ָ��³ɹ���");
		} else {
			System.out.println("���ָ���ʧ�ܣ�");
		}
	}

	public void showAllComments() {
		List<Comments2> comms2 = commentsBiz.queryAllComments2();
		if (comms2.size() > 0) {
			for (Comments2 comm2 : comms2) {
				System.out.println(comm2);
			}
		} else {
			System.out.println("��������Ϣ!");
		}
	}

	public void showCommentsByBid() {
		while (true) {
			System.out.println("��������Ҫ�鿴ͼ������֣�");
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
					System.out.println("��������Ϣ!");
					break;
				}
			} else {
				System.out.println("ͼ����޴�ͼ�飡");
				break;
			}
		}
	}

	public void modifyComments() {
		User quser = userDao.queryUserByName(user.getuName());
		System.out.println("��������Ҫ�޸ĵ����ۼ�¼ID��");
		int key = InputInt();
		Comments comm = commentsBiz.queryCommentsByCid(key);
		if (comm != null) {
			int cuid = comm.getUid();
			if (quser.getUid() == cuid) {
				System.out.println("���������֣��������100�֣���");
				comm.setScore(InputInt());
				System.out.println("���������100���ڣ���");
				comm.setComments(input.nextLine());
				if (commentsBiz.modifyComments(comm)) {
					System.out.println("�޸����۳ɹ�������");
					Evaluation_certer();
				} else {
					System.out.println("�޸�����ʧ�ܣ�����");
					Evaluation_certer();
				}
			} else {
				System.out.println("�������޸ı��˵����ۼ�¼������");
				Evaluation_certer();
			}
		} else {
			System.out.println("�޴�������Ϣ����˶Ժ��ٽ��в���������");
		}
	}

	public void addComments(Bookinfo bookinfo) {
		User quser = userDao.queryUserByName(user.getuName());
		Comments comm = null;
		System.out.println("�Ƿ�������ۣ�1.��-2.�񣩣�");
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
					System.out.println("���������֣�ֻ��Ϊ�������������100�֣����0�֣���");
					while (true) {
						int score = InputInt();
						if (score >= 0 && score <= 100) {
							comm.setScore(score);
							break;
						} else {
							System.out.println("��Ǹ������ҪС�ڻ����100�����ڻ����0�����������룺");
						}
					}
					System.out.println("���������50���ڣ����������Զ�ȥ��������");
					String commy = input.nextLine();
					if (commy.length() > 150) {
						commy = commy.substring(0, 100);
					}
					comm.setComments(commy);
					if (commentsBiz.addComments(comm)) {
						System.out.println("���۳ɹ�����");
						userMenu();
						break;
					} else {
						System.out.println("����ʧ�ܣ���");
						userMenu();
						break;
					}
				} else {
					System.out.println("��Ǹ���ǹ���Ա�������ۣ�");
					adminiMenu();
					break;
				}
			} else {
				System.out.println("������1��2��");
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
			System.out.println("�޽����¼!");
		}
	}

	public void showAllBooks() {
		List<Book> books = bookBiz.queryAllBooks();
		if (books.size() > 0) {
			for (Book book : books) {
				System.out.println(book);
			}
		} else {
			System.out.println("��ͼ����Ϣ!");
		}
	}

	public void showBooks_top_five() {
		int number = 0;
		int count = bookBiz.queryAllBooks().size();
		if (count == 0) {
			System.out.println("��ͼ����Ϣ!");
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
			System.out.println("��ͼ����Ϣ��");
		}
	}

	public void showMyRecords(User user) {
		List<Record> records = recordBiz.queryUserRecords(user.getuName());
		if (records.size() > 0) {
			for (Record record : records) {
				System.out.println(record);
			}
		} else {
			System.out.println("�޼�¼��Ϣ!");
		}
	}

	public void lendBook() {
		int yon = 0;
		boolean type = true;
		showAllBooks();
		System.out
				.println("Ϊ���ô�Ҷ��ܽ赽��Ҫ���飬�Ҳ��صȴ�̫�ã�\nͼ��ݹ涨ÿ��������ͬʱ���ֻ�����ı�δ�黹���飡����");
		User quser = userDao.queryUserByName(user.getuName());
		if (quser.isAdmini() == 1) {
			System.out.println("�������û�����");
			String uname = input.nextLine();
			quser = userDao.queryUserByName(uname);
			if (quser != null) {
				if (quser.isFrozen() == 1) {
					SystemView.userFrozenView();
					type = false;
				} else {
				}
			} else {
				System.out.println("��Ǹ������û�û��ע�ᣬ��˶Ժ��ٽ��в���������");
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
			System.out.println("��Ǹ�����Ѿ������ı��飬�һ�δ�黹��\n������Ϊ�黹���е�����һ��ǰ�������ٽ��飡");
			return;
		}
		if (type) {
			System.out.println("��������Ҫ���������");
			while (true) {
				String bName = input.nextLine();
				Book book = bookBiz.queryBookByName(bName);
				if (book != null) {
					int bid = book.getBid();
					int res = bookinfoBiz.lendBook(bName, quser.getUid());
					if (res == 1) {
						if(userDao.queryUserByName(user.getuName()).isAdmini()==0){
							System.out.println("�����Խ裬�Ѿ�ȫ���������ԤԼ��");
							// System.out.println("���ɵ�ԤԼ���Ľ���ԤԼ����ԤԼ�ɹ����ǽ��������´ε�½ʱ�������Ƿ�ɽ裡");
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
								System.out.println("����1����ԤԼ���������������˳���");
								yon = InputInt();
								if (yon == 1) {
									Reservation(book);
								}
						}else{
							System.out.println("���Ѿ�ԤԼ���Ȿ�飡");
						}
					}else{
						System.out.println("�����ܰ��û�ԤԼ��");
					}
						break;
					} else if (res == 2) {
						System.out.println("����ɹ���");
						appointBiz.delAppointmentByUid_Bid(quser.getUid(), bid);
						break;
					} else if (res == 3) {
						System.out.println("���ʧ�ܣ�");
						break;
					} else {
						System.out.println("û��ͼ����Ϣ");
						break;
					}
				} else {
					System.out.println("ͼ���û���Ȿͼ�飡");
					System.out.println("������������1���������������˳���");
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
			System.out.println("������Ҫ�黹����ʱ��¼���û���:");
			// String uname = InputName();
			String uname = input.nextLine();
			quser = userDao.queryUserByName(uname);
			if (quser == null) {
				System.out.println("������û�������,��˶Ժ���в�����лл������");
				return;
			}
		}
		System.out.println("�û�" + quser.getuName() + "���н軹��¼����:");
		showMyRecords(quser);
		System.out.println("������Ҫ�黹�鼮�ļ�¼��ϢID:");
		int rid = InputInt();
		Record qrecord = recordBiz.queryRecordByRid(rid);
		if (qrecord == null) {
			System.out.println("�޴˼�¼��Ϣ");
		} else {
			if (qrecord.getReturnTime() != null) {
				System.out.println("ͼ���Ѿ��黹�������ٴι黹��");
			} else {
				qrecord.setUid(quser.getUid());// ���ݵ�¼�˻���ѯ����uid
				Bookinfo bookinfo = bookinfoBiz.queryBookinfoById(qrecord
						.getId());
				System.out.println("�������Ƿ�ʧ��0-û�ж�ʧ��1-��ʧ��:");
				int Lost = InputInt();
				if (Lost == 0) {
					bookinfo.setLost(Lost);
					System.out.println("�������Ƿ����������𻵣�0-û���𻵣�1-�𻵣�:");
					while (true) {
						int State = InputInt();
						if (State != 0 && State != 1) {
							System.out.println("�������������0��1:");
						} else {
							bookinfo.setState(State);
							break;
						}
					}
					int res = bookinfoBiz.returnBook(qrecord, bookinfo);
					if (res == 1) {
						System.out.println("�������벻��ȷ:");
					} else if (res == 2) {
						System.out.println("�Ѿ��黹!");
					} else if (res == 3) {
						System.out.println("�黹�ɹ�!");
						updatePiontandFreezeUser(rid, 0, bookinfo.getState());// �޸Ļ���
						System.out.println("ʣ����֣�"
								+ userDao.queryUserByName(quser.getuName())
										.getPoint());
						if (userDao.queryUserByName(user.getuName()).isAdmini() == 0) {
							addComments(bookinfo);// Ϊʲô������û����.����
						} else {
							System.out.println("��Ϊ���ǹ���Ա���Բ��ܽ������ۣ�����");
							adminiMenu();
						}
					} else if (res == 4) {
						System.out.println("�黹ʧ��!");
					} else {
						System.out.println("��Ǹ�����ܻ����˵���!");
					}
				} else if (Lost == 1) {
					bookinfo.setLost(Lost);
					bookinfo.setInout(1);
					bookinfoBiz.returnBook(qrecord, bookinfo);
					updatePiontandFreezeUser(rid, 1, bookinfo.getState());// �޸Ļ���
					System.out.println("��¼�ɹ�!");
				} else {
					System.out.println("�������");
				}
			}
		}
	}

	public void updateUsernameandpass() {
		User quser = userDao.queryUserByName(user.getuName());
		System.out.println("ֻ�ܰ������ģ�Ӣ�ģ����ֺ��»��ߡ���");
		System.out.println("�������޸ĺ���û�����");
		// String name = InputName();
		String name = input.nextLine();
		// TODO
		User quser1 = userDao.queryUserByName(name);
		if (quser1 != null) {
			System.out.println("���û����Ѿ���ע���ˣ�");
		} else {
			System.out.println("ֻ�ܰ���Ӣ�ĺ����֡���");
			System.out.println("�������޸ĺ������:");
			// String pass = InputPass();
			String pass = input.nextLine();
			if (name.matches("^[\u4e00-\u9fa5\\w]+$")
					&& pass.matches("^[a-zA-Z0-9]+$")) {
				quser.setuName(name);
				quser.setuPass(pass);
			} else {
				System.out.println("�û����������ʽ���ԣ�����");
				System.out.println("�뿴��ʾ��лл����������");
				System.out.println("�û���ֻ�ܰ������ģ�Ӣ�ģ����ֺ��»��ߡ���");
				System.out.println("����ֻ�ܰ���Ӣ�ĺ����֡���");
				Account_center();
			}
			if (userDao.updateUser(quser)) {
				user.setuName(name);
				user.setuPass(pass);
				System.out.println("�޸ĳɹ�!");
			} else {
				System.out.println("�޸�ʧ��!");
			}
		}
	}

	public void addBook() {// ���ͼ��ʱ���ж��Ƿ��Ѿ������Ȿ�飬�������ֻ�������
		Book book = new Book();
		Bookinfo boin = null;
		int cunt = 0;
		int ty = 0;
		int count;
		String bname;
		System.out.println("����������:");
		bname = input.nextLine();
		Book qbook = bookBiz.queryBookByName(bname);
		if (qbook != null) {
			System.out.println("�Ȿ���Ѿ�����ͼ����ˣ���������Ҫ��ӵ�����:");
			int number = InputInt();
			boin = new Bookinfo(qbook.getBid(), 1, 0, 0);
			qbook.setCount(qbook.getCount() + number);
			for (int i = 0; i < number; i++) {
				if (bookinfoBiz.addBookinfo(boin) && bookBiz.modifyBook(qbook)) {
					cunt++;
				}
			}
			if (cunt == number) {
				System.out.println("ͼ�����Ϣ���Ѿ����£�");
			} else {
				System.out.println("ͼ�����Ϣ�����ʧ�ܣ�");
			}
		} else {
			System.out.println("����������:");
			while (true) {
				count = InputInt();
				if (count > 0) {
					break;
				} else {
					System.out.println("��������ȷ���������������룺");
				}
			}
			SystemView.showTypeView();
			System.out.println("��������������:");
			while (true) {
				int type = InputInt();
				if (type > 0 && type < 9) {
					ty = type;
					break;
				} else {
					System.out.println("û���������������ͣ����������룺");
				}
			}
			System.out.println("��������������:");
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
				System.out.println("ͼ�����Ϣ���Ѿ����£�");
			} else {
				System.out.println("ͼ�����Ϣ�����ʧ�ܣ�");
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
			System.out.println("û�м�¼������");
		}
	}

	public void modifyFreezeUser() {
		System.out.println("������Ҫ�ⶳ��¼��ID��");
		int fid = InputInt();
		Frozen frozen = frozenBiz.queryFrozenByFid(fid);
		if (frozen != null) {
			if (frozenBiz.modifyFrozen(fid)) {
				if (userDao.updateUserPoint(frozen.getUid(), 10, 0)) {
					System.out.println("�ⶳ�ɹ���");
				} else {
					System.out.println("�ⶳʧ�ܣ�");
				}
			} else {
				System.out.println("�ⶳʧ�ܣ������¼ID�Ƿ���ȷ������");
			}
		} else {
			System.out.println("û�д˼�¼����˶Ժ��ٲ�����");
		}
	}

	public void Reservation(Book book) {
		User quser = userDao.queryUserByName(user.getuName());
//		System.out.println("������ԤԼͼ�����֣�");
//		String bname = input.nextLine();
//		Book qbook = null;
//		qbook = bookBiz.queryBookByName(bname);
		if (book != null) {
			int bid = book.getBid();
			if ((book.getCount() + book.getHasLended())
					- appointBiz.queryAppoinByBid(bid).size() > 0) {
				if (appointBiz.addAppointment(quser.getUid(), bid)) {
					System.out.println("ԤԼ�ɹ�!");
				} else {
					System.out.println("ԤԼʧ�ܣ�");
				}
			} else {
				System.out.println("û�ж����ͼ�����ԤԼ��");
			}
		} else {
			System.out.println("û�д�ͼ�飡����");
		}
	}

	public void modifyReservation() {
		Book book = null;
		User quser = userDao.queryUserByName(user.getuName());
		System.out.println("������Ҫ�޸ĵ�ԤԼ��¼ID��");
		int aid = InputInt();
		Appointment appoint = appointBiz.queryAppoinByAid(aid);
		if (appoint != null) {
			System.out.println("������Ҫ�޸ĺ��ͼ������");
			String bname = input.nextLine();
			book = bookBiz.queryBookByName(bname);
			if (book != null) {
				int uid = quser.getUid();
				int bid = book.getBid();
				if ((book.getCount()+book.getHasLended()) - appointBiz.queryAppoinByBid(bid).size() > 0) {
					if (appoint.getUid() == uid) {
						if (appointBiz.modifyAppointmentByAid(aid, bid)) {
							System.out.println("�޸ĳɹ���");
						} else {
							System.out.println("�޸�ʧ�ܣ�");
						}
					} else {
						System.out.println("�㲻���޸ı��˵�ԤԼ��¼��");
					}
				} else {
					System.out.println("��ҪԤԼ��ͼ��û��ԤԼ������!");
				}
			} else {
				System.out.println("ͼ����޴�ͼ�飡");
			}
		} else {
			System.out.println("û������ԤԼ��¼����˶Ժ��ٲ�����");
		}
	}

	public void delReservation() {
		int uid = userDao.queryUserByName(user.getuName()).getUid();
		List<Appointment> appoints = appointBiz.queryAppointByUid(uid);
		if(appoints==null){
			System.out.println("��û��ԤԼ��¼��");
			return;
		}else{
			showAllReservationByUid();
			System.out.println("��������Ҫɾ����ԤԼ��¼ID:");
			int aid = InputInt();
			Appointment appoint = appointBiz.queryAppoinByAid(aid);
			if (appoint != null) {
				int quid = appoint.getUid();
				if (uid == quid) {
					if (appointBiz.delAppointment(aid)) {
						System.out.println("ɾ���ɹ���");
					} else {
						System.out.println("ɾ��ʧ�ܣ�");
					}
				} else {
					System.out.println("������ɾ�����˵�ԤԼ��¼��");
				}
			} else {
				System.out.println("�޴�ԤԼ��¼����˶Ժ��ٲ�����");
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
			System.out.println("��û��ԤԼ��¼��");
		}
	}

	public void showAllReservation() {
		List<Appointment2> appoints2 = appointBiz.queryAllAppoin2();
		if (appoints2.size() > 0) {
			for (Appointment2 appoint2 : appoints2) {
				System.out.println(appoint2);
			}
		} else {
			System.out.println("û��ԤԼ��¼��");
		}
	}
}
