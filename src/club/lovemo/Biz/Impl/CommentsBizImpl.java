package club.lovemo.Biz.Impl;

import java.util.List;

import club.lovemo.Biz.CommentsBiz;
import club.lovemo.Dao.CommentsDao;
import club.lovemo.Dao.Impl.CommentsDaoImpl;
import club.lovemo.Entity.Comments;
import club.lovemo.Entity.Comments2;

public class CommentsBizImpl implements CommentsBiz {
//ÆÀ¼Û±í
	private CommentsDao commentsDao=null;
	public CommentsBizImpl(){
		commentsDao=new CommentsDaoImpl();
	}
	@Override
	public boolean addComments(Comments comm) {
		return commentsDao.addComments(comm);
	}

	@Override
	public boolean delComments(int cid) {
		return commentsDao.deleteComments(cid);
	}

	@Override
	public boolean modifyComments(Comments comm) {
		return commentsDao.updateComments(comm);
	}

	@Override
	public List<Comments> queryAllComments() {
		return commentsDao.queryAllComments();
	}

	@Override
	public List<Comments> queryCommentsByBid(int bid) {
		return commentsDao.queryCommentsByBid(bid);
	}
	@Override
	public Comments queryCommentsByCid(int cid) {
		return commentsDao.queryCommentsByCid(cid);
	}
	@Override
	public List<Comments2> queryAllComments2() {
		return commentsDao.queryAllComments2();
	}

}
