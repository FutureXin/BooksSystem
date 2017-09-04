package club.lovemo.Biz;

import java.util.List;

import club.lovemo.Entity.Comments;
import club.lovemo.Entity.Comments2;

public interface CommentsBiz {
	public boolean addComments(Comments comm);// 添加评论信息

	public boolean delComments(int cid);// 删除指定用户对指定图书的评价记录，仅限本人

	public boolean modifyComments(Comments comm);// 修改指定用户对指定图书的评价，仅限本人

	public List<Comments> queryAllComments();// 查询所有评论信息

	public List<Comments> queryCommentsByBid(int bid);// 根据书表ID查询指定图书的评价信息
	
	public Comments queryCommentsByCid(int cid);//根据评价ID查询记录
	
	public List<Comments2> queryAllComments2();
}
