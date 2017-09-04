package club.lovemo.Dao.Impl;

import java.util.ArrayList;
import java.util.List;

import club.lovemo.Dao.CommentsDao;
import club.lovemo.Entity.Comments;
import club.lovemo.Entity.Comments2;

public class CommentsDaoImpl extends BaseDao implements CommentsDao {

	@Override
	public boolean addComments(Comments comm) {
		String sql = "insert into comments(uid,bid,score,comments)values(?,?,?,?)";
		List<Object> params = new ArrayList<Object>();
		params.add(comm.getUid());
		params.add(comm.getBid());
		params.add(comm.getScore());
		params.add(comm.getComments());
		return this.operUpdate(sql, params);
	}

	@Override
	public boolean deleteComments(int cid) {
		String sql = "delete from comments where cid=?";
		List<Object> params = new ArrayList<Object>();
		params.add(cid);
		return this.operUpdate(sql, params);
	}

	@Override
	public boolean updateComments(Comments comm) {
		String sql="update comments set score=?,comments=? where uid=? and bid=?";
		List<Object> params= new ArrayList<Object>();
		params.add(comm.getScore());
		params.add(comm.getComments());
		params.add(comm.getUid());
		params.add(comm.getBid());
		return this.operUpdate(sql, params);
	}

	@Override
	public List<Comments> queryAllComments() {
		String sql = "select * from comments";
		List<Comments> cList = null;
		try {
			cList = this.operQuery(sql, null, Comments.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cList;
	}

	@Override
	public List<Comments> queryCommentsByBid(int bid) {
		String sql = "select * from comments where bid=?";
		List<Object> params=new ArrayList<Object>();
		List<Comments> cList = null;
		params.add(bid);
		try {
			cList = this.operQuery(sql, params, Comments.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cList;
	}

	@Override
	public Comments queryCommentsByCid(int cid) {
		String sql = "select * from comments where cid=?";
		List<Object> params=new ArrayList<Object>();
		List<Comments> cList = null;
		params.add(cid);
		try {
			cList = this.operQuery(sql, params, Comments.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(cList.size()>0){
		return cList.get(0);
		}
		return null;
	}

	@Override
	public List<Comments2> queryAllComments2() {
		// TODO ‘› ±À„–¥ÕÍ
		String sql = "select c.cid,u.uid,u.uName,b.bid,b.bName,c.score,c.comments from users u,books b,comments c where u.uid=c.uid and b.bid=c.bid";
		List<Comments2> cList2 = null;
		try {
			cList2 = this.operQuery(sql, null, Comments2.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cList2;
	}

}
