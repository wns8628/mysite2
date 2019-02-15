package com.douzone.mysite.action.board;
import com.douzone.mvc.action.AbstractActionFactory;
import com.douzone.mvc.action.Action;
import com.douzone.mysite.action.main.IndexAction;

public class BoardActionFactory extends AbstractActionFactory {

	@Override
	public Action getAction(String actionName){

		Action action =null;
		
		if("list".equals(actionName)) {
			action = new ListAction();
		} else if("view".equals(actionName)) {
			action = new ViewAction();		
		} else if("modifyform".equals(actionName)) {
			action = new ModifyFormAction();		
		} else if("modify".equals(actionName)) {
			action = new ModifyAction();		
		} else if("writeform".equals(actionName)) {
			action = new WriteFormAction();		
		} else if("write".equals(actionName)) {
			action = new WriteAction();		
		} else if("replyform".equals(actionName)) {
			action = new ReplyFormAction();		
		} else if("reply".equals(actionName)) {
			action = new ReplyAction();		
		} else if("delete".equals(actionName)) {
			action = new DeleteAction();		
		} else if("comment".equals(actionName)) {
			action = new CommentAction();		
		} else if("commentdeleteform".equals(actionName)) {
			action = new CommentDeleteFormAction();		
		} else if("commentdelete".equals(actionName)) {
			action = new CommentDeleteAction();		
		} else if("commentmodifyform".equals(actionName)) {
			action = new CommentModifyFormAction();		
		} else if("commentmodify".equals(actionName)) {
			action = new CommentModifyAction();		
		} else if("commentreplyform".equals(actionName)) {
			action = new CommentReplyFormAction();		
		} else if("commentreply".equals(actionName)) {
			action = new CommentReplyAction();		
		} else {
			action = new ListAction();
		}
		
		return action;

	}
}
